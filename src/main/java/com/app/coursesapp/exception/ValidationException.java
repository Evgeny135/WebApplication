package com.app.coursesapp.exception;

import com.app.coursesapp.validator.Error;
import lombok.Getter;

import java.util.List;

public class ValidationException {
    @Getter
    private final List<Error> errors;

    public ValidationException(List<Error> errors) {
        this.errors = errors;
    }
}
