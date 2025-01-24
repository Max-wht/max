package com.max.controller;

import com.max.pojo.MeasuredData;
import com.max.pojo.PageBean_Test;
import com.max.pojo.Result;
import com.max.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin

public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/tests")
    public Result getAllTest(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer pageSize){

        log.info("获取全部模拟测试数据");
        PageBean_Test theList = testService.getAllTests(page , pageSize);
        return Result.success(theList);
    }
}
