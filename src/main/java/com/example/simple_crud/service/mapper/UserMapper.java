//package com.example.simple_crud.service.mapper;
//
//import com.example.simple_crud.dto.UserDto;
//import com.example.simple_crud.model.User;
//import org.mapstruct.*;
//
//
//@Mapper(componentModel = "spring")
//public abstract class UserMapper {
//
//
//    @Mapping(target = "id",ignore = true)
//    @Mapping(target = "createdAt",ignore = true)
//    @Mapping(target = "deletedAt",ignore = true)
//    @Mapping(target = "updatedAt",ignore = true)
//    public abstract User toEntity(UserDto dto);
//
//
//    public abstract UserDto toDto(User user);
//
//    @Mapping(target = "createdAt",ignore = true)
//    @Mapping(target = "deletedAt",ignore = true)
//    @Mapping(target = "updatedAt",ignore = true)
//@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    public abstract void toUpdateFromDto(@MappingTarget User user, UserDto dto) ;
//}
