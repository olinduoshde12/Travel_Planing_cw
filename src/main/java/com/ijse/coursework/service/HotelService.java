package com.ijse.coursework.service;

import com.ijse.coursework.dto.HotelDTO;
import com.ijse.coursework.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HotelService {
    HotelDTO saveHotel(HotelDTO hotelDTO, MultipartFile hotel_image) throws IOException;

    void deleteHotel(String id);

    List<HotelDTO> getAllHotels();

    HotelDTO  searchHotel(String id);

    void updateHotel(HotelDTO hotelDTO,MultipartFile hotel_image) throws IOException;
}
