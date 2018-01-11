package com.syntel.client.onboarding.kyc.vo.customer;

public class LicenseInfo {

    private CustomerInfo customerInfo;
    private String licenseNumber;
    private String issueDate;
    private String expiryDate;
    private String state;

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return this.customerInfo.toString() + "[License Number = " + this.licenseNumber + "] ~ " +
                "[State = " +this.state + "]";
    }
}
