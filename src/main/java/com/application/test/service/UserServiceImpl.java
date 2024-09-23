package com.application.test.service;

import com.application.test.dto.UserDto;
import com.application.test.entity.User;
import com.application.test.repository.UserRepository;
import com.application.test.transformer.UserTransformer;
import com.application.test.utill.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserTransformer userTransformer;

    @Override
    public UserDto saveUser(UserDto userDto) {
        log.info("saveUser() invoked.");
        User user = userTransformer.dtoToEntity(userDto);
        User savedUser = userRepository.save(user);
        log.info("User with id: {} saved successfully.", savedUser.getId());
        return userTransformer.entityToDto(savedUser);
    }

//    @Override
//    public List<UserDto> getUser() {
//        return List.of();
//    }

    @Override
    public List<UserDto> getAllUser() {
        log.info("getAllUser() invoked.");
        List<User> userList = userRepository.findAll();
        return userList.stream().filter(e -> e.getActive().equals(Boolean.TRUE)).map(userTransformer::entityToDto).toList();
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        log.info("updateUser() invoked for id: {}", id);
        // Handle Optional properly
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Update
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setActive(userDto.getActive());

            // Save updated user
            User updatedUser = userRepository.save(user);
            log.info("User with id: {} updated successfully.", updatedUser.getId());
            return userTransformer.entityToDto(updatedUser);
        } else {
            log.warn("User with id: {} not found.", id);
            throw new UserNotFoundException("User with id " + id + " not found");
        }
    }

    @Override
    public String deleteUser(Long id) {
        log.info("deleteUser() invoked for id: {}", id);

        Optional<User> optuser = userRepository.findById(id);
        if (optuser.isPresent()) {
            User user = optuser.get();
            user.setActive(false);
            userRepository.save(user);
            log.info("User with id: {} has been deactivated.", id);
            return "User successfully deactivated.";
        } else {
            log.warn("User with id: {} not found.", id);
            return "User not found.";
        }
    }
}
