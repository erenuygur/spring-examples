package com.erenuygur.datajpapostgresrestapi.controller;

import com.erenuygur.datajpapostgresrestapi.dto.UserDto;
import com.erenuygur.datajpapostgresrestapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> listAllUser()
    {
        return ResponseEntity.ok(userService.getAll());
    }


}
