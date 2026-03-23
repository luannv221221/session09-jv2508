package com.ra.mapper;

import com.ra.dto.request.UserRegisterRequestDTO;
import com.ra.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper {
    // chuyen E -> DTO
    UserRegisterRequestDTO toUserRegisterRequestDTO(User user);

    // chuyen DTO -> E
    User toUser(UserRegisterRequestDTO userRegisterRequestDTO);
}
