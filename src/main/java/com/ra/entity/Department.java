package com.ra.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",length = 100,unique = true,nullable = false)
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;
}
