package com.itheima.controller;

import com.itheima.entity.Result;
import com.itheima.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/23
 * 时    间: 19:51
 * 描    述: 全局异常类处理
 *
 * Description: 全局异常处理
 *  * Advice: 通知
 *  * User: Eric
 *  * ExceptionHandler 获取的异常 异常的范围从小到大，类似于try catch中的catch
 *  * 与前端约定好的，返回的都是json数据
 */
@RestControllerAdvice
@Slf4j
public class HealExceptionAdvice {
    /**
    *
    * @Description: 自定义异常
    * @Param: [e]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    public Result handleHealthException(MyException e){
        //我们自己抛出的异常，把异常信息包装下返回即可
        return new Result(false,e.getMessage());
    }

    @ExceptionHandler(MyException.class)
    public Result handleException(Exception e){
        //e.printStackTrace();
        //System.out.println();
        log.error("发生未知异常",e);
        return new Result(false, "发生未知异常，请稍后重试");
    }

}
