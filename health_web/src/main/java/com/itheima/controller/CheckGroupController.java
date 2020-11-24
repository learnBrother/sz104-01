package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/24
 * 时    间: 20:36
 * 描    述:
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;
   /**
   *
   * @Description:
   * @Param: [checkGroup, checkitemIds]
   * @return: com.itheima.entity.Result
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    @PostMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        //调用业务服务
        checkGroupService.add(checkGroup,checkitemIds);
        //相应结果
        return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
}
