package com.ijse.coursework.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Lob;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class VehicleDTO {
    private String vehicleId;
    private String vehicleBrand;
    private String vehicleCategory;
    private String vehicleHybridOrNot;
    private String vehicleFuelType;
    private double    vehicleFuelUsage;
    private int    vehicleSeatCapacity;
    private double vehicle_payment_in_one_km;
    private double vehicle_payment_in_one_day;
    private String vehicleStatus;
    private String vehicleTransmissionType;
    private String vehicleDriverName;
    private String vehicleDriverContact;
    private byte[] front_pic;
    private byte[] side_pic;
    private byte[] rare_pic;

}
