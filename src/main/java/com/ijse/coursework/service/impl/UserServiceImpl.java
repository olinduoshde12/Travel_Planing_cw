package com.ijse.coursework.service.impl;
import com.ijse.coursework.dto.UserDTO;
import com.ijse.coursework.entity.User;
import com.ijse.coursework.exception.DuplicateException;
import com.ijse.coursework.repository.UserRepository;
import com.ijse.coursework.service.UserService;
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
public class UserServiceImpl implements UserService {

    @Autowired
    public final UserRepository userRepository;

    @Autowired
    public final ModelMapper modelMapper;



    @Override
    public UserDTO saveUser(UserDTO userDTO,MultipartFile file) throws DuplicateException, IOException {
            if (!userRepository.existsById(userDTO.getId())) {
                User user = new User();
                user.setId(userDTO.getId());
                user.setFullName(userDTO.getFullName());
                user.setNic_Type(userDTO.getNic_Type());
                user.setNic_no(userDTO.getNic_no());
                user.setGender(userDTO.getGender());
                user.setAddress(userDTO.getAddress());
                user.setEmail(userDTO.getEmail());
                user.setContact(userDTO.getContact());
                user.setUser_name(userDTO.getUser_name());
                user.setPassword(userDTO.getPassword());
                user.setProfilePic(file.getBytes());
                return modelMapper.map(userRepository.save(user), UserDTO.class);
            } else {
                throw new RuntimeException("This Customer_Id is Already exist!");
            }

    }

    @Override
    public void updateUser(UserDTO userDTO, MultipartFile file) throws IOException {
        if(!userRepository.existsById(userDTO.getId())){
            throw new RuntimeException("user is not found");
        }
        User user = new User();
        user.setId(userDTO.getId());
        user.setFullName(userDTO.getFullName());
        user.setNic_Type(userDTO.getNic_Type());
        user.setNic_no(userDTO.getNic_no());
        user.setGender(userDTO.getGender());
        user.setAddress(userDTO.getAddress());
        user.setEmail(userDTO.getEmail());
        user.setContact(userDTO.getContact());
        user.setUser_name(userDTO.getUser_name());
        user.setPassword(userDTO.getPassword());
        user.setProfilePic(file.getBytes());
        modelMapper.map(userRepository.save(user), UserDTO.class);

    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO searchVehicle(String id) {
        if (userRepository.existsById(id)) {
            User user = userRepository.findById(id).get();
            return modelMapper.map(user, UserDTO.class);
        } else {
            throw new RuntimeException("Customer is Not Here...");

        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> list=userRepository.findAll();
        return modelMapper.map(list,new TypeToken<List<UserDTO>>(){}.getType());
    }


}
