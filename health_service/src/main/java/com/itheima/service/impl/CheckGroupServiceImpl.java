package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.constant.MessageConstant;
import com.itheima.dao.CheckGroupDao;
import com.itheima.dao.SetmealDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.HealthExcption;
import com.itheima.exception.MyException;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service.impl
 * 日    期: 2020-11-2020/11/24
 * 时    间: 20:59
 * 描    述:  检查组通用接口实现类
 */
@Service(interfaceClass = CheckGroupService.class)
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupDao checkGroupDao;
    /**
     *
     * @Description: 增添检查组
     * @Param: [checkGroup, checkitemIds]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/24
     */
    @Override
    @Transactional
    public void add(CheckGroup checkGroup, Integer[] checkitemIds) {
        //添加检查组
        checkGroupDao.add(checkGroup);
        //获取检查组的Id
        Integer checkGroupId = checkGroup.getId();
        //遍历检查项id，添加检查组与检查项的关系
        if (checkitemIds != null) {
            //有勾选
            for (Integer checkitemId : checkitemIds) {
                checkGroupDao.addCheckGroupCheckItem(checkGroupId,checkitemId);
            }
        }
    }
    /**
    *
    * @Description: 分页查询结果集
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.PageResult<com.itheima.pojo.CheckGroup>
    * @Author: 陆奉学
    * @Date: 2020/11/25
    */

    @Override
    public PageResult<CheckGroup> findPage(QueryPageBean queryPageBean) {
        //用工具类获取当前页，页条数
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        //判断是否有查询条件，因为是模糊查询所以用%拼接
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())) {
            //有查询条件，拼接保存到 queryPageBean
            queryPageBean.setQueryString("%"+ queryPageBean.getQueryString()+"%");
        }
        //查询语句分页
       Page<CheckGroup> page = checkGroupDao.findByCondition(queryPageBean.getQueryString());
        //把总记录数与分页结果集封装到页面结果集对象中 并返回
        return new PageResult<CheckGroup>(page.getTotal(),page.getResult()) ;
    }
    /**
    *
    * @Description: 【编辑检查组】通过检查组id，查询选中的检查项id
    * @Param: [checkGroupId]
    * @return: java.util.List<java.lang.Integer>
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @Override
    public List<Integer> findCheckItemIdsByCheckGroupId(int checkGroupId) {
        return checkGroupDao.findCheckItemIdsByCheckGroupId(checkGroupId);
    }
    /**
    *
    * @Description: 【编辑检查组】通过id获取检查组
    * @Param: [checkGroupId]
    * @return: com.itheima.pojo.CheckGroup
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @Override
    public CheckGroup findById(int checkGroupId) {
        return checkGroupDao.findById(checkGroupId);
    }
    /**
    *
    * @Description: 【编辑检查组】通过检查组id，与选中的检查项数据
    * @Param: [checkGroup, checkitemIds]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @Override
    @Transactional
    public void update(CheckGroup checkGroup, Integer[] checkitemIds) {
        //先更新检查组
        checkGroupDao.update(checkGroup);
        //再删除就关系
        checkGroupDao.deleteCheckGroupCheckItem(checkGroup.getId());
        //然后再判断有勾选就遍历它，并建立新的关系返回回去
        if (checkitemIds !=null) {
            for (Integer checkitemId : checkitemIds) {
                checkGroupDao.addCheckGroupCheckItem(checkGroup.getId(),checkitemId);
            }
        }

    }
    /**
    *
    * @Description: 删除检查组
    * @Param:
    * @return:
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @Override
    @Transactional
    public void deleteById(int id)throws MyException {
        //检查这个检查组是否被套餐使用了
       int count = checkGroupDao.findSetmealCountByCheckGroupId(id);
        if (count > 0) {
            //被使用了
            throw new MyException("改检查组被套餐使用了，不能删除");
        }
        //没有被套餐使用，就可以删除数据
        //先删除检查组与检查项的关系
        checkGroupDao.daleteCheckGroupCheckItem(id);
        //再删除检查组
        checkGroupDao.deleteById(id);
    }
    /**
    *
    * @Description: 查询所有检查组
    * @Param: []
    * @return: java.util.List<com.itheima.pojo.CheckGroup>
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @Override
    public List<CheckGroup> findAll() {
        return checkGroupDao.findAll();
    }
}
