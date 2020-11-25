package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.HealthExcption;
import com.itheima.pojo.CheckItem;
import java.util.List;
/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service
 * 日    期: 2020-11-2020/11/21
 * 时    间: 21:18
 * 描    述: 服务通用接口
 */
public interface CheckItemService {

   /**
   *
   * @Description:  //查询所有检查项
   * @Param: []
   * @return: java.util.List<com.itheima.pojo.CheckItem>
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    List<CheckItem> findAll();
   /**
   *
   * @Description:  //调用dao添加检查项
   * @Param: [checkItem]
   * @return: void
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    void add(CheckItem checkItem);
    /**
    *
    * @Description: //检查项分页查询
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.PageResult<com.itheima.pojo.CheckItem>
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);
    /**
    *
    * @Description: //根据id删除检查项
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    void deleteById(int id)throws HealthExcption;
   /**
   *
   * @Description:  //根据id查询检查项返回CheckItem到列表
   * @Param: [id]
   * @return: com.itheima.pojo.CheckItem
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    CheckItem findById(int id);
    /**
    *
    * @Description: 更新列表
    * @Param: [checkItem]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    void update(CheckItem checkItem);
}
