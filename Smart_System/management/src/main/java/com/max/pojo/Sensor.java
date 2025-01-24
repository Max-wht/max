package com.max.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    private Integer id;
    private String location;
    private Integer wet;
    private Integer temperature;
    private String updateTime;


}
