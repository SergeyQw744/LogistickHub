package org.example.validator;

import org.springframework.stereotype.Component;

@Component
public class RegistrationNumberValidator {

    public boolean validate(String registrationNumber){
        if (registrationNumber.isBlank() || registrationNumber.length() != 9){
            return true;
        } else {
            return false;
        }
    }
}
