package com.app.coursesapp.mapper;

import com.app.coursesapp.dto.CreateUserDto;
import com.app.coursesapp.entity.Gender;
import com.app.coursesapp.entity.Role;
import com.app.coursesapp.entity.User;
import com.app.coursesapp.util.LocalDateFormatter;

import java.time.LocalDate;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static  final CreateUserMapper INSTANCE = new CreateUserMapper();
    private static final String IMAGE_FOLDER = "users/";

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .email(object.getEmail())
                .password(object.getPassword())
                .gender(Gender.valueOf(object.getGender()))
                .role(Role.valueOf(object.getRole()))
                .image(IMAGE_FOLDER+ object.getImage().getSubmittedFileName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .build();
    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
