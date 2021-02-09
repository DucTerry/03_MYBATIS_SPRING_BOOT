package com.ndangduc.bn.mybatisspringboot.dao.service;

import com.ndangduc.bn.mybatisspringboot.controller.dto.req.CreateStudent;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.QueryStudentReq;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.StudentIdReq;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.UpdateStudent;
import com.ndangduc.bn.mybatisspringboot.controller.dto.res.ResponseObject;
import com.ndangduc.bn.mybatisspringboot.controller.dto.res.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    ResponseObject<StudentDTO> addStudent(CreateStudent student);

    ResponseObject<StudentDTO> detailStudent(StudentIdReq req);

    ResponseObject<StudentDTO> updateStudent(UpdateStudent request);

    ResponseObject<List<StudentDTO>> listStudent();
}
