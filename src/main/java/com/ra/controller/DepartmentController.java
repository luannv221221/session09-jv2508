package com.ra.controller;

import com.ra.dto.request.DepartmentRequestDTO;
import com.ra.dto.response.DepartmentResponseDTO;
import com.ra.dto.response.ResponseWrapper;
import com.ra.entity.Department;
import com.ra.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public ResponseEntity<?> getDepartments() {
        List<DepartmentResponseDTO> department = departmentService.getAll();
        return ResponseEntity.ok(ResponseWrapper.success(department,"Lay danh sach thanh cong",HttpStatus.OK.value()));
    }
    @PostMapping
    public ResponseEntity<?> addDepartment(@Valid @RequestBody DepartmentRequestDTO departmentRequestDTO) {
        DepartmentResponseDTO department = departmentService.createDepartment(departmentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseWrapper.success(department,"Them moi thanh cong",HttpStatus.CREATED.value()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id) {
        DepartmentResponseDTO  department = departmentService.getById(id);
        return ResponseEntity.ok(ResponseWrapper.success(department,"Lay thong tin thanh cong",HttpStatus.OK.value()));
    }
}
