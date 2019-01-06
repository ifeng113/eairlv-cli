package com.eairlv.cli.config;

import com.eairlv.cli.entity.Result;
import com.eairlv.cli.entity.consts.HttpResult;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author lv
 * @create 2018-05-21 15:13
 * @desc
 **/
@ControllerAdvice
@Log4j2
public class ExceptionAdvice {

    /**
     * 错误异常拦截
     * @return
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result exception(Exception exception){
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        exception.printStackTrace(pw);
        log.error(sw.toString());
        return Result.fail();
    }

    /**
     * 参数异常拦截
     * @return
     */
    @ResponseBody
    @ExceptionHandler({MethodArgumentNotValidException.class,
            BindException.class,
            HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class
    })
    public Result methodArgumentNotValidException(Exception exception){
        return Result.fail(HttpResult.PARAMETER_ERROR, exception.getMessage());
    }
}
