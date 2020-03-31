package com.lang.middle.service.impl;

import com.lang.middle.mapper.IScoreMapper;
import com.lang.middle.model.StudentScore;
import com.lang.middle.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl implements IScoreService {

    @Autowired
    private IScoreMapper mapper;

    @Override
    public StudentScore getStudentScore(Long studentId, Long courseId) {
        StudentScore score = mapper.findScore(studentId, courseId);

        return score;
    }
}
