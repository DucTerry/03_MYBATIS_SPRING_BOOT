package com.ndangduc.bn.mybatisspringboot.dao.mapper;

import com.ndangduc.bn.mybatisspringboot.controller.dto.req.QueryStudentReq;
import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO STUDENT(name,age, address,email) " +
            "VALUES (#{name}, #{age}, #{address} , #{email} )")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public void addStudent(Student student);

    @Select("SELECT * FROM STUDENT " +
            "WHERE id = #{studentId}  ")
    Optional<Student> detailStudent(Long studentId);

    @Update("UPDATE  STUDENT " +
            "SET name =#{name},name=#{name} , address=#{address} , email=#{email}, phone=#{phone} " +
            "WHERE id =#{id} ")
    void updateStudent(Student studentCurrent);

    @Select("SELECT * FROM STUDENT")
    List<Student> listStudent();
}
