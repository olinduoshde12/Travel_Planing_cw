package com.ijse.coursework.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.coursework.dto.VehicleDTO;
import com.ijse.coursework.exception.DuplicateException;
import com.ijse.coursework.service.VehicleService;
import com.ijse.coursework.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
@RequiredArgsConstructor
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping(path = "save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveVehicle(@RequestParam("front_pic") MultipartFile front_pic,
                                    @RequestParam("side_pic") MultipartFile side_pic,
                                    @RequestParam("rare_pic") MultipartFile rare_pic,
                                    @RequestParam("vehicle") String vehicle
    ) throws DuplicateException, IOException {
        VehicleDTO vehicleDTO = new ObjectMapper().readValue(vehicle,VehicleDTO.class);

        return new ResponseUtil(200, "save", vehicleService.saveVehicle(vehicleDTO,front_pic,side_pic,rare_pic));
    }


    @PutMapping
    public ResponseUtil updateVehicle(@RequestParam("vehicle") String vehicle,
                                      @RequestParam("front_pic") MultipartFile front_pic,
                                      @RequestParam("side_pic") MultipartFile side_pic,
                                      @RequestParam("rare_pic") MultipartFile rare_pic)
            throws IOException {
        VehicleDTO vehicleDTO=new ObjectMapper().readValue(vehicle,VehicleDTO.class);
        vehicleService.updateVehicle(vehicleDTO,front_pic,side_pic,rare_pic);
        return new ResponseUtil(200,"Update Successfully",null);

    }

    @DeleteMapping
    public ResponseUtil deleteUser(String id){
        vehicleService.deleteVehicle(id);
        return new ResponseUtil(200,"Delete SuccessFull",null);
    }

    @GetMapping(params = {"search"})
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseUtil searchUser(@RequestParam("search") String search){
        return new ResponseUtil(200,"Search is Completed..",vehicleService.searchVehicle(search));
    }

    @GetMapping(path = "all")
    public ResponseUtil getAllUsers(){
        var data=vehicleService.getAllVehicle();
        return new ResponseUtil(200,"SuccessFully Completed.",data);
    }

}
