package com.ijse.coursework.service;

import com.ijse.coursework.dto.GuideDTO;
import com.ijse.coursework.dto.UserDTO;
import com.ijse.coursework.dto.VehicleDTO;
import com.ijse.coursework.exception.DuplicateException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO, MultipartFile pic) throws IOException;

    void deleteGuide(String id);

    GuideDTO  searchGuide(String id);

    List<GuideDTO> getAllGuides();

    void updateGuide(GuideDTO guideDTO, MultipartFile pic) throws IOException;
}
