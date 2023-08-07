package com.example.simple_crud.controller;

import com.example.simple_crud.dto.ResponseDto;
import com.example.simple_crud.dto.SimpleCrud;
import com.example.simple_crud.dto.UserDto;
import com.example.simple_crud.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController implements SimpleCrud<Integer, UserDto> {
    private final UserService userService;

    @PostMapping(value = "/create")
    @Override
    public ResponseDto<UserDto> create(@RequestBody  @Valid UserDto dto) {
        return this.userService.create(dto);
    }

    @GetMapping(value = "/get/{id}")
    @Override
    public ResponseDto<UserDto> get(@PathVariable(value = "id") Integer id) {
        return this.userService.get(id);
    }

    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseDto<UserDto> update(@PathVariable(value = "id") Integer id, @RequestBody UserDto dto) {
        return this.userService.update(id, dto);
    }

    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseDto<UserDto> delete(@PathVariable(value = "id") Integer id) {
        return this.userService.delete(id);
    }
}