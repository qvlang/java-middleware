package com.lang.middle.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lang.middle.exception.MyException;
import com.lang.middle.model.Student;

public interface IStudentService {
    Student getStudentById(Long id) throws JsonProcessingException;
    boolean removeStudent(Long id) throws MyException;
}
