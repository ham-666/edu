package com.edu.entity;

import lombok.Data;

/**
 * @author ham
 */
@Data
public class Student {
    private String name;
    private String age;
    private String sex = "1";
}
