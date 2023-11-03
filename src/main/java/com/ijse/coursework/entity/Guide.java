package com.ijse.coursework.entity;

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
@Table(name = "Guide")
public class Guide {
    @Id
    private String guideId;
    @Column(nullable = false)
    private String guideDob;
    @Column(nullable = false)
    private String guideAddress;
    @Column(nullable = false)
    private String guideName;
    @Column(nullable = false)
    private double guideManDay_value;
    @Column(nullable = false)
    private String guideExperience;
    @Column(nullable = false)
    private String guideContact;
    @Column(nullable = false)
    private String guideEmail;
    @Column(nullable = false)
    private String guideGender;
    @Column(nullable = false)
    private String guideStatus;
    @Lob
    private byte[] guideImage;
}
