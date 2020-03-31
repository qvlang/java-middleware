package com.lang.middle.mapper;

import com.lang.middle.model.Student;
import com.lang.middle.sql.ComplexSql;
import org.apache.ibatis.annotations.*;

public interface IStudentMapper {
    //查询学生通过id
    @Select("select * from student where sid = #{sid}")
    Student findById(Long sid);

    //插入学生记录
    @Insert("insert into student (gender,class_id,sname) values (gender,classId,sname)")
    int insert(Student student);

    //删除学生
    @Delete("delete from student where sid = #{sid}")
    int delete(Long sid);

    //修改学生 传入值非空才修改
    @UpdateProvider(type = ComplexSql.class,method = "updateStudent")
    int update(Student student);
}
