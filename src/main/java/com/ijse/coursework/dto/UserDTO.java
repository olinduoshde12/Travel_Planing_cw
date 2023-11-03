package com.ijse.coursework.dto;

import lombok.*;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {
    private String id;
    private String fullName;
    private String nic_Type;
    private String nic_no;
    private String gender;
    private String address;
    private String email;
    private String contact;
    private String user_name;
    private String password;
    private byte[] profilePic;



}
