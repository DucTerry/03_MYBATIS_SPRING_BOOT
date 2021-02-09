package com.ndangduc.bn.mybatisspringboot.controller.dto.req;

import com.ndangduc.bn.mybatisspringboot.dao.entity.Student;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CreateStudent {

    @NotBlank(message = "Name của Student không được Null")
    @ApiModelProperty(example = "DUC TERRY")
    private String name;

    @NotBlank(message = "Address của Student không được Null")
    @ApiModelProperty(example = "BAC NINH")
    private String address;

    @Email
    @NotBlank(message = "Email của Student không được Null")
    @ApiModelProperty(example = "dev.ndangduc.bn@gmail.com")
    private String email;

    @NotBlank(message = "Phone của Student không được Null")
    @Pattern(regexp = "(09|01[2|6|8|9])+([0-9]{8})\\b", message = "Phone Number must corect format")
    @ApiModelProperty(
            example = "0919992222",
            notes = "Phone cannot be empty",
            required = true
    )
    private String phone;

    @ApiModelProperty(example = "31")
    private Integer age;

    public Student toEntity() {
        Student student = new Student();

        student.setName(this.getName());
        student.setAddress(this.getAddress());
        student.setEmail(this.getEmail());
        student.setPhone(this.getPhone());
        student.setAge(this.getAge());

        return student;
    }
}
