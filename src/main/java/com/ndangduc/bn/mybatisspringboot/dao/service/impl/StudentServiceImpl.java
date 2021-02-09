package com.ndangduc.bn.mybatisspringboot.dao.service.impl;

import com.ndangduc.bn.mybatisspringboot.controller.dto.req.CreateStudent;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.StudentIdReq;
import com.ndangduc.bn.mybatisspringboot.controller.dto.res.ResponseObject;
import com.ndangduc.bn.mybatisspringboot.controller.dto.res.StudentDTO;
import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import com.ndangduc.bn.mybatisspringboot.help.convert.StudentSupport;
import com.ndangduc.bn.mybatisspringboot.help.enums.EnumResponse;
import com.ndangduc.bn.mybatisspringboot.dao.mapper.StudentMapper;
import com.ndangduc.bn.mybatisspringboot.dao.service.StudentService;
import com.ndangduc.bn.mybatisspringboot.help.exception.StudentException;
import com.ndangduc.bn.mybatisspringboot.help.utils.JSONFactory;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final String PREFIX_LOG = "[STUDENT SERVICE]_";

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentSupport studentSupport;

    @Override
    public ResponseObject<StudentDTO> addStudent(CreateStudent req) {
        try {
            LOGGER.info(PREFIX_LOG+"addStudent {}", JSONFactory.toString(req));

            // 01. Convert Req -> Entity
            Student student = req.toEntity();

            // 02. Save Entity -> DB
            this.studentMapper.addStudent(student);

            // 03. Convert Entity -> DTO
            StudentDTO res = this.studentSupport.toStudentDTO(student);

            return new ResponseObject<>(true, EnumResponse.DO_SUCESS.getResponse(), res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseObject<>(false, EnumResponse.UN_ERROR.getResponse());
        }
    }

    @Override
    public ResponseObject<StudentDTO> detailStudent(StudentIdReq req) {
        try {
            LOGGER.info(PREFIX_LOG+"findStudentById {}", JSONFactory.toString(req));

            // 01. Find Student
            Student studentCurrent = this.studentMapper.detailStudent(req.getStudentId()).orElse(null);

            // 02. Validation
            if (studentCurrent ==null){
                throw new StudentException(EnumResponse.STUDENT_NOT_FOUND);
            }

            StudentDTO res = this.studentSupport.toStudentDTO(studentCurrent);

            return new ResponseObject<>(true, EnumResponse.DO_SUCESS.getResponse(), res);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseObject<>(false, EnumResponse.UN_ERROR.getResponse());
        }
    }
}
