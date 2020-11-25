package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/21
 * 时    间: 21:11
 * 描    述: 用户类
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;
   /**
   *
   * @Description: 查询所有的方法
   * @Param: []
   * @return: com.itheima.entity.Result
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    @GetMapping("/findAll")
    public Result findAll(){
        //调用服务查询所有的检查
       List<CheckItem> list =checkItemService.findAll();
       return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,list);

    }
   /**
   *
   * @Description: 新增检查项
   * @Param: [checkItem]
   * @return: com.itheima.entity.Result
   * @Author: 陆奉学
   * @Date: 2020/11/24
   */
    @PostMapping("/add")
    public Result add(@RequestBody CheckItem checkItem ){
        //调用服务添加
        checkItemService.add(checkItem);
//        返回结果
        return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
    /**
    *
    * @Description: 检查项分页
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        //调用业务层来分页，获取分页结果
       PageResult<CheckItem> pageResult = checkItemService.findPage(queryPageBean);
       //返回给页面，
        return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS,pageResult);
    }
    /**
    *
    * @Description: 
    * @Param: [id]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @PostMapping("/deleteById")
    public Result deleteById(int id){
        checkItemService.deleteById(id);
       return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    /**
    *
    * @Description: 编辑检查项
    * @Param: [id]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @GetMapping("/findById")
    public Result findById(int id){
       CheckItem checkItem = checkItemService.findById(id);
       return new Result(true,"查询检查项成功",checkItem);
    }
    /**
    *
    * @Description:  //更新检查项
    * @Param: [checkItem]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/24
    */
    @PostMapping("/update")
    public Result update(@RequestBody CheckItem checkItem){
        checkItemService.update(checkItem);
        return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }
}
