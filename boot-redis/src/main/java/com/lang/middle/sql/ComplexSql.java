package com.lang.middle.sql;

import com.lang.middle.model.Student;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class ComplexSql {
    public String updateStudent(final Student student) {
        return new SQL() {{
            UPDATE("student");
            if (!StringUtils.isEmpty(student.getClassId())) {
                SET("class_id = #{classId}");
            }
            if (!StringUtils.isEmpty(student.getGender())) {
                SET("gender = #{gender}");
            }
            if (!StringUtils.isEmpty(student.getSname())) {
                SET("sname = #{sname}");
            }
            WHERE("sid = #{sid}");
        }}.toString();
    }
}
