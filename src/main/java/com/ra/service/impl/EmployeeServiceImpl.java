package com.ra.service.impl;

import com.ra.dto.request.EmployeeRequestDTO;
import com.ra.dto.response.EmployeeResponseDTO;
import com.ra.entity.Department;
import com.ra.entity.Employee;
import com.ra.mapper.EmployeeMapper;
import com.ra.repository.DepartmentRepository;
import com.ra.repository.EmployeeRepository;
import com.ra.service.EmployeeService;
import com.ra.service.UploadService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeRequestDTO) {
        // xu ly up anh
        String avatar = "";
        if(employeeRequestDTO.getAvatar() != null){
            avatar = uploadService.upload(employeeRequestDTO.getAvatar());
        }
        Employee employee = employeeMapper.toEmployee(employeeRequestDTO);
        Department department = departmentRepository.findById(employeeRequestDTO.getDepartmentId()).orElseThrow(()-> new EntityNotFoundException("Khong thay phong ban"));
        employee.setAvatar(avatar);
        employee.setDepartment(department);
        return employeeMapper.toEmployeeResponseDto(employeeRepository.save(employee));
    }
}
