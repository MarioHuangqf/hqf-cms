package com.cms.user.domian.vo;

import com.cms.user.constant.enums.ResultCode;
import lombok.Getter;

/**
 * 自定义统一异常体
 * @param <T>
 */
@Getter
public class ResultVO<T> {
    /**
     * 状态码
     */
    private int code;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 相应数据
     */
    private T data;

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }
}
