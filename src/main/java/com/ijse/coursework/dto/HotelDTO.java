package com.ijse.coursework.dto;


import com.ijse.coursework.option.RoomOption;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HotelDTO {
    private String hotel_Id;
    private String hotel_name;
    private String hotel_Category;
    private String hotel_Location;
    private String hotel_google_Location;
    private String hotel_contact_Email;
    private String hotel_contact_number;
    private String pets_allowed;
    private String hotel_fee;
    private String hotel_Cancellation_criteria;
    private RoomOption hotelRoomOpt;
    private byte[] hotel_image;

}
