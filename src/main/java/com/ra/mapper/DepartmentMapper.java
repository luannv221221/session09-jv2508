package com.ra.mapper;

import com.ra.dto.request.DepartmentRequestDTO;
import com.ra.dto.response.DepartmentResponseDTO;
import com.ra.entity.Department;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    // chuyen E -> DTO
    DepartmentResponseDTO toDepartmentResponseDTO(Department department);
    List<DepartmentResponseDTO> toDepartmentResponseDTO(List<Department> departmentList);

    // chuyen DTO -> ENTITY
    Department toDepartment(DepartmentRequestDTO departmentRequestDTO);


}
