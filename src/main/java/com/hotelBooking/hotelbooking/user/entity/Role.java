package com.hotelBooking.hotelbooking.user.entity;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}

