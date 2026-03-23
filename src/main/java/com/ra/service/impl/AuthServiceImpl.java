package com.ra.service.impl;

import com.ra.dto.request.UserLoginRequestDTO;
import com.ra.dto.request.UserRegisterRequestDTO;
import com.ra.dto.response.ResponseWrapper;
import com.ra.dto.response.UserLoginResponseDTO;
import com.ra.entity.Role;
import com.ra.entity.User;
import com.ra.mapper.UserRegisterMapper;
import com.ra.repository.RoleRepository;
import com.ra.repository.UserRepository;
import com.ra.security.UserPrinciple;
import com.ra.security.jwt.JwtProvider;
import com.ra.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRegisterMapper userRegisterMapper;
    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public ResponseWrapper<?> register(UserRegisterRequestDTO userRegisterRequestDTO) {
        // kiem tra xem username da ton tai hay chua

        // Gan quyen mawc dinh la CUSTOMER
        Set<Role> roles = new HashSet<>();
        Role role = roleRepository.getRoleByRoleName("CUSTOMER");
        roles.add(role);

        // convert DTo-> E
        User user = userRegisterMapper.toUser(userRegisterRequestDTO);
        // set Role
        user.setRoles(roles);
        // ma hoa mk
        user.setPassword(new BCryptPasswordEncoder().encode(userRegisterRequestDTO.getPassword()));
        // set trang thai mac dinh dang ky moi laf true
        user.setStatus(true);
        userRepository.save(user);
        return ResponseWrapper.success(null,"Dang ky tai khoan thanh cong", HttpStatus.CREATED.value());
    }

    @Override
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        Authentication authentication;
        authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginRequestDTO.getUsername(),
                        userLoginRequestDTO.getPassword())
        );
        assert authentication != null;
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return UserLoginResponseDTO.builder()
                .token(jwtProvider.generateToken(userPrinciple))
                .fullName(userPrinciple.getUser().getFullName())
                .roles(userPrinciple.getUser().getRoles())
                .typeToken("Bearer Token")
                .username(userPrinciple.getUsername())
                .build();
    }
}
