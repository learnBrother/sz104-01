package com.itheima.dao;
import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima
 * 日    期: 2020-11-2020/11/21
 * 时    间: 20:06
 * 描    述:  dao层
 */
public interface CheckItemDao {
   /**
   *
   * @Description:  //查询检查项
   * @Param: []
   * @return: java.util.List<com.itheima.pojo.CheckItem>
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    List<CheckItem> findAll();
   /**
   *
   * @Description:  //添加检查项
   * @Param: [checkItem]
   * @return: void
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    void add(CheckItem checkItem);

//    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);
  /**
  *
  * @Description:   //分页查询检查项
  * @Param: [queryString]
  * @return: com.github.pagehelper.Page<com.itheima.pojo.CheckItem>
  * @Author: 陆奉学
  * @Date: 2020/11/24
  */
    Page<CheckItem> findByCondition(String queryString);


    /**
    *
    * @Description: //根据传入的ID检查是否被检查项使用了
    * @Param: [id]
    * @return: int
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    int findCountByCheckItemId(int id);
    /**
    *
    * @Description: //根据传入的id删除检查项
    * @Param: [id]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    void deleteById(int id);
   /**
   *
   * @Description:  //通过id查询检查项在将CheckItem返回给列表
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
