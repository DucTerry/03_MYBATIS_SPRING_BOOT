package com.ndangduc.bn.mybatisspringboot.dao.mapper;

import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO STUDENT(name,age, address,email) VALUES (#{name}, #{age}, #{address} , #{email} )")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public void addStudent(Student student);

    @Select("SELECT * FROM STUDENT WHERE id = #{studentId}  ")
    Optional<Student> detailStudent(Long studentId);
}
