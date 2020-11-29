package com.itheima.service;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.HealthExcption;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;

import java.util.List;

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
    /**
    *
    * @Description: 【编辑检查组】通过检查组id，查询选中的检查项id
    * @Param: [checkGroupId]
    * @return: java.util.List<java.lang.Integer>
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    List<Integer> findCheckItemIdsByCheckGroupId(int checkGroupId);
    /**
    *
    * @Description: 【编辑检查组】通过id获取检查组
    * @Param: [checkGroupId]
    * @return: com.itheima.pojo.CheckGroup
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    CheckGroup findById(int checkGroupId);
    /**
    *
    * @Description: 【编辑检查组】通过检查组id，与选中的检查项数据
    * @Param: [checkGroup, checkitemIds]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void update(CheckGroup checkGroup, Integer[] checkitemIds);

    void deleteById(int id)throws MyException;
    /**
    *
    * @Description: 查询所有检查组
    * @Param: []
    * @return: java.util.List<com.itheima.pojo.CheckGroup>
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    List<CheckGroup> findAll();
}
