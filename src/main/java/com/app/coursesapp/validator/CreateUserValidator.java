package com.app.coursesapp.validator;

import com.app.coursesapp.dto.CreateUserDto;
import com.app.coursesapp.entity.Gender;
import com.app.coursesapp.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    private static final CreateUserValidator INSTANCE = new CreateUserValidator();


    @Override
    public ValidationResult isValid(CreateUserDto object) {
        ValidationResult validationResult = new ValidationResult();
        if (!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid.birtday","Birthday is invalid"));
        }
        if (Gender.valueOf(object.getGender())== null){
            validationResult.add(Error.of("invalid.gender","Gender is invalid"));
        }
        return validationResult;
    }

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }

}
