package com.ra.service;

import com.ra.dto.request.UserLoginRequestDTO;
import com.ra.dto.request.UserRegisterRequestDTO;
import com.ra.dto.response.ResponseWrapper;
import com.ra.dto.response.UserLoginResponseDTO;

public interface AuthService {
    ResponseWrapper<?> register(UserRegisterRequestDTO userRegisterRequestDTO);
    UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO);
}
