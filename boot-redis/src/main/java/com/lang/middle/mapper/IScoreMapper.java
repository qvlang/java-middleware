package com.lang.middle.mapper;

import com.lang.middle.model.StudentScore;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface IScoreMapper {
    //左连接多表查询学生的姓名 课程名 教师名 成绩
    @Select("SELECT stu.sname studentName, c.cname courseName,t.tname teacherName,score.num score From student stu LEFT JOIN course c ON c.cid = stu.class_id LEFT JOIN teacher t ON c.teacher_id = t.tid LEFT JOIN score ON stu.sid = score.student_id AND c.cid = score.course_id where stu.sid = #{studentId} AND c.cid = #{courseId};")
    public StudentScore findScore(@Param("studentId") Long sid, @Param("courseId") Long cid);
}
