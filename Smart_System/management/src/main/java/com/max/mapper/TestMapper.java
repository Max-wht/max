package com.max.mapper;

import com.max.pojo.MeasuredData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {
    List<MeasuredData> getAllTests(Integer PageSize , Integer page);
}
