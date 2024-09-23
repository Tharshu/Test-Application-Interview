package com.application.test.transformer;

import com.application.test.dto.UserDto;
import com.application.test.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer {

    public UserDto entityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setActive(user.getActive());
        return userDto;
    }

    public User dtoToEntity(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setActive(userDto.getActive());

        return user;
    }
}
