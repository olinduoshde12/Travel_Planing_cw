package com.ijse.coursework.service.impl;

import com.ijse.coursework.dto.UserDTO;
import com.ijse.coursework.dto.VehicleDTO;
import com.ijse.coursework.entity.User;
import com.ijse.coursework.entity.Vehicle;
import com.ijse.coursework.exception.DuplicateException;
import com.ijse.coursework.repository.VehicleRepository;
import com.ijse.coursework.service.VehicleService;
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
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO,
                                  MultipartFile front_pic,
                                  MultipartFile side_pic,
                                  MultipartFile rare_pic) throws DuplicateException, IOException {
        if(!vehicleRepository.existsById(vehicleDTO.getVehicleId())){
            Vehicle vehicle=new Vehicle();
            vehicle.setVehicleId(vehicleDTO.getVehicleId());
            vehicle.setVehicleBrand(vehicleDTO.getVehicleBrand());
            vehicle.setVehicleCategory(vehicleDTO.getVehicleCategory());
            vehicle.setVehicleHybridOrNot(vehicleDTO.getVehicleHybridOrNot());
            vehicle.setVehicleFuelType(vehicleDTO.getVehicleFuelType());
            vehicle.setVehicleFuelUsage(vehicleDTO.getVehicleFuelUsage());
            vehicle.setVehicleSeatCapacity(vehicleDTO.getVehicleSeatCapacity());
            vehicle.setVehicle_payment_in_one_km(vehicleDTO.getVehicle_payment_in_one_km());
            vehicle.setVehicle_payment_in_one_day(vehicleDTO.getVehicle_payment_in_one_day());
            vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
            vehicle.setVehicleTransmissionType(vehicleDTO.getVehicleTransmissionType());
            vehicle.setVehicleDriverName(vehicleDTO.getVehicleDriverName());
            vehicle.setVehicleDriverContact(vehicleDTO.getVehicleDriverContact());
            vehicle.setFront_pic(front_pic.getBytes());
            vehicle.setSide_pic(side_pic.getBytes());
            vehicle.setRare_pic(rare_pic.getBytes());
            return modelMapper.map(vehicleRepository.save(vehicle), VehicleDTO.class);
        }else {
            throw new RuntimeException("Vehicle is Already is Exists...");
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (vehicleRepository.existsById(id)) {
            Vehicle vehicle = vehicleRepository.findById(id).get();
            return modelMapper.map(vehicle, VehicleDTO.class);
        } else {
            throw new RuntimeException("Vehicle  is Not Here...");

        }
    }

    @Override
    public List<VehicleDTO> getAllVehicle() {
        List<Vehicle> list=vehicleRepository.findAll();
        return modelMapper.map(list,new TypeToken<List<VehicleDTO>>(){}.getType());
    }

    @Override
    public void deleteVehicle(String id) {
        vehicleRepository.deleteById(id);
    }



    @Override
    public void updateVehicle(VehicleDTO vehicleDTO,
                              MultipartFile front_pic,
                              MultipartFile side_pic,
                              MultipartFile rare_pic) throws IOException {
        if(!vehicleRepository.existsById(vehicleDTO.getVehicleId())){
            throw new RuntimeException("user is not found");
        }
        Vehicle vehicle=new Vehicle();
        vehicle.setVehicleId(vehicleDTO.getVehicleId());
        vehicle.setVehicleBrand(vehicleDTO.getVehicleBrand());
        vehicle.setVehicleCategory(vehicleDTO.getVehicleCategory());
        vehicle.setVehicleHybridOrNot(vehicleDTO.getVehicleHybridOrNot());
        vehicle.setVehicleFuelType(vehicleDTO.getVehicleFuelType());
        vehicle.setVehicleFuelUsage(vehicleDTO.getVehicleFuelUsage());
        vehicle.setVehicleSeatCapacity(vehicleDTO.getVehicleSeatCapacity());
        vehicle.setVehicle_payment_in_one_km(vehicleDTO.getVehicle_payment_in_one_km());
        vehicle.setVehicle_payment_in_one_day(vehicleDTO.getVehicle_payment_in_one_day());
        vehicle.setVehicleStatus(vehicleDTO.getVehicleStatus());
        vehicle.setVehicleTransmissionType(vehicleDTO.getVehicleTransmissionType());
        vehicle.setVehicleDriverName(vehicleDTO.getVehicleDriverName());
        vehicle.setVehicleDriverContact(vehicleDTO.getVehicleDriverContact());
        vehicle.setFront_pic(front_pic.getBytes());
        vehicle.setSide_pic(side_pic.getBytes());
        vehicle.setRare_pic(rare_pic.getBytes());
        modelMapper.map(vehicleRepository.save(vehicle), VehicleDTO.class);
    }
}
