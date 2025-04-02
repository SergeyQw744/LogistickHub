package org.example.validator;

import org.springframework.stereotype.Component;

@Component
public class PageNumberValidator {

    public boolean validate(int page){
        return page < 0;
    }
}
