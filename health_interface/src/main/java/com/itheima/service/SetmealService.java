package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.Setmeal;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service
 * 日    期: 2020-11-2020/11/26
 * 时    间: 19:26
 * 描    述: 服务接口
 */
public interface SetmealService {
    /**
    *
    * @Description: 添加套餐
    * @Param: [setmeal, checkgroupIds]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void add(Setmeal setmeal, Integer[] checkgroupIds);
    /**
    *
    * @Description: 体检套餐分页查询
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.PageResult<com.itheima.pojo.Setmeal>
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    PageResult<Setmeal> findPage(QueryPageBean queryPageBean);
    /**
    *
    * @Description: 根据id查询当前套餐
    * @Param: [id]
    * @return: com.itheima.pojo.Setmeal
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    Setmeal findById(int id);
    /**
    *
    * @Description: 根据id查询选中的所有检查组id
    * @Param: [id]
    * @return: java.util.List<java.lang.Integer>
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    List<Integer> findCheckgroupIdsBySetmealId(int id);
    /**
    *
    * @Description: 更新套餐
    * @Param: [setmeal, checkgroupIds]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    void update(Setmeal setmeal, Integer[] checkgroupIds);
    /**
    *
    * @Description: 根据id删除套餐
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    void deleteById(int id)throws MyException;
    /**
    *
    * @Description: 查询数据库中的所有图片
    * @Param: []
    * @return: java.util.List<java.lang.String>
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    List<String> findImgs();
    /**
    *
    * @Description: 查询所有的套餐
    * @Param: []
    * @return: java.util.List<com.itheima.pojo.Setmeal>
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    List<Setmeal> findAll();
    /**
    *
    * @Description: 查询套餐详情
    * @Param: [id]
    * @return: com.itheima.pojo.Setmeal
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */

    Setmeal findDetailById(int id);
}
