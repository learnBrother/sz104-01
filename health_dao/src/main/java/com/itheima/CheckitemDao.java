package com.itheima;

import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima
 * 日    期: 2020-11-2020/11/21
 * 时    间: 20:06
 * 描    述:  查询所有
 */
public interface CheckitemDao {
    List<CheckItem> findAll();
}
