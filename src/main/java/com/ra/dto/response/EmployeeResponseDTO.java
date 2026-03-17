package com.ra.dto.response;

import com.ra.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeResponseDTO {
    private String fullName;
    private String email;
    private String phone;
    private double salary;
    private String avatar;
    private Department department;
}
