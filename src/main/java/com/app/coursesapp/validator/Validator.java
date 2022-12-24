package com.app.coursesapp.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
