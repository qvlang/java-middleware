package com.lang.middle.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentScore implements Serializable {
    private String studentName;
    private String teacherName;
    private String courseName;
    private int score;
}
