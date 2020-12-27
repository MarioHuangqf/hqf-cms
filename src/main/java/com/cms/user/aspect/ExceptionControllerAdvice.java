package com.cms.user.aspect;

import com.cms.user.constant.enums.ResultCode;
import com.cms.user.exception.APIException;
import com.cms.user.domian.vo.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResultVO<>(ResultCode.VALIDATE_FAILED, objectError.getDefaultMessage());
    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e) {
        return new ResultVO<>(ResultCode.FAILED, e.getMessage());
    }
}
