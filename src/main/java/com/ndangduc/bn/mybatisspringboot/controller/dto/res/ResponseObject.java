package com.ndangduc.bn.mybatisspringboot.controller.dto.res;

import com.ndangduc.bn.mybatisspringboot.help.enums.EnumResponse;
import com.ndangduc.bn.mybatisspringboot.help.exception.StudentException;
import lombok.Data;

@Data
public class ResponseObject<T>{
    private Boolean result;

    private String message;

    private T data;

    public ResponseObject(Boolean result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResponseObject(Boolean result, String message) {
        this.result = result;
        this.message = message;
    }

    public ResponseObject(Boolean result, StudentException exception) {
        this.result = result;
        this.message = exception.getMessage();
    }

    public ResponseObject(Boolean result, EnumResponse response) {
        this.result = result;
        this.message = response.getResponse();
    }
}
