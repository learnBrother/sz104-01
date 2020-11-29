package com.itheima.dao;

import com.itheima.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.dao
 * 日    期: 2020-11-2020/11/28
 * 时    间: 20:44
 * 描    述: 持久层
 */
public interface OrderSettingDao {
    /**
    *
    * @Description: 通过日期查询预约设置表
    * @Param: [orderDate]
    * @return: com.itheima.pojo.OrderSetting
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    OrderSetting findByOrderDate(Date orderDate);
    /**
    *
    * @Description: 更新最大预约数
    * @Param: [orderSetting]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    void updateNumber(OrderSetting orderSetting);
    /**
    *
    * @Description: 添加预约设置
    * @Param: [orderSetting]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    void add(OrderSetting orderSetting);
    /**
    *
    * @Description: 通过月份查询预约设置
    * @Param: [month]
    * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Integer>>
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    List<Map<String, Integer>> getDataByMonth(String month);
}
