package ru.ekviron.service.order.application.exception;

import lombok.Getter;

/**
 * Created by Elena Vladi
 * on 12.08.18.
 */
public class InvalidFieldException extends Exception {

    @Getter
    private String field;

    public InvalidFieldException(final String field, final String message) {
        super(message);
        this.field = field;
    }

}
