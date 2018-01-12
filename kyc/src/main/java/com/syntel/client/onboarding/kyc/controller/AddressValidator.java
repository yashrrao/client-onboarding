package com.syntel.client.onboarding.kyc.controller;

import com.syntel.client.onboarding.kyc.vo.Response;
import com.syntel.client.onboarding.kyc.vo.Result;
import com.syntel.client.onboarding.kyc.vo.address.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.StringJoiner;

@RestController
public class AddressValidator {

    private String googleApiUrl = "https://maps.googleapis.com/maps/api/geocode/json?address=";

    private RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressValidator.class);

    public AddressValidator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * This RESTful api validates the permanent address against google api. Returns true if
     * it finds a result based on the search query.
     * @param permanentAddress
     * @return
     */
    @RequestMapping("/address/validate")
    @PostMapping
    public boolean validatePermanentAddress(@RequestBody Address permanentAddress) {

        Response response = executeValidation(permanentAddress);

        if (response != null) {
            return isValidAddress(response);
        }
        return false;

    }

    private Response executeValidation(Address address) {

        StringJoiner joiner = new StringJoiner("+");
        joiner.add(address.getStreet());
        joiner.add(address.getApt());
        joiner.add(address.getCity());
        joiner.add(address.getState());
        joiner.add(address.getZip());
        joiner.add(address.getCountry());

        LOGGER.debug(joiner.toString());

        System.out.println(joiner.toString());

        String addressApi = googleApiUrl + joiner.toString() + "&key=AIzaSyAl2HHUtYTljXVNtqnZewkD7AKlb6EMVM4";

        System.out.println(addressApi);

        LOGGER.debug(addressApi);

        Response response = this.restTemplate.getForObject(googleApiUrl+joiner.toString(), Response.class);

        return response;
    }

    private boolean isValidAddress(Response response) {
        if (response.getStatus().equals("OK")) {
            return true;
        }
        return false;
    }

}