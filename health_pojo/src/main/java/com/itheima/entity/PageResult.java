package com.itheima.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.entity
 * 日    期: 2020-11-2020/11/21
 * 时    间: 19:42
 * 描    述: 处理分页列表结果集
 */
@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    //总条数
    private Long total;
    //当前页结果
    private List<T> rows;
}
