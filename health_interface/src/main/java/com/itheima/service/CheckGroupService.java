package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service
 * 日    期: 2020-11-2020/11/24
 * 时    间: 20:45
 * 描    述:  检查组通用接口
 */
public interface CheckGroupService {
    /**
    *
    * @Description: 添加检查组
    * @Param: [checkGroup, checkitemIds]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    void add(CheckGroup checkGroup, Integer[] checkitemIds);
    /**
    *
    * @Description: 分页查询检查组
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.PageResult<com.itheima.pojo.CheckGroup>
    * @Author: 陆奉学
    * @Date: 2020/11/25
    */
    PageResult<CheckGroup> findPage(QueryPageBean queryPageBean);

}
