package com.max.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.max.mapper.TestMapper;
import com.max.pojo.MeasuredData;
import com.max.pojo.PageBean_Test;
import com.max.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService_A implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public PageBean_Test getAllTests(Integer page , Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //获取mapper
        List<MeasuredData> theList = testMapper.getAllTests(pageSize , page);
        Page<MeasuredData> p = (Page<MeasuredData>) theList;
        //封装PageBean对象
        PageBean_Test pageBean = new PageBean_Test(p.getTotal() , p.getResult());

        return pageBean;
    }
}
