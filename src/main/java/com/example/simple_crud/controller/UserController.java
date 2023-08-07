package com.example.simple_crud.controller;

import com.example.simple_crud.dto.ResponseDto;
import com.example.simple_crud.dto.SimpleCrud;
import com.example.simple_crud.dto.UserDto;
import com.example.simple_crud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.links.Link;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController implements SimpleCrud<Integer, UserDto> {
    private final UserService userService;

    @Operation(
            method = "create method",
            description = "this is the create method",
            summary = "this is the enters the user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "this is the create method",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )

            ),
            responses = @ApiResponse(
                    description = "there is not create here",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    ),
                    links = @Link(
                            name = "simple crud",
                            description = "there is a simple crud"
                    )
            )


    )
    @PostMapping(value = "/create")
    @Override
    public ResponseDto<UserDto> create(@RequestBody  @Valid UserDto dto) {
        return this.userService.create(dto);
    }

    @Operation(
            method = "get method",
            description = "there is the get method",
            summary = "there is the excite user",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "there is the get method",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
            ),
            responses = @ApiResponse(
                    description = "there is not get ",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE),
                    links = @Link(
                            name = "simple crud",
                            description = "there is the simple crud"
                    )
            )
    )
    @GetMapping(value = "/get/{id}")
    @Override
    public ResponseDto<UserDto> get(@PathVariable(value = "id") Integer id) {
        return this.userService.get(id);
    }
@Operation(
        method = " put method",
        description = "there is the put method",
        summary = "there is the update user",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "there is the update method",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        ),
        responses = @ApiResponse(
                description = "there is not update ",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE),
                links = @Link(
                        name = "update method",
                        description = "there is the method update"
                )
        )
)
    @PutMapping(value = "/update/{id}")
    @Override
    public ResponseDto<UserDto> update(@PathVariable(value = "id") Integer id, @RequestBody UserDto dto) {
        return this.userService.update(id, dto);
    }
@Operation(
        method = "delete method",
        description = "there is the delete method ",
        summary = "there is the delete user",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "there is the delete method",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        ),
        responses = @ApiResponse(
                description = "there is not delete",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE),
                links = @Link(
                        description = "there is the updated",
                        name = "update user"
                )
        )
)
    @DeleteMapping(value = "/delete/{id}")
    @Override
    public ResponseDto<UserDto> delete(@PathVariable(value = "id") Integer id) {
        return this.userService.delete(id);
    }
}