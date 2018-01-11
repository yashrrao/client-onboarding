package com.syntel.client.onboarding.kyc.controller;

import com.syntel.client.onboarding.kyc.dao.LicenseDao;
import com.syntel.client.onboarding.kyc.vo.customer.LicenseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class DriverLicenseValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverLicenseValidator.class);

    private RestTemplate restTemplate;

    private LicenseDao licenseDao;

    public DriverLicenseValidator(RestTemplate restTemplate, LicenseDao licenseDao) {
        this.restTemplate = restTemplate;
        this.licenseDao =  licenseDao;
    }

    @RequestMapping ("/license/validate")
    @PostMapping
    public boolean validateDriversLicense(@RequestBody LicenseInfo licenseInfo) {

        System.out.println("validating drivers license");
        System.out.println(licenseInfo.toString());

        LOGGER.debug("validating drivers license");
        LOGGER.debug(licenseInfo.toString());

        String result = licenseDao.find(licenseInfo);
        if (result == null) {
            return false;
        }
        return true;
    }
}
