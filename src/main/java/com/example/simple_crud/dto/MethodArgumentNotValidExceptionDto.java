package com.example.simple_crud.dto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionDto {

@ExceptionHandler
    public ResponseEntity<ResponseDto<Object>> MethodArgumentNotValidException(MethodArgumentNotValidException e){

//    List<ErrorDto> list=e.getBindingResult()
//            .getFieldErrors()
//            .stream()
//            .map(fieldError -> {
//                String field=fieldError.getField();
//                String message=fieldError.getDefaultMessage();
//                String rejectionValue=String.valueOf(fieldError.getRejectedValue());
//                return new ErrorDto(field,String.format("message::%s,rejection ::%s",message,rejectionValue));
//            }).toList();

    return ResponseEntity.badRequest().body(ResponseDto.builder()
                .code(-3)
                .message("validation error")
                .errors(e.getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(fieldError -> {
                            String field=fieldError.getField();
                            String message=fieldError.getDefaultMessage();
                            String rejectionValue=String.valueOf(fieldError.getRejectedValue());
                            return new ErrorDto(field,String.format("message::%s,rejection ::%s",message,rejectionValue));
                        }).toList())



        .build());
    }
}




