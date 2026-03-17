package com.ra.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DepartmentRequestDTO {
    @NotBlank(message = "Ten Phong Ban Khong Duoc Rong")
    private String name;
    private String description;

}
