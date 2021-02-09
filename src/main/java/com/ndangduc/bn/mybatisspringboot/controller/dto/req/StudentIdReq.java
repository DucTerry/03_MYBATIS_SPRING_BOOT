package com.ndangduc.bn.mybatisspringboot.controller.dto.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentIdReq {
    private Long studentId;
}
