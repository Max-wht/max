package com.max;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.max.pojo.row.PowerConsumptionRaw;
import org.junit.jupiter.api.Test;

public class json2ObjectTest02 {

    @Test
    public void json2Object() throws Exception{
        String jsonDate = "{\"deviceType\":\"CustomCategory\",\"iotId\":\"Ysm95d2VzdeqXwmvVyfek1ynp0\",\"requestId\":\"1732687071217\",\"checkFailedData\":{},\"productKey\":\"k1ynpYi2HTW\",\"gmtCreate\":1732687065772,\"deviceName\":\"Receiver_01\",\"items\":{\"PowerConsumption\":{\"value\":95,\"time\":1732687065768}}}";
        // 创建ObjectMapper实体类
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            //
            JsonNode rootNode = objectMapper.readTree(jsonDate);
            JsonNode powerConsumption = rootNode.path("items").path("PowerConsumption");
            PowerConsumptionRaw pcd = objectMapper.treeToValue(powerConsumption, PowerConsumptionRaw.class);

            System.out.println("JSON转化为java对象的结果："+ pcd);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
