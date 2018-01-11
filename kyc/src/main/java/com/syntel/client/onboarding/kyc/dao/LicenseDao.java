package com.syntel.client.onboarding.kyc.dao;

import com.syntel.client.onboarding.kyc.entity.DriversLicense;
import com.syntel.client.onboarding.kyc.vo.customer.LicenseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

@Component
public class LicenseDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String find(LicenseInfo licenseInfo) {

        String result = jdbcTemplate.query(
                "SELECT license_number, first_name, last_name, state " +
                        "FROM drivers_license_tb where license_number = ?",
                new Object[]{licenseInfo.getLicenseNumber()}, new ResultSetExtractor<String>() {
                    String licenseNumber;
                    String firstName;
                    String lastName;
                    String state;
                    @Override
                    public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                        while (rs.next()) {
                            licenseNumber = rs.getString("license_number");
                            firstName = rs.getString("first_name");
                            lastName = rs.getString("last_name");
                            state = rs.getString("state");
                            System.out.println("Data from DB");
                            System.out.println(licenseNumber + " " + firstName + " " +lastName + " " +state);

                            if (licenseInfo.getLicenseNumber().equals(licenseNumber) &&
                                    licenseInfo.getCustomerInfo().getFirstName().equals(firstName) &&
                                    licenseInfo.getCustomerInfo().getLastName().equals(lastName) &&
                                    licenseInfo.getState().equals(state)) {
                                System.out.println("MATCH FOUND");
                                return "FOUND";
                            }
                        }
                        System.out.println("MATCH NOT FOUND");
                        return null;
                    }
                }
        );
        return result;
    }
}
