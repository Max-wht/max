package com.max.pojo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class MeasuredData {
    private float humidity;
    private float electricity;
    private float temperature;
    private LocalDate time;

    public MeasuredData(float humidity, float electricity, float temperature, LocalDate time){
        this.humidity = humidity;
        this.electricity = electricity;
        this.temperature = temperature;
        this.time = time;
    }
}
