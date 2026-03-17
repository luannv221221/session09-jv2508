package com.ra.controller;

import com.ra.dto.request.EmployeeRequestDTO;
import com.ra.dto.response.EmployeeResponseDTO;
import com.ra.dto.response.ResponseWrapper;
import com.ra.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<?> createEmployee(@ModelAttribute EmployeeRequestDTO employeeRequestDTO) {
        EmployeeResponseDTO employeeResponseDTO = employeeService.createEmployee(employeeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseWrapper.success(employeeResponseDTO,"them moi thanh cong",HttpStatus.CREATED.value()));
    }
}
