package com.ra.service;

import com.ra.dto.request.EmployeeRequestDTO;
import com.ra.dto.response.EmployeeResponseDTO;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO);
}
