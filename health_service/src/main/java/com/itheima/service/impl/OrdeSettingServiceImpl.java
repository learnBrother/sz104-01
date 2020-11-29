package com.itheima.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.dao.OrderSettingDao;
import com.itheima.exception.MyException;
import com.itheima.pojo.OrderSetting;
import com.itheima.service.OrdeSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service.impl
 * 日    期: 2020-11-2020/11/28
 * 时    间: 20:41
 * 描    述: 接口实现类
 */
@Service(interfaceClass = OrdeSettingService.class)
public class OrdeSettingServiceImpl implements OrdeSettingService {


    @Autowired
    private OrderSettingDao orderSettingDao;

    /**
     *
     * @Description: 批量预约导入
     * @Param: [orderSettingList]
     * @return: void
     * @Author: 陆奉学
     * @Date: 2020/11/28
     */
    @Override
    @Transactional
    public void add(List<OrderSetting> orderSettingList) {
        //遍历LIst《OrderSetting》
        if (orderSettingList !=null) {
            for (OrderSetting orderSetting : orderSettingList) {
                //通过日期查询预约设置表
              OrderSetting osInDB = orderSettingDao.findByOrderDate(orderSetting.getOrderDate());
              //如果存在预约设置
                if (osInDB !=null) {
                    //判断更新后的最大数是否大等于已预约人数
                    if (orderSetting.getNumber() < osInDB.getReservations()) {
                        //  - 小于，报错 已预约数超过最大预约数，接口异常声明
                        throw new MyException("更新后的最大预约数，不能小于预约数");
                    }
                    //大于，则可以更新最大预约数
                    orderSettingDao.updateNumber(orderSetting);
                }else {
                    //不存在，则添加预约设置
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }



    /**
    *
    * @Description: 通过月份查询预约设置
    * @Param: [month]
    * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Integer>>
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    @Override
    public List<Map<String, Integer>> getDataByMoth(String month) {
        month += "%";
        return orderSettingDao.getDataByMonth(month);
    }
    /**
    *
    * @Description: 基于日历的预约设置
    * @Param: [os]
    * @return: void
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    @Override
    public void editNummberByDate(OrderSetting orderSetting) {
        //通过日期查询预约设置表
        OrderSetting osInDB = orderSettingDao.findByOrderDate(orderSetting.getOrderDate());
        //如果存在预约设置
        if (osInDB !=null) {
            //判断更新后的最大数是否大等于已预约人数
            if (orderSetting.getNumber() < osInDB.getReservations()) {
                //  - 小于，报错 已预约数超过最大预约数，接口异常声明
                throw new MyException("更新后的最大预约数，不能小于预约数");
            }
            //大于，则可以更新最大预约数
            orderSettingDao.updateNumber(orderSetting);
        }else {
            //不存在，则添加预约设置
            orderSettingDao.add(orderSetting);
        }
    }

}
