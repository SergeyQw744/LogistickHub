package org.example.validator;

import org.springframework.stereotype.Component;

@Component
public class TimeIntervalValidator {

    public boolean validate(long timeInterval){
        return timeInterval < 0L;
    }
}
