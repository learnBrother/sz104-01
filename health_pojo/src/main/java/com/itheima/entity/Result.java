package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.entity
 * 日    期: 2020-11-2020/11/21
 * 时    间: 19:28
 * 描    述: 封装返回结果
 */
@Data
@AllArgsConstructor

public class Result implements Serializable {
    //旗帜 变量
    private Boolean flag;
    //返回结果集
    private String message;
    //返回数据
    private Object data;
    //保存已有的信息

    public Result(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }
}
