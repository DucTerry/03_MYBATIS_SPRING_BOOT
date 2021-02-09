package com.ndangduc.bn.mybatisspringboot.controller.rest;

import com.ndangduc.bn.mybatisspringboot.controller.dto.req.CreateStudent;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.QueryStudentReq;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.StudentIdReq;
import com.ndangduc.bn.mybatisspringboot.controller.dto.req.UpdateStudent;
import com.ndangduc.bn.mybatisspringboot.controller.dto.res.ResponseObject;
import com.ndangduc.bn.mybatisspringboot.controller.dto.res.StudentDTO;
import com.ndangduc.bn.mybatisspringboot.dao.service.StudentService;
import com.ndangduc.bn.mybatisspringboot.help.utils.JSONFactory;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ducnd/student")
@Slf4j
@Api(tags = "STUDENT CONTROLLER", description = "CRUD")
public class StudentController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final String PREFIX_LOG = "[STUDENT CONTROLLER]_";

    @Autowired
    private StudentService studentService;


    @PostMapping("/add-student")
    public ResponseEntity<ResponseObject<StudentDTO>> addStudent(@Valid @RequestBody CreateStudent request){
        LOGGER.info(PREFIX_LOG+ "addStudent", JSONFactory.toString(request));

        ResponseObject<StudentDTO> res = this.studentService.addStudent(request);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/detail-student")
    public ResponseEntity<ResponseObject<StudentDTO>> detailStudent(@Valid @RequestBody StudentIdReq request){
        LOGGER.info(PREFIX_LOG+ "detailStudent", JSONFactory.toString(request));

        ResponseObject<StudentDTO> res = this.studentService.detailStudent(request);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/update-student")
    public ResponseEntity<ResponseObject<StudentDTO>> updateStudent(@Valid @RequestBody UpdateStudent request){
        LOGGER.info(PREFIX_LOG+ "updateStudent", JSONFactory.toString(request));

        ResponseObject<StudentDTO> res = this.studentService.updateStudent(request);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/list-student")
    public ResponseEntity<ResponseObject<List<StudentDTO>>> listStudent(){
        LOGGER.info(PREFIX_LOG+ "listStudent");

        ResponseObject<List<StudentDTO>> res = this.studentService.listStudent();

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
