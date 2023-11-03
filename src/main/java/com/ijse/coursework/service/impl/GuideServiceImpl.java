package com.ijse.coursework.service.impl;

import com.ijse.coursework.dto.GuideDTO;
import com.ijse.coursework.dto.HotelDTO;
import com.ijse.coursework.entity.Guide;
import com.ijse.coursework.entity.Hotel;
import com.ijse.coursework.repository.GuideRepository;
import com.ijse.coursework.service.GuideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GuideServiceImpl implements GuideService {
        @Autowired
        GuideRepository guideRepository;

        @Autowired
        ModelMapper modelMapper;
    @Override
    public GuideDTO saveGuide(GuideDTO guideDTO, MultipartFile pic) throws IOException {

        if (!guideRepository.existsById(guideDTO.getGuideId())) {
            Guide guide = new Guide();
            guide.setGuideId(guideDTO.getGuideId());
            guide.setGuideDob(guideDTO.getGuideDob());
            guide.setGuideAddress(guideDTO.getGuideAddress());
            guide.setGuideName(guideDTO.getGuideName());
            guide.setGuideManDay_value(guideDTO.getGuideManDay_value());
            guide.setGuideExperience(guideDTO.getGuideExperience());
            guide.setGuideEmail(guideDTO.getGuideEmail());
            guide.setGuideGender(guideDTO.getGuideGender());
            guide.setGuideStatus(guideDTO.getGuideStatus());
            guide.setGuideImage(pic.getBytes());

            return modelMapper.map(guideRepository.save(guide), GuideDTO.class);
        } else {
            throw new RuntimeException("This Hotel_Id is Already exist!");
        }
    }

    @Override
    public void deleteGuide(String id) {
        guideRepository.deleteById(id);
    }

    @Override
    public GuideDTO searchGuide(String id) {
        if (guideRepository.existsById(id)) {
            Guide guide = guideRepository.findById(id).get();
            return modelMapper.map(guide, GuideDTO.class);
        } else {
            throw new RuntimeException("Hotel is Not Here...");

        }
    }

    @Override
    public List<GuideDTO> getAllGuides() {
        List<Guide> list=guideRepository.findAll();
        return modelMapper.map(list,new TypeToken<List<GuideDTO>>(){}.getType());
    }

    @Override
    public void updateGuide(GuideDTO guideDTO, MultipartFile pic) throws IOException {
        if (!guideRepository.existsById(guideDTO.getGuideId())) {
            Guide guide = new Guide();
            guide.setGuideId(guideDTO.getGuideId());
            guide.setGuideDob(guideDTO.getGuideDob());
            guide.setGuideAddress(guideDTO.getGuideAddress());
            guide.setGuideName(guideDTO.getGuideName());
            guide.setGuideManDay_value(guideDTO.getGuideManDay_value());
            guide.setGuideExperience(guideDTO.getGuideExperience());
            guide.setGuideEmail(guideDTO.getGuideEmail());
            guide.setGuideGender(guideDTO.getGuideGender());
            guide.setGuideStatus(guideDTO.getGuideStatus());
            guide.setGuideImage(pic.getBytes());

            modelMapper.map(guideRepository.save(guide), GuideDTO.class);
        } else {
            throw new RuntimeException("This Hotel_Id is Already exist!");
        }
    }


}
