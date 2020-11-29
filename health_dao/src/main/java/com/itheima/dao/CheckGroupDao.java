package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    /**
     *
     * @Description: 检查组分页查询
     * @Param: [queryString]
     * @return: com.github.pagehelper.Page<com.itheima.pojo.CheckGroup>
     * @Author: 陆奉学
     * @Date: 2020/11/25
     */
    Page<CheckGroup> findByCondition(String queryString);

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
    * @Param: [checkGroup]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void update(CheckGroup checkGroup);
    /**
    *
    * @Description: 删除检查组与检查项的关系
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void deleteCheckGroupCheckItem(Integer id);
    /**
    *
    * @Description: 通过检查组iD查询是否被套餐使用，返回使用的个数
    * @Param: [id]
    * @return: int
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    int findSetmealCountByCheckGroupId(int id);
    /**
    *
    * @Description: 删除旧关系
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void daleteCheckGroupCheckItem(int id);
    /**
    *
    * @Description: 删除检查组
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void deleteById(int id);
    
    List<CheckGroup> checkGroupDao();
    /**
    *
    * @Description: 查询所有检查组，新增套餐图片回显
    * @Param: []
    * @return: java.util.List<com.itheima.pojo.CheckGroup>
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    List<CheckGroup> findAll();
    
}