package com.app.coursesapp.service;

import com.app.coursesapp.dao.UserDao;
import com.app.coursesapp.dto.CreateUserDto;
import com.app.coursesapp.entity.User;
import com.app.coursesapp.mapper.CreateUserMapper;
import com.app.coursesapp.validator.CreateUserValidator;
import com.app.coursesapp.validator.ValidationResult;
import jakarta.xml.bind.ValidationException;

public class UserService {
    private static final  UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private  final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();


    public Integer create(CreateUserDto userDto){
        ValidationResult validationResult = createUserValidator.isValid(userDto);
//        if (!validationResult.isValid()){
//            throw new ValidationException(validationResult.getErrors());
//        }
        User user = createUserMapper.mapFrom(userDto);
        userDao.save(user);
        return user.getId();
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
