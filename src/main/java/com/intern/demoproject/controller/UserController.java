package com.intern.demoproject.controller;

import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.dto.commom.ResponseHandler;
import com.intern.demoproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping("")
    public ResponseEntity<?> getUser(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {

        Page<UserDto> users = userService.findUser(page, size);

        return ResponseHandler.response(users.toList(), HttpStatus.OK, users.hasNext());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(
            @PathVariable Long id
    ) {

        UserDto user = userService.findUserById(id);

        return ResponseHandler.response(user, HttpStatus.OK, true);
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody UserDto userDto
    ) {

        UserDto user = userService.updateUser(id, userDto);

        return ResponseHandler.response(user, HttpStatus.OK, true);
    }

}
