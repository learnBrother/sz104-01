package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.dao
 * 日    期: 2020-11-2020/11/24
 * 时    间: 21:07
 * 描    述: 检查组dao层
 */
public interface CheckGroupDao {;
    /**
    *
    * @Description: 添加检查组
    * @Param: [checkGroup]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    public void add(CheckGroup checkGroup);

    /**
     * @Description: 添加检查组与检查项的关系
     * @Param: [checkGroupId, checkitemId]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/24
     */
    public void addCheckGroupCheckItem(@Param("checkGroupId") Integer checkGroupId,@Param("checkitemId") Integer checkitemId);

    Page<CheckGroup> findByCondition(String queryString);

    /**
    *
    * @Description: 检查组分页查询
    * @Param: [queryString]
    * @return: com.github.pagehelper.Page<com.itheima.pojo.CheckGroup>
    * @Author: 陆奉学
    * @Date: 2020/11/25
    */


}