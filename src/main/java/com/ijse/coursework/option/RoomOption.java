package com.ijse.coursework.option;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
public class RoomOption {
    private String hotelRoom_Opt_1;
    private String hotelRoom_Opt_2;
    private String hotelRoom_Opt_3;
    private String hotelRoom_Opt_4;
}
