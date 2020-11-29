package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.SetmealDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.MyException;
import com.itheima.pojo.Setmeal;
import com.itheima.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service.impl
 * 日    期: 2020-11-2020/11/26
 * 时    间: 20:16
 * 描    述: 服务实现类
 */
@Service(interfaceClass = SetmealService.class)
public class SetmealServiceImpl implements SetmealService {
    /**
    *
    * @Description: 添加套餐
    * @Param:
    * @return:
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    @Autowired
    private SetmealDao setmealDao;
    @Override
    @Transactional
    public void add(Setmeal setmeal, Integer[] checkgroupIds) {
        //添加套餐信息
        setmealDao.add(setmeal);
        //获取套餐的id
        Integer setmealId = setmeal.getId();
        //遍历检查组的id
        if (checkgroupIds != null) {
            for (Integer checkgroupId : checkgroupIds) {
                //添加套餐与检查组的关系
                setmealDao.addSetmealCheckGroup(setmealId,checkgroupId);

            }
        }
    }
    /**
    *
    * @Description: 体检套餐分页查询
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.PageResult<com.itheima.pojo.Setmeal>
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    @Override
    public PageResult<Setmeal> findPage(QueryPageBean queryPageBean) {
        //获取当前页，获取页面条数
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        //判断是否有查询条件
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())) {
            //有才模糊查询
            queryPageBean.setQueryString("%"+ queryPageBean.getQueryString() + "%");
        }
        //条件查询，语句分页
        Page<Setmeal> page = setmealDao.findByCondition(queryPageBean.getQueryString());
        //获取总条数，页面结果集包装到分页列表结果集中返回
        return new PageResult<Setmeal>(page.getTotal(),page.getResult());
    }
    /**
     *
     * @Description: 根据id查询当前套餐
     * @Param: [setmeal, checkgroupIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    @Override
    public Setmeal findById(int id) {
        return setmealDao.findById(id);
    }
    /**
     *
     * @Description: 根据id查询选中的所有检查组id
     * @Param: [setmeal, checkgroupIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    @Override
    public List<Integer> findCheckgroupIdsBySetmealId(int id) {
        return setmealDao.findCheckgroupIdsBySetmealId(id);
    }
    /**
     *
     * @Description: 更新套餐
     * @Param: [setmeal, checkgroupIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    @Override
    public void update(Setmeal setmeal, Integer[] checkgroupIds) {
        //先更新当前套餐
        setmealDao.update(setmeal);
        //在删除旧关系（指数据库的中间表）
        setmealDao.deleteSetmealCheckGroup(setmeal.getId());
        //添加新关系
        if (checkgroupIds != null) {
            for (Integer checkgroupId : checkgroupIds) {
                setmealDao.addSetmealCheckGroup(setmeal.getId(),checkgroupId);
            }
        }
    }
    /**
    *
    * @Description: 根据id 删除套餐
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    @Override
    @Transactional
    public void deleteById(int id) throws MyException {
        //是否有订单使用
        int count = setmealDao.findOrderCountBySetmealId(id);
        if (count > 0) {
            //被订单使用了
            throw new MyException("改套餐已经被订单使用了，不能删除");
        }
        //先删除套餐与检查组的关系
        setmealDao.deleteSetmealCheckGroup(id);
        //在删除套餐
        setmealDao.deleteById(id);
    }
    /**
    *
    * @Description: 查询数据库中的所有图片
    * @Param: []
    * @return: java.util.List<java.lang.String>
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    @Override
    public List<String> findImgs() {
        return setmealDao.findImgs();
    }
    /**
    *
    * @Description: 查询所有的套餐
    * @Param: []
    * @return: java.util.List<com.itheima.pojo.Setmeal>
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    @Override
    public List<Setmeal> findAll() {
        return setmealDao.findAll();
    }
    /**
    *
    * @Description: 根据id查询套餐详情
    * @Param: [id]
    * @return: com.itheima.pojo.Setmeal
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    @Override
    public Setmeal findDetailById(int id) {
        return setmealDao.findDetailById(id);
    }
}
