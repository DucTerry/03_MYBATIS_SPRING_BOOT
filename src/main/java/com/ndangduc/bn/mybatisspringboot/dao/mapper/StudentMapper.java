package com.ndangduc.bn.mybatisspringboot.dao.mapper;

import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentMapper {
    @Insert("INSERT INTO STUDENT(name,age, address,email) VALUES (#{name}, #{age}, #{address} , #{email} )")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
   public void addStudent(Student student);
}
