package com.syntel.client.onboarding.kyc.vo;

import com.syntel.client.onboarding.kyc.vo.address.AddressComponent;
import com.syntel.client.onboarding.kyc.vo.address.Geometry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private List<AddressComponent> addressComponents = null;
    private String formattedAddress;
    private Geometry geometry;
    private Boolean partialMatch;
    private String placeId;
    private List<String> types = null;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.addressComponents = addressComponents;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Boolean getPartialMatch() {
        return partialMatch;
    }

    public void setPartialMatch(Boolean partialMatch) {
        this.partialMatch = partialMatch;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
