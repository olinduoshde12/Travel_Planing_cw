package com.ijse.coursework.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id",length = 45)
    private String id;
    @Column(name = "full_name",length = 45)
    private String fullName;
    @Column(name = "nic_no",length = 45,unique = true)
    private String nic_no;
    @Column(name = "nic_Type",length = 45)
    private String nic_Type;
    @Column(name = "gender",length = 45)
    private String gender;
    @Column(name = "address" ,length = 45)
    private String address;
    @Column(name = "email",unique = true,length = 50)
    private String email;
    @Column(name = "contact" ,length = 45)
    private String contact;
    @Column(name = "user_name",length = 45)
    private String user_name;
    @Column(name = "password",length = 45)
    private String password;
    @Lob
    private byte[] profilePic;




}
