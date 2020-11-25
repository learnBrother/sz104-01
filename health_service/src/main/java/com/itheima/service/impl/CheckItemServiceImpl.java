package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.HealthExcption;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service.impl
 * 日    期: 2020-11-2020/11/21
 * 时    间: 21:15
 * 描    述: 服务接口实现类
 */
@Service(interfaceClass= CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {
    //注入dao
    @Autowired
    private CheckItemDao checkitemDao;
   /**
   *
   * @Description:  //查询所有检查项
   * @Param: []
   * @return: java.util.List<com.itheima.pojo.CheckItem>
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    @Override
    public List<CheckItem> findAll() {
        return checkitemDao.findAll();
    }
   /**
   *
   * @Description:  //添加检查项
   * @Param: [checkItem]
   * @return: void
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    @Override
    public void add(CheckItem checkItem) {
        checkitemDao.add(checkItem);
    }
    /**
    *
    * @Description: //检查项分页查询
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.PageResult<com.itheima.pojo.CheckItem>
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @Override
    public PageResult<CheckItem> findPage(QueryPageBean queryPageBean) {
        //用工具类获取当前页，页条数
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        //判断是否有查询条件，因为是模糊查询所以用%拼接
        if (!StringUtils.isEmpty(queryPageBean.getQueryString())) {
            //有查询条件，拼接保存到 queryPageBean
            queryPageBean.setQueryString("%"+queryPageBean.getQueryString()+"%");
        }
        //查询语句分页
        Page<CheckItem> page = checkitemDao.findByCondition(queryPageBean.getQueryString());
        System.out.println(page.getTotal());
        //把总记录数与分页结果集封装到页面结果集对象中
       PageResult<CheckItem> pageResult= new  PageResult<>(page.getTotal(),page.getResult());
        return pageResult;
    }
    /**
    *
    * @Description: //根据id删除检查项
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @Override
    public void deleteById(int id) throws HealthExcption {
        //先判断这个检查项是否被检查组使用
        //调用dao查询检查项的id是否在t_checkgroup_checkitem表中存在记录
       int count = checkitemDao.findCountByCheckItemId(id);
        if (count>0) {
            //已经被检查组使用了，则不能删除，报错
            throw new HealthExcption("该检查项被检查组使用了，不能删除");
        }
        //没使用就可以调用dao删除
        checkitemDao.deleteById(id);
    }
    /***
    *
    * @Description: //通过id查询检查项在将CheckItem返回给列表
    * @Param: [id]
    * @return: com.itheima.pojo.CheckItem
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @Override
    public CheckItem findById(int id) {
        return checkitemDao.findById(id);
    }
    /**
    *
    * @Description: 更新列表
    * @Param: [checkItem]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @Override
    public void update(CheckItem checkItem) {
        checkitemDao.update(checkItem);
    }


}
