package com.ra.service;

import com.ra.dto.request.DepartmentRequestDTO;
import com.ra.dto.response.DepartmentResponseDTO;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponseDTO> getAll();
    DepartmentResponseDTO getById(Long id);
    DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO);
}
