package com.ra.dto.request;

import com.ra.entity.Department;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeRequestDTO {
    private String fullName;
    private String email;
    private String phone;
    private double salary;
    private MultipartFile avatar;
    private Long departmentId;
}
