package com.ndangduc.bn.mybatisspringboot.help.convert;

import com.ndangduc.bn.mybatisspringboot.controller.dto.res.StudentDTO;
import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<StudentDTO> toListStudentDTO(List<Student> studentGroup) {
        List<StudentDTO> res = new ArrayList<>();
        studentGroup.forEach(item->{
            res.add(this.toStudentDTO(item));
        });
        return res;
    }
}
