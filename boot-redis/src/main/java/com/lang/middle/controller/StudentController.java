package com.lang.middle.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lang.middle.exception.MyException;
import com.lang.middle.model.Student;
import com.lang.middle.service.IStudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/{id}")
    public Student getStudentByid(@PathVariable Long id) throws JsonProcessingException {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String removeStudent(@PathVariable Long id) throws MyException {
        boolean isSuccess = studentService.removeStudent(id);
        return isSuccess ? "删除成功" : "删除失败";
    }
}
