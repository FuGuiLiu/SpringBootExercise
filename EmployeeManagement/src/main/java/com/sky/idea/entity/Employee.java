package com.sky.idea.entity;

import lombok.*;

import java.util.Date;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;

    private String email;
    //    1 male, 0 female
    private Integer gender;
    private Department department;
    @NonNull
    private Date birth = new Date();

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
