package com.lang.middle.service;

import com.lang.middle.model.StudentScore;

public interface IScoreService {
    StudentScore getStudentScore(Long studentId, Long courseId);
}
