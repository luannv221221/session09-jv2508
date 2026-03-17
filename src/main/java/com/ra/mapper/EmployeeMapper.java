package com.ra.mapper;

import com.ra.dto.request.DepartmentRequestDTO;
import com.ra.dto.request.EmployeeRequestDTO;
import com.ra.dto.response.DepartmentResponseDTO;
import com.ra.dto.response.EmployeeResponseDTO;
import com.ra.entity.Department;
import com.ra.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    // chuyen E -> DTO
    EmployeeResponseDTO toEmployeeResponseDto(Employee department);
    List<EmployeeResponseDTO> toEmployeeResponseDto(List<Employee> employees);

    // chuyen DTO -> ENTITY
    @Mapping(target = "avatar",ignore = true) // bo truong avata vi ko map duoc multipartfile
    Employee toEmployee(EmployeeRequestDTO employeeRequestDTO);
}
