package com.ndangduc.bn.mybatisspringboot.help.enums;

public enum EnumResponse {
    DO_SUCESS("Thành công"),
    UN_ERROR("Thất bại")
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
