package com.ijse.coursework.service;

import com.ijse.coursework.dto.UserDTO;

import com.ijse.coursework.dto.VehicleDTO;
import com.ijse.coursework.exception.DuplicateException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO,MultipartFile pic) throws DuplicateException, IOException;

    void updateUser(UserDTO userDTO,MultipartFile pic) throws IOException;

    void deleteUser(String id);

    UserDTO  searchVehicle(String id);

    List<UserDTO> getAllUsers();

}
