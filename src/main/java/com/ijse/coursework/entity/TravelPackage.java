package com.ijse.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TravelPackage {
    @Id
    private String travelPackage_Id;

    @Column(nullable = false)
    private String travelPackage_Category;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String travelPackage_Areas;

    @Column(nullable = false)
    private String guide_id;

    @Column(nullable = false)
    private String vehicle_id;

    @Column(nullable = false)
    private String hotel_id;

    @Column(nullable = false)
    private String customer_id;

    @Column(nullable = false)
    private double travelPackage_Value;

    @Column(nullable = false)
    private double travelPackage_PaidValue;

    @Column(nullable = false)
    private String travelPackage_NeedGuide;

    @Column(nullable = false)
    private String travelPackage_WithPet;

    @Column(nullable = false)
    private int travelPackage_HeadCount;

    @Column()
    private int travelPackage_No_Child;

    @Column()
    private int travelPackage_No_Adult;

    @Column(nullable = false,columnDefinition = "DATE")
    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String travelPackage_StartDate;

    @Column(nullable = false,columnDefinition = "DATE")
    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String travelPackage_EndDate;

    @Column(nullable = false,columnDefinition = "DATE")
    //@JsonFormat(pattern = "yyyy-mm-dd")
    private String travelPackage_PacedDate;
}
