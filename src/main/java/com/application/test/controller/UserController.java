package com.application.test.controller;

import com.application.test.dto.UserDto;
import com.application.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @PostMapping()
    public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
        log.info("saveUser() invoked.");
        try {
            UserDto userDto1 = userService.saveUser(userDto);
            return ResponseEntity.ok(userDto1);
        } catch (Exception e){
            log.error("An unexpected error occurred while save the user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUser(){
        log.info("getUser() invoked.");
        try {
            List<UserDto> userDtoList = userService.getAllUser();
            return ResponseEntity.ok(userDtoList);
        } catch (Exception e){
            log.error("An unexpected error occurred while getting the user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody UserDto userDto){
        log.info("saveUser() invoked.");
        try {
            UserDto userDto1 = userService.updateUser(id,userDto);
            return ResponseEntity.ok(userDto1);
        } catch (Exception e){
            log.error("An unexpected error occurred while update the user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        log.info("saveUser() invoked.");
        try {
            String res = userService.deleteUser(id);
            return ResponseEntity.ok(res);
        } catch (Exception e){
            log.error("An unexpected error occurred while delete the user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
