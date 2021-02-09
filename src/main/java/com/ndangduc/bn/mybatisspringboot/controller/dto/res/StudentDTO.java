package com.ndangduc.bn.mybatisspringboot.controller.dto.res;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;

    private String name;

    private Integer age;

    private String address;

    private String email;
}
