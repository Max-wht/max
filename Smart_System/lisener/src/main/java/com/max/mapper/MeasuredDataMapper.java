package com.max.mapper;

import com.max.pojo.data.MeasuredData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeasuredDataMapper {
    public void insertTest(MeasuredData measuredData);
}
