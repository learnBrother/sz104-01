package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.Setmeal;
import com.itheima.service.SetmealService;
import com.itheima.utils.QiNiuUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.controller
 * 日    期: 2020-11-2020/11/26
 * 时    间: 19:15
 * 描    述: Web,后端，消费者
 */
@Slf4j
@RestController
@RequestMapping("/setmeal")
public class SetmealController {

    @Reference
    private SetmealService setmealService;
    /**
    *
    * @Description: 套餐图片上传
    * @Param:
    * @return:
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @PostMapping("/upload")
    public Result upload(MultipartFile imgFile){

        //获取文件名，
        String originalFilename = imgFile.getOriginalFilename();
        //获取它的后缀名
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //产生唯一名称，拼接后缀名，图片名
        String imgName = UUID.randomUUID().toString() + suffix;
        try {
            //调用QiNiuUtils上传
            QiNiuUtils.uploadViaByte(imgFile.getBytes(),imgName);
            //成功后返回图片名和域名必须与前端一一对应
            //imgName:图片名  domain：域名
            Map<String, String> resultMap = new HashMap<>();
            resultMap.put("imgName",imgName);
            resultMap.put("domain",QiNiuUtils.DOMAIN);
            return new Result(true, MessageConstant.UPLOAD_SUCCESS,resultMap);
        } catch (IOException e) {
            log.error("上传文件失败",e);
            return new Result(false,MessageConstant.PIC_UPLOAD_FAIL);
        }
    }
    /**
    *
    * @Description: 添加套餐
    * @Param: [setmeal, checkgroupIds]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/26
    */
    @PostMapping("/add")
    public Result add(@RequestBody Setmeal setmeal,Integer[] checkgroupIds){
        //调用服务添加
        setmealService.add(setmeal,checkgroupIds);
        return new Result(true,MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }
    /**
    *
    * @Description: 体检套餐分页查询
    * @Param: [queryPageBean]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        //调用服务分页查询
       PageResult<Setmeal> pageResult = setmealService.findPage(queryPageBean);
       return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,pageResult);
    }
    /**
     *
     * @Description: 根据id查询当前套餐
     * @Param: [id]
     * @return: com.itheima.entity.Result
     * @Author: 陆奉学
     * @Date: 2020/11/27
     */
    @GetMapping("/findById")
    public Result findById(int id){
        //调用服务根据id查询当前套餐
      Setmeal setmeal =  setmealService.findById(id);
      //前端要显示图片需要全路径
      //封装到map中，解决图片路径问题
      Map<String, Object> resulMap = new HashMap<>();
      //文件名锁定
      resulMap.put("setmeal",setmeal);
      //七牛云上的域名
      resulMap.put("domain",QiNiuUtils.DOMAIN);
      return new Result(true,MessageConstant.QUERY_SETMEAL_SUCCESS,resulMap);

    }
    /**
    *
    * @Description: 根据id查询选中的所有检查组id
    * @Param: [id]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    @GetMapping("/findCheckgroupIdsBySetmealId")
    public Result findCheckgroupIdsBySetmealId(int id){
        //根据id查询选中的所有检查组id返回给
        List<Integer> checkgroupIds = setmealService.findCheckgroupIdsBySetmealId(id);
        return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkgroupIds);
    }
    /**
    *
    * @Description: 更新套餐
    * @Param: [setmeal, checkgroupIds]
    * @return: com.itheima.entity.Result
    * @Author: 陆奉学
    * @Date: 2020/11/27
    */
    @PostMapping("/update")
    public Result update(@RequestBody Setmeal setmeal,Integer[] checkgroupIds){
        //调用服务更新
        setmealService.update(setmeal,checkgroupIds);
        //返回数据给页面
        return new Result(true,"更新套餐成功");
    }
    @RequestMapping("/deleteById")
    public Result deleteById(int id){
        //调用服务删除
        setmealService.deleteById(id);
        return new Result(true,"删除套餐成功");
    }
}
