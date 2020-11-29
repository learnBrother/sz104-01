package com.itheima.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.service.SetmealService;
import com.itheima.utils.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.job
 * 日    期: 2020-11-2020/11/28
 * 时    间: 13:50
 * 描    述: 清理7牛云上的垃圾图片
 */
@Component
public class CleanlmgJob {
    private static final Logger log = LoggerFactory.getLogger(CleanlmgJob.class);

    @Reference
    private SetmealService setmealService;
    //发布
    @Scheduled(initialDelay = 3000,fixedDelay = 1800000)
    public void cleanlmg(){
        log.info("清理任务开始执行了");
        // 查出7牛上的s所有图片
        List<String> img7Niu = QiNiuUtils.listFile();
        log.debug("7牛上有{}张图片",null==img7Niu?0:img7Niu.size());
        // 查出数据库中的所有图片
        List<String>imgInDB =  setmealService.findImgs();
        log.debug("数据库有{}张图片",null==imgInDB?0:imgInDB.size());
        //执行removeAll之后，img7Niu剩下的就是7牛上有的但是数据库没有的
        img7Niu.removeAll(imgInDB);
        log.debug("要删除的图片有{}张",img7Niu.size());
        // 把剩下的图片名转成数组
        String[] need2Delete = img7Niu.toArray(new String[]{});
        // 删除7牛上的垃圾图片
        QiNiuUtils.removeFiles(need2Delete);
        log.info("删除{}张图片成功",img7Niu.size());
    }
}
