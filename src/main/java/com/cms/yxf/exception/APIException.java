package com.cms.yxf.exception;

import lombok.Getter;

@Getter
public class APIException extends RuntimeException{

    private int code;
    private String msg;

    public APIException() {
        this(10001, "接口错误");
    }

    public APIException(String msg) {
        this(1001, msg);
    }

    public APIException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
