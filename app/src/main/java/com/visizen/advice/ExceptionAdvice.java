package com.visizen.advice;

import com.visizen.dto.ResultDto;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultDto handle(ConstraintViolationException exception){
        exception.printStackTrace();
        ResultDto rd=new ResultDto();
        rd.setCode(201);
        rd.setMsg(exception.getCause().getMessage());
        return rd;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultDto handle(TransactionSystemException exception){
        exception.printStackTrace();
        ResultDto rd=new ResultDto();
        rd.setCode(202);
        rd.setMsg("提交事务异常");
        return rd;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResultDto handleMyException(HttpServletRequest req, HttpServletResponse res,ResourceNotFoundException e) {
        e.printStackTrace();
        ResultDto rd=new ResultDto();
        rd.setCode(404);
        rd.setMsg("你请求的资源不存在");
        return rd;
    }
}
