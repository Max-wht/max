package com.max.service;

import com.max.pojo.MeasuredData;
import com.max.pojo.PageBean_Test;

import java.util.List;


public interface TestService {

    PageBean_Test getAllTests(Integer page , Integer pageSize);
}
