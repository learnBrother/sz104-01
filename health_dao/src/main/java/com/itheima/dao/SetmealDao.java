package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.dao
 * 日    期: 2020-11-2020/11/26
 * 时    间: 20:24
 * 描    述: 服务持久层
 */
public interface SetmealDao {
    /**
    *
    * @Description: 添加套餐
    * @Param: [setmeal]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void add(Setmeal setmeal);


    /**
     *
     * @Description: 体检套餐分页查询
     * @Param: [queryString]
     * @return: com.github.pagehelper.Page<com.itheima.pojo.Setmeal>
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    Page<Setmeal> findByCondition(String queryString);

    /**
    *
    * @Description: 添加套餐与检查组的关系
    * @Param: [setmealId, checkgroupId]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    void addSetmealCheckGroup(@Param("setmealId") Integer setmealId,@Param("checkgroupId") Integer checkgroupId);
    /**
     *
     * @Description: 更新套餐
     * @Param: [setmeal, checkgroupIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    void update(Setmeal setmeal);
    /**
     *
     * @Description: 根据id查询选中的所有检查组id
     * @Param: [setmeal, checkgroupIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    List<Integer> findCheckgroupIdsBySetmealId(int id);
    /**
     *
     * @Description: 删除旧关系
     * @Param: [setmeal, checkgroupIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    void deleteSetmealCheckGroup(Integer id);
    /**
     *
     * @Description: 根据id查询当前套餐
     * @Param: [id]
     * @return: com.itheima.entity.Result
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    Setmeal findById(int id);
    /**
    *
    * @Description: 通过套餐id统计订单个数
    * @Param: [id]
    * @return: int
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    int findOrderCountBySetmealId(int id);
    /**
    *
    * @Description: 根据id删除套餐
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    void deleteById(int id);

    List<String> findImgs();
    /**
    *
    * @Description: 查询所有套餐
    * @Param: []
    * @return: java.util.List<com.itheima.pojo.Setmeal>
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    List<Setmeal> findAll();
    /**
    *
    * @Description: 根据id查询套餐详情
    * @Param: [id]
    * @return: com.itheima.pojo.Setmeal
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    Setmeal findDetailById(int id);
}
