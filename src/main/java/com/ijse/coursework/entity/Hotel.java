package com.ijse.coursework.entity;

import com.ijse.coursework.option.RoomOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "hotel")
public class Hotel {
    @Id
    private String hotel_Id;
    @Column(nullable = false)
    private String hotel_name;
    @Column(nullable = false)
    private String hotel_Category;
    @Column(nullable = false)
    private String hotel_Location;
    @Column(nullable = false,columnDefinition = "TEXT")
    private String hotel_google_Location;
    @Column(nullable = false ,unique = true)
    private String hotel_contact_Email;
    @Column(nullable = false)
    private String hotel_contact_number;
    @Column(nullable = false)
    private String pets_allowed;
    @Column(nullable = false)
    private String hotel_fee;
    @Column(nullable = false)
    private String hotel_Cancellation_criteria;
    @Column(nullable = false)
    private RoomOption hotelRoomOpt;
    @Lob
    private byte[] hotel_img;
}
