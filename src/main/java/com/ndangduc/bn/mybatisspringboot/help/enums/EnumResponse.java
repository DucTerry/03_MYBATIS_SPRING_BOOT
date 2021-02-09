package com.ndangduc.bn.mybatisspringboot.help.enums;

public enum EnumResponse {
    DO_SUCESS("Thành công"),
    UN_ERROR("Thất bại"),
    STUDENT_NOT_FOUND("Không timg thấy Student")
    ;

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    EnumResponse(String response) {
        this.response = response;
    }
}
