package com.ijse.coursework.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.coursework.dto.HotelDTO;
import com.ijse.coursework.service.HotelService;
import com.ijse.coursework.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/hotel")
@CrossOrigin
@RequiredArgsConstructor
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping(path = "save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUtil saveHotel(@RequestParam("hotel") String hotel,@RequestParam("file") MultipartFile hotel_img) throws IOException {
        HotelDTO hotelDTO = new ObjectMapper().readValue(hotel, HotelDTO.class);

        return new ResponseUtil(200, "save", hotelService.saveHotel(hotelDTO,hotel_img));
    }

    @PutMapping
    public ResponseUtil updateHotel(@RequestParam("hotel") String hotel,@RequestParam("file") MultipartFile file)
            throws IOException {
        HotelDTO hotelDTO=new ObjectMapper().readValue(hotel,HotelDTO.class);
        hotelService.updateHotel(hotelDTO,file);
        return new ResponseUtil(200,"Update Successfully",null);

    }

    @DeleteMapping(path = "delete")
    public ResponseUtil deleteHotel(String id){
        hotelService.deleteHotel(id);
        return  new ResponseUtil(200,"deleted..",null);
    }

    @GetMapping(path = "All")
    public ResponseUtil getAllHotels(){
        var data=hotelService.getAllHotels();
        return new ResponseUtil(200,"SuccessFully Completed.",data);
    }

    @GetMapping(path = "search")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseUtil searchHotel(String  id){
        return new ResponseUtil(200,"Search is Completed..",hotelService.searchHotel(id));
    }
}
