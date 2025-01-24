package com.max.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeasuredData {

    private int id;
    private float humidity;
    private float electricity;
    private float temperature;
    private LocalDate updateTime;

}
