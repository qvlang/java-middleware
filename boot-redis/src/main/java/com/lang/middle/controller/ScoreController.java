package com.lang.middle.controller;

import com.lang.middle.model.StudentScore;
import com.lang.middle.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.KeyGenerator;

@RestController
@RequestMapping("/score")
@CacheConfig(cacheNames = "score",keyGenerator = "keyGenerator")
public class ScoreController {
    @Autowired
    private IScoreService scoreService;

    //获取学生某门课程的成绩
    @GetMapping("/course")
    @Cacheable
    @CachePut
    public StudentScore getStudentScore(Long studentId, Long courseId) {
        StudentScore studentScore = scoreService.getStudentScore(studentId, courseId);
        return studentScore;
    }
}
