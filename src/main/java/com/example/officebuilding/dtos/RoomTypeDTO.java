package com.example.officebuilding.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RoomTypeDTO {
    private int rtId;
    private String rtName;
    private String rtDesc;
    private double rtPrice;
    private int rtBedNum;
    private String rtSize;
    private Timestamp updateTime;

    @JsonProperty("hotelId")
    private int hotelId;
}
