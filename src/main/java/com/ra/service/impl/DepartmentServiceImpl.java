package com.ra.service.impl;

import com.ra.dto.request.DepartmentRequestDTO;
import com.ra.dto.response.DepartmentResponseDTO;
import com.ra.entity.Department;
import com.ra.exception.HttpConflict;
import com.ra.mapper.DepartmentMapper;
import com.ra.repository.DepartmentRepository;
import com.ra.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public List<DepartmentResponseDTO> getAll() {
        List<Department> departments = departmentRepository.findAll();

        /* thu cong return departments.stream().map(department -> DepartmentResponseDTO.
                builder().
                id(department.getId()).
                name(department.getName()).
                description(department.getDescription()).
                build()).toList();

         */
        // covert bang structmap
        return departmentMapper.toDepartmentResponseDTO(departments);
    }

    @Override
    public DepartmentResponseDTO getById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Department not found"));
        return departmentMapper.toDepartmentResponseDTO(department);
    }

    @Override
    public DepartmentResponseDTO createDepartment(DepartmentRequestDTO departmentRequestDTO) {
        /** thu cong
         * Department department = departmentRepository.save(Department.builder()
                        .description(departmentRequestDTO.getDescription())
                .name(departmentRequestDTO.getName()).build());
         */
        // kem tra xem ten da ton tai hay chua
        if(departmentRepository.existsByName(departmentRequestDTO.getName())){
            throw new HttpConflict("Department already exists");
        }
        Department department = departmentRepository.save(departmentMapper.toDepartment(departmentRequestDTO));
        return departmentMapper.toDepartmentResponseDTO(department);
    }
}
