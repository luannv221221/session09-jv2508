package com.ra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name",length = 100,nullable = false)
    private String fullName;
    @Column(name = "email",length = 100)
    private String email;
    @Column(name = "phone",length = 12,unique = true)
    private String phone;
    @Column(name = "salary")
    private double salary;
    @Column(name = "avatar")
    private String avatar;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
