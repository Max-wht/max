package com.max;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.pojo.row.PowerConsumptionRaw;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;


public class Json2Object {

    @Test
    public void json2Object() throws JsonProcessingException {
        String jsonData = "{\"value\": 92,\"time\":1732540385045}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        PowerConsumptionRaw powerConsumptionData =  mapper.readValue(jsonData, PowerConsumptionRaw.class);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(powerConsumptionData.getTime());
        System.out.println("时间："+formattedDate);
        System.out.println("JSON转化为java对象的结果："+ powerConsumptionData);

    }
}
