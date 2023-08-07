package com.example.simple_crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    @NotBlank(message = "firstname cannot be null or empty")
    private String  firstname;
  @NotBlank(message = "lastname cannot be null or empty")
    private String lastname;
  @Email
    private String email;
  @NotBlank(message = "phoneNumber cannot be null or empty")
    private String phoneNumber;


    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private LocalDateTime updatedAt;
}
