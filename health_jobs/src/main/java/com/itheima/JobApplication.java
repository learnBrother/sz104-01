package com.itheima;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 作    者: 陆奉学
 * 工 程 名: health_parent
 * 包    名: com.itheima
 * 日    期: 2020-11-2020/11/28
 * 时    间: 16:19
 * 描    述:
 */
public class JobApplication {
    public static void main(String[] args) throws IOException {
        new ClassPathXmlApplicationContext("applicationContext-jobs.xml");
        System.in.read();
    }
}
