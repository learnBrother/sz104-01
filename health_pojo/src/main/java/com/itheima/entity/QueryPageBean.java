package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.entity
 * 日    期: 2020-11-2020/11/21
 * 时    间: 19:49
 * 描    述: 封装查询的条件
 */
@Data
@AllArgsConstructor
public class QueryPageBean implements Serializable {
    //页码
    private Integer currentPage;
    //每页记录数
    private Integer pageSize;
    //查询条件
    private String queryString;

}
