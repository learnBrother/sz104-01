package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.Setmeal;
import com.itheima.service.SetmealService;
import com.itheima.utils.QiNiuUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima
 * 日    期: 2020-11-2020/11/29
 * 时    间: 18:25
 * 描    述: 微信预约
 */
@RestController
@RequestMapping("/setmeal")
public class Controller {
    @Reference
    private SetmealService setmealService;

    /**
    *
    * @Description: 查询所有
    * @Param: []
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    @GetMapping("/getsetmeal")
    public Result getsetmeal(){
        //查询所有的套餐
       List<Setmeal> list = setmealService.findAll();
       list.forEach(Setmeal ->{
           Setmeal.setImg(QiNiuUtils.DOMAIN +Setmeal.getImg());
       });
       return new Result(true, MessageConstant.GET_SETMEAL_COUNT_REPORT_SUCCESS,list);
    }
    /**
    *
    * @Description: 查询套餐详情
    * @Param: [id]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/29
    */
    @GetMapping("/findDetailById")
    public Result findDetailById(int id){
        //服务查询详情
      Setmeal setmeal =  setmealService.findDetailById(id);
      //设置图片的完整路径
        setmeal.setImg(QiNiuUtils.DOMAIN + setmeal.getImg());
        return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,setmeal);

    }
}
