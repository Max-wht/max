package com.max.service.impl;

import com.max.mapper.EmpMapper;
import com.max.pojo.Emp;
import com.max.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService_A implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }
}
