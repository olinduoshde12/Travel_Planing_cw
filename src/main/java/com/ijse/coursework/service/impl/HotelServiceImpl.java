package com.ijse.coursework.service.impl;

import com.ijse.coursework.dto.HotelDTO;
import com.ijse.coursework.dto.UserDTO;
import com.ijse.coursework.entity.Hotel;
import com.ijse.coursework.entity.User;
import com.ijse.coursework.repository.HotelRepository;
import com.ijse.coursework.service.HotelService;
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
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public HotelDTO saveHotel(HotelDTO hotelDTO, MultipartFile hotel_image) throws IOException {
        if (!hotelRepository.existsById(hotelDTO.getHotel_Id())) {
            Hotel hotel = new Hotel();
            hotel.setHotel_Id(hotelDTO.getHotel_Id());
            hotel.setHotel_name(hotelDTO.getHotel_name());
            hotel.setHotel_Category(hotelDTO.getHotel_Category());
            hotel.setHotel_Location(hotelDTO.getHotel_Location());
            hotel.setHotel_google_Location(hotelDTO.getHotel_google_Location());
            hotel.setHotel_contact_Email(hotelDTO.getHotel_contact_Email());
            hotel.setHotel_contact_number(hotelDTO.getHotel_contact_number());
            hotel.setPets_allowed(hotelDTO.getPets_allowed());
            hotel.setHotel_fee(hotelDTO.getHotel_fee());
            hotel.setHotel_Cancellation_criteria(hotelDTO.getHotel_Cancellation_criteria());
            hotel.setHotelRoomOpt(hotelDTO.getHotelRoomOpt());
            hotel.setHotel_img(hotel_image.getBytes());

            return modelMapper.map(hotelRepository.save(hotel), HotelDTO.class);
        } else {
            throw new RuntimeException("This Hotel_Id is Already exist!");
        }
    }

    @Override
    public void deleteHotel(String id) {
        hotelRepository.deleteById(id);
    }

    @Override
    public List<HotelDTO> getAllHotels() {
        List<Hotel> list=hotelRepository.findAll();
        return modelMapper.map(list,new TypeToken<List<HotelDTO>>(){}.getType());
    }

    @Override
    public HotelDTO searchHotel(String id) {
        if (hotelRepository.existsById(id)) {
            Hotel hotel = hotelRepository.findById(id).get();
            return modelMapper.map(hotel, HotelDTO.class);
        } else {
            throw new RuntimeException("Hotel is Not Here...");

        }
    }

    @Override
    public void updateHotel(HotelDTO hotelDTO, MultipartFile hotel_image) throws IOException {
        if (!hotelRepository.existsById(hotelDTO.getHotel_Id())) {
            Hotel hotel = new Hotel();
            hotel.setHotel_Id(hotelDTO.getHotel_Id());
            hotel.setHotel_name(hotelDTO.getHotel_name());
            hotel.setHotel_Category(hotelDTO.getHotel_Category());
            hotel.setHotel_Location(hotelDTO.getHotel_Location());
            hotel.setHotel_google_Location(hotelDTO.getHotel_google_Location());
            hotel.setHotel_contact_Email(hotelDTO.getHotel_contact_Email());
            hotel.setHotel_contact_number(hotelDTO.getHotel_contact_number());
            hotel.setPets_allowed(hotelDTO.getPets_allowed());
            hotel.setHotel_fee(hotelDTO.getHotel_fee());
            hotel.setHotel_Cancellation_criteria(hotelDTO.getHotel_Cancellation_criteria());
            hotel.setHotelRoomOpt(hotelDTO.getHotelRoomOpt());
            hotel.setHotel_img(hotel_image.getBytes());

            modelMapper.map(hotelRepository.save(hotel), HotelDTO.class);
        } else {
            throw new RuntimeException("This Hotel_Id is Already exist!");
        }
    }
}
