package com.ndangduc.bn.mybatisspringboot.help.exception;

import com.ndangduc.bn.mybatisspringboot.help.enums.EnumResponse;

public class StudentException extends RuntimeException{
    public StudentException(EnumResponse response) {
        super(response.getResponse());
    }
}
