package com.intern.demoproject.controller;

import com.intern.demoproject.dto.UserDto;
import com.intern.demoproject.dto.commom.ResponseHandler;
import com.intern.demoproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
@Tag(name = "UserController", description = "Users controller")
public class UserController {

    private final UserService userService;


    @GetMapping("")
    @Operation(summary = "Get all users", description = "Get all users")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Get all users",
                    content = {
                            @Content(
                                    schema = @Schema(implementation = UserDto.class),
                                    mediaType = "application/json")
                    })
    })
    public ResponseEntity<?> getUser(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {

        Page<UserDto> users = userService.findUser(page, size);

        return ResponseHandler.response(users.toList(), HttpStatus.OK, users.hasNext());
    }


    @GetMapping("/{id}")
    @Operation(summary = "getUserById", description = "Find <User> by id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = UserDto.class),
                            mediaType = "application/json"
                    )
            )
    })
    public ResponseEntity<?> getUser(
            @PathVariable Long id
    ) {

        UserDto user = userService.findUserById(id);

        return ResponseHandler.response(user, HttpStatus.OK, true);
    }


    @PutMapping("/{id}")
    @Operation(summary = "updateUser", description = "Update <User> by id")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(
                            schema = @Schema(implementation = UserDto.class),
                            mediaType = "application/json"
                    )
            )
    })
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody UserDto userDto
    ) {

        UserDto user = userService.updateUser(id, userDto);

        return ResponseHandler.response(user, HttpStatus.OK, true);
    }

}
