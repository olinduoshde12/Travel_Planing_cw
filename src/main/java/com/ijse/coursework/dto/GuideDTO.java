package com.ijse.coursework.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GuideDTO {
    private String guideId;
    private String guideDob;
    private String guideAddress;
    private String guideName;
    private double guideManDay_value;
    private String guideExperience;
    private String guideContact;
    private String guideEmail;
    private String guideGender;
    private String guideStatus;
    private byte[] guideImage;
}
