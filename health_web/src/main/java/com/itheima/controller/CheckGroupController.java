package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import com.sun.org.apache.bcel.internal.generic.CHECKCAST;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/24
 * 时    间: 20:36
 * 描    述: 检查组后端
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;
   /**
   *
   * @Description:新增检查组
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
    /**
    *
    * @Description: 检查组分页查询
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/25
    */@PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        //调用服务分页查询把查询条件包装到查询封装类的分页列表结果集
       PageResult<CheckGroup> pageResult = checkGroupService.findPage(queryPageBean);
       //返回封装结果包含(分页列表结果集)
       return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,pageResult);
    }
    /**
    *
    * @Description: 【编辑检查组】通过id获取检查组
    * @Param: [checkGroupId]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @GetMapping("/findById")
    public Result findById(int checkGroupId){
        //调用业务服务根据传入的id查询检查组
        CheckGroup checkGroup = checkGroupService.findById(checkGroupId);
        //返回结果，数据
        return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);
    }

    /**
    *
    * @Description: 【编辑检查组】通过检查组id，查询选中的检查项id
    * @Param: [checkGroupId]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @GetMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(int checkGroupId){
        //调用服务查询id检查组中勾选的检查项id
        List<Integer> checkItemIds = checkGroupService.findCheckItemIdsByCheckGroupId(checkGroupId);
                //返回数据带
                return new Result(true,MessageConstant.QUERY_CHECKITEM_SUCCESS, checkItemIds);
    }
    /**
    *
    * @Description: 【编辑检查组】通过检查组id，与选中的检查项数据
    * @Param: [checkGroup, checkitemIds]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @PostMapping("/update")
    public Result update(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        //调用业务服务
        checkGroupService.update(checkGroup,checkitemIds);
        //响应结果
        return new Result(true,MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    @PostMapping("/deleteById")
    public Result deleteById(int id ){
        //调用业务服务删除
        checkGroupService.deleteById(id);
        return new Result(true,MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }
    /**
    *
    * @Description:
    * @Param: []
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @GetMapping("/findAll")
    public Result findAll(){
        List<CheckGroup> all = checkGroupService.findAll();
        return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,all);

    }
}
