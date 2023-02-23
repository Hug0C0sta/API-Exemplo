package com.primeiraapi.converters;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class NumberConverter {
    public boolean isNumeric(String strNumber) {
        try {
            double number = Double.parseDouble(strNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public Double convertToDouble(String strNumber) {
        if (isNumeric(strNumber)) return Double.parseDouble(strNumber);
        return 0D;
    }
}
