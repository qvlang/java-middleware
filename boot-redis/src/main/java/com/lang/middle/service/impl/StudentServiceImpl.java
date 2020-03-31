package com.lang.middle.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lang.middle.exception.MyException;
import com.lang.middle.mapper.IStudentMapper;
import com.lang.middle.model.Student;
import com.lang.middle.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentMapper mapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Student getStudentById(Long id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String redisStudent = stringRedisTemplate.opsForValue().get("student");
        //缓存中有直接返回 无则请求数据库并缓存
        if (!StringUtils.isEmpty(redisStudent))
            return objectMapper.readValue(redisStudent, Student.class);
        Student student = mapper.findById(id);
        String s = objectMapper.writeValueAsString(student);
        stringRedisTemplate.opsForValue().set("student", s, 60, TimeUnit.SECONDS);
        return student;
    }

    @Override
    public boolean removeStudent(Long id) throws MyException {
        int affectRow = mapper.delete(id);
        return affectRow > 0;
    }
    //秒 分 时 日 月 周 年
    @Scheduled(cron = "0/5 * * * * ?")
    public void schedu() {
        System.out.println("每隔5秒执行一次");
    }
}
