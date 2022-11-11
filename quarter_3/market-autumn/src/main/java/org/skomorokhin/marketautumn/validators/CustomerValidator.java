package org.skomorokhin.marketautumn.validators;

import org.skomorokhin.marketautumn.dto.CustomerDto;
import org.skomorokhin.marketautumn.exceptions.ValidateException;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {

    public void validate(CustomerDto customerDto) {
        List<String> errors = new ArrayList<>();

        if (customerDto.getName().isBlank()) {
            errors.add("Имя покупателя не может быть пустым");
        }
        if (!errors.isEmpty()) {
            throw new ValidateException(errors);
        }
    }
}
