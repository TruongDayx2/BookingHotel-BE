package com.example.officebuilding.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name ="room_type")
@Entity
@NoArgsConstructor
public class RoomTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rtId;
    private String rtName;
    private String rtDesc;
    private double rtPrice;
    private int rtBedNum;
    private String rtSize;
    private Timestamp updateTime;
    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        updateTime = new Timestamp(System.currentTimeMillis());
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "hotel_id",nullable = false)
    private HotelEntity hotel;
}
