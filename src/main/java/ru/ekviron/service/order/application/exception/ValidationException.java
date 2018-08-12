package ru.ekviron.service.order.application.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 */
public class ValidationException extends Exception {

    @Getter
    private List<InvalidFieldException> errors = new ArrayList<>();

    public ValidationException(final String message) {
        super(message);
    }

    public void addError(final InvalidFieldException error) {
        errors.add(error);
    }

}
