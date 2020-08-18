package com.wen.cloud.model;

public class CommonResult {
    private String message;
    private int code;
    private User user;
    public CommonResult(User user,String message, int code) {
        this.user=user;
        this.message = message;
        this.code = code;
    }

    public CommonResult(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public CommonResult() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
