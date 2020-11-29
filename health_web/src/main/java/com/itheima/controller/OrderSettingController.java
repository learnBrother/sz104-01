package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.OrderSetting;
import com.itheima.service.OrdeSettingService;
import com.itheima.utils.POIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/28
 * 时    间: 19:26
 * 描    述:
 */
@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {
    @Reference
    private OrdeSettingService ordeSettingService;

    private static final Logger log = LoggerFactory.getLogger(OrderSettingController.class);
    /**
    *
    * @Description: 批量导入预约设置
    * @Param: [excelFile]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile excelFile){
        //-1. 接收上传的文件，MultipartFile  参数名为excelFile
        //- 调用POIUtils解析excel，List<String[]>
        try {
            List<String[]> orderInfoStringArrList = POIUtils.readExcel(excelFile);
            //时间格式化
            final   SimpleDateFormat sdf = new SimpleDateFormat(POIUtils.DATE_FORMAT);
            //2.再List<String[]> 转成List<OrderSetting>
            List<OrderSetting> orderSettingList = orderInfoStringArrList.stream().map(orderInfoStringArr ->{
                OrderSetting os = new OrderSetting();
                //日期的字符串
                String orderDateStr = orderInfoStringArr[0];
                //解析字符串
                try {
                    os.setOrderDate(sdf.parse(orderDateStr));
                } catch (ParseException e) {}
                    //最大预约数量
                    os.setNumber(Integer.parseInt(orderInfoStringArr[1]));
                    return os;
            }).collect(Collectors.toList());
            //3.调用服务导入os
            ordeSettingService.add(orderSettingList);
        } catch (IOException e) {
            log.error("导入预约设置失败",e);
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
        //4.返回操作结果
        return new Result(true,MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
        //5.关闭资源

    }
    /**
    *
    * @Description: 日历展示
    * @Param: [month]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    @GetMapping("/getDataByMonth")
    public Result getDataByMonth(String month){
        //调用服务查询预约信息
        List<Map<String,Integer>> monthData = ordeSettingService.getDataByMoth(month);
        //返回结果
        return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,monthData);
    }
    /**
    *
    * @Description: 基于日历的预约设置
    * @Param: [os]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/28
    */
    @PostMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting os){
        //调用服务来更新
        ordeSettingService.editNummberByDate(os);
        //返回结果
        return new Result(true,MessageConstant.ORDERSETTING_SUCCESS);
    }

}
