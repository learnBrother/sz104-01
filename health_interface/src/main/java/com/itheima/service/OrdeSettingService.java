package com.itheima.service;

import com.itheima.exception.MyException;
import com.itheima.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service.OrdeSettingService
 * 日    期: 2020-11-2020/11/28
 * 时    间: 19:30
 * 描    述: 服务接口
 */
public interface OrdeSettingService {
    /**
     *
     * @Description: 批量导入预约设置
     * @Param: [excelFile]
     * @return: com.itheima.entity.Result
     * @Author: 陆奉学
     * @Date: 2020/11/28
     */

    void add(List<OrderSetting> orderSettingList) throws MyException;
    /**
     *
     * @Description: 日历展示
     * @Param: [month]
     * @return: com.itheima.entity.Result
     * @Author: 陆奉学
     * @Date: 2020/11/28
     */
    List<Map<String, Integer>> getDataByMoth(String month);

    /**
     *
     * @Description: 基于日历的预约设置
     * @Param: [os]
     * @return: com.itheima.entity.Result
     * @Author: 陆奉学
     * @Date: 2020/11/28
     */
    void editNummberByDate(OrderSetting orderSetting);

}
