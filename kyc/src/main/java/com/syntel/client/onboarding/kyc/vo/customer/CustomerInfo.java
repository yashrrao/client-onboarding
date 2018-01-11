package com.syntel.client.onboarding.kyc.vo.customer;

public class CustomerInfo {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "[First Name = " +this.firstName + "] ~ " +
                "[Last Name = " +this.lastName + "] ~ ";
    }
}
