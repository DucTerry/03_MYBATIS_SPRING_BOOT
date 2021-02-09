package com.ndangduc.bn.mybatisspringboot.help.convert;

import com.ndangduc.bn.mybatisspringboot.controller.dto.res.StudentDTO;
import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentSupport {
    public  StudentDTO toStudentDTO(Student entity){
        StudentDTO dto = new StudentDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setAge(entity.getAge());
        dto.setEmail(entity.getEmail());

        return dto;
    }
}
