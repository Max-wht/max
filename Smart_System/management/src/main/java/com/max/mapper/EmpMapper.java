package com.max.mapper;

import com.max.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    public Emp login(Emp emp);
}
