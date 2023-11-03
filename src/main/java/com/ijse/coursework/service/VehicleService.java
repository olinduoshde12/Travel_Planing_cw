package com.ijse.coursework.service;


import com.ijse.coursework.dto.UserDTO;
import com.ijse.coursework.dto.VehicleDTO;
import com.ijse.coursework.exception.DuplicateException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VehicleService {

    VehicleDTO saveVehicle(VehicleDTO vehicleDTO, MultipartFile front_pic,MultipartFile side_pic,MultipartFile rare_pic) throws DuplicateException, IOException;

    VehicleDTO searchVehicle(String id);

    List<VehicleDTO> getAllVehicle();

    void deleteVehicle(String id);

    void updateVehicle(VehicleDTO vehicleDTO,MultipartFile front_pic,MultipartFile side_pic,MultipartFile rare_pic) throws IOException;
}
