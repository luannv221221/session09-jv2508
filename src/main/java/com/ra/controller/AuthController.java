package com.ra.controller;

import com.ra.dto.request.UserLoginRequestDTO;
import com.ra.dto.request.UserRegisterRequestDTO;
import com.ra.dto.response.ResponseWrapper;
import com.ra.dto.response.UserLoginResponseDTO;
import com.ra.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterRequestDTO userRegisterRequestDTO){
        ResponseWrapper<?> responseWrapper = authService.register(userRegisterRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseWrapper);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequestDTO userLoginRequestDTO){
        UserLoginResponseDTO responseDTO = authService.login(userLoginRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).
                body(ResponseWrapper.success(responseDTO,"Dang nhap thanh cong",HttpStatus.OK.value()));
    }
}
