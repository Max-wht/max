package com.max.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.max.mapper.MeasuredDataMapper;
import com.max.pojo.data.MeasuredData;
import com.max.pojo.row.HumidityRow;
import com.max.pojo.row.PowerConsumptionRaw;
import com.max.pojo.row.TemperatureRow;
import com.max.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


@Service
public class Content_A implements ContentService {
    @Autowired
    private MeasuredDataMapper measuredDataMapper;
    /**
     * 获取PowerConsumption的信息（电量），存放到PowerConsumptionData实体类，操作数据库，存入数据。
     * @param content
     */
    @Override
    public void getData(String content) {


        // 创建ObjectMapper实体类
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            //将Json转化为java对象
            JsonNode rootNode = objectMapper.readTree(content);
            //获得PowerConsumption节点
            JsonNode thePower = rootNode.path("items").path("PowerConsumption");
            PowerConsumptionRaw pcd = objectMapper.treeToValue(thePower, PowerConsumptionRaw.class);

            //获得Humidity节点
            JsonNode theHumidity = rootNode.path("items").path("Humidity");
            HumidityRow hd = objectMapper.treeToValue(theHumidity, HumidityRow.class);

            //获得Temperature节点
            JsonNode theTemperature = rootNode.path("items").path("Temperature");
            TemperatureRow td = objectMapper.treeToValue(theTemperature, TemperatureRow.class);

            //转换时间
            long rowTime = pcd.getTime();
            LocalDate localDate = Instant.ofEpochMilli(rowTime).atZone(ZoneId.systemDefault()).toLocalDate();

            //总数据对象
            MeasuredData a = new MeasuredData(hd.getValue(), pcd.getValue(), td.getValue(), localDate);

            System.out.println("========================================================================");
            System.out.println("JSON转化为java对象的结果："+ a);
            System.out.println("========================================================================");

            // 插入数据库
            measuredDataMapper.insertTest(a);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
