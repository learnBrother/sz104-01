package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/21
 * 时    间: 21:11
 * 描    述:
 */
@RestController
@RequestMapping("/checkitem/findAll")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    @GetMapping("/findAll")
    public Result findAll(){
        //调用服务查询所有的检查
       List<CheckItem> list =checkItemService.findAll();
       return new Result()

    }
}
