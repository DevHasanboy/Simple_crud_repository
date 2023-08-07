package com.example.simple_crud.service;

import com.example.simple_crud.dto.ResponseDto;
import com.example.simple_crud.dto.SimpleCrud;
import com.example.simple_crud.dto.UserDto;
import com.example.simple_crud.model.User;
import com.example.simple_crud.repository.UserRepository;
import com.example.simple_crud.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements SimpleCrud<Integer, UserDto> {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public ResponseDto<UserDto> create(UserDto dto) {
      try {
          User user=this.userMapper.toEntity(dto);
          user.setCreatedAt(LocalDateTime.now());
          this.userRepository.save(user);
          return ResponseDto.<UserDto>builder()
                  .success(true)
                  .message("ok")
                  .data(this.userMapper.toDto(user))
                  .build();
      }
      catch (Exception e){
          return ResponseDto.<UserDto>builder()
                  .code(-1)
                  .message(String.format("user while is error %s saving",e.getMessage()))
                  .build();
      }
    }

    @Override
    public ResponseDto<UserDto> get(Integer id) {
        Optional<User> optional=this.userRepository.findByIdAndDeletedAtIsNull(id);
        if(optional.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("not found of %d id",id))
                    .build();
        }
//        return ResponseDto.<UserDto>builder()
//                .success(true)
//                .message("ok")
//                .data(this.userMapper.toDto(optional.get()))
//                .build();

      return   this.userRepository.findByIdAndDeletedAtIsNull(id)
                .map(user ->
                    ResponseDto.<UserDto>builder()
                            .success(true)
                            .message("ok")
                            .data(this.userMapper.toDto(user))
                            .build()
                ).orElse(ResponseDto.<UserDto>builder()
                        .code(-2)
                        .message("error")
                        .build());

    }

    @Override
    public ResponseDto<UserDto> update(Integer id, UserDto dto) {
        Optional<User> optional=this.userRepository.findByIdAndDeletedAtIsNull(id);
        if(optional.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("not found of %d id",id))
                    .build();
        }
//        try {
//            User user=optional.get();
//            this.userMapper.toUpdateFromDto(user,dto);
//            user.setDeletedAt(LocalDateTime.now());
//            this.userRepository.save(user);
//
//
//        return ResponseDto.<UserDto>builder()
//                .success(true)
//                .message("ok")
//                .data(this.userMapper.toDto(user))
//                .build();
//        }
//        catch (Exception e){
//                return ResponseDto.<UserDto>builder()
//                        .code(-1)
//                        .message(String.format("user while is error %s saving",e.getMessage()))
//                        .build();

          return   this.userRepository.findByIdAndDeletedAtIsNull(id)
                    .map(user -> {
                        this.userMapper.toUpdateFromDto(user,dto);
                        user.setDeletedAt(LocalDateTime.now());
                        this.userRepository.save(user);


                        return ResponseDto.<UserDto>builder()
                                .success(true)
                                .message("ok")
                                .data(this.userMapper.toDto(user))
                                .build();
                    })
                    .orElse(ResponseDto.<UserDto>builder()
                            .code(-1)
                            .message(("user while is error %s saving"))
                            .build());


        }


    @Override
    public ResponseDto<UserDto> delete(Integer id) {
        Optional<User> optional=this.userRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()){
            return ResponseDto.<UserDto>builder()
                    .code(-1)
                    .message(String.format("not found of %d id",id))
                    .build();
        }
//        User user=optional.get();
//        user.setDeletedAt(LocalDateTime.now());
//        this.userRepository.save(user);
//        return ResponseDto.<UserDto>builder()
//                .message("ok")
//                .success(true)
//                .data(this.userMapper.toDto(user))
//                .build();


     return    this.userRepository.findByIdAndDeletedAtIsNull(id)
                .map(user ->{
                    user.setDeletedAt(LocalDateTime.now());
                    this.userRepository.save(user);
                    return ResponseDto.<UserDto>builder()
                            .message("ok")
                            .success(true)
                            .data(this.userMapper.toDto(user))
                            .build();
                } )
                .orElse(
                        ResponseDto.<UserDto>builder()
                                .code(-1)
                                .message(String.format("not found of %d id",id))
                                .build()
                );

    }
}
