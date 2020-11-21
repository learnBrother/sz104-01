package com.itheima.service.impl;

import com.itheima.CheckitemDao;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima.service.impl
 * 日    期: 2020-11-2020/11/21
 * 时    间: 21:15
 * 描    述:
 */
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService{
    @Autowired
    private CheckitemDao checkitemDao;

}
