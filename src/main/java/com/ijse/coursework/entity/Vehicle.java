package com.ijse.coursework.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    private String vehicleId;
    @Column(nullable = false)
    private String vehicleBrand;
    @Column(nullable = false)
    private String vehicleCategory;
    @Column(nullable = false)
    private String vehicleHybridOrNot;
    @Column(nullable = false)
    private String vehicleFuelType;
    @Column(nullable = false)
    private double    vehicleFuelUsage;
    @Column(nullable = false)
    private int    vehicleSeatCapacity;
    @Column(nullable = false)
    private double vehicle_payment_in_one_km;
    @Column(nullable = false)
    private double vehicle_payment_in_one_day;
    @Column(nullable = false)
    private String vehicleStatus;
    @Column(nullable = false)
    private String vehicleTransmissionType;
    @Column(nullable = false)
    private String vehicleDriverName;
    @Column(nullable = false)
    private String vehicleDriverContact;
    @Lob
    private byte[] front_pic;
    @Lob
    private byte[] side_pic;
    @Lob
    private byte[] rare_pic;

}
