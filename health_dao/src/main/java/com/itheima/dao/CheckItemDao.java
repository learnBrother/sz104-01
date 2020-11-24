package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima
 * 日    期: 2020-11-2020/11/21
 * 时    间: 20:06
 * 描    述:  dao层
 */
public interface CheckItemDao {
    //查询检查项
    List<CheckItem> findAll();
    //添加检查项
    void add(CheckItem checkItem);

//    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);
    //分页查询检查项
    Page<CheckItem> findByCondition(String queryString);


    //根据传入的ID检查是否被检查项使用了
    int findCountByCheckItemId(int id);
    //根据传入的id删除检查项
    void deleteById(int id);
    //通过id查询检查项
    CheckItem findById(int id);

    void update(CheckItem checkItem);

}
