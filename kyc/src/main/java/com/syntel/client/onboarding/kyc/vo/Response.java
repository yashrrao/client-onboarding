package com.syntel.client.onboarding.kyc.vo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Response {

    private List<Result> results = null;
    private String status;
    private Map<String, Object> additionalProperties = new HashMap<>();

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
