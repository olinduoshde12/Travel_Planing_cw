package com.ijse.coursework.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.coursework.dto.UserDTO;
import com.ijse.coursework.exception.DuplicateException;
import com.ijse.coursework.service.UserService;
import com.ijse.coursework.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    @Autowired
    public final UserService userService;

    @Autowired
    public final ObjectMapper objectMapper;


    @PostMapping(path = "save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUtil saveUser(@RequestParam("file") MultipartFile file, @RequestParam("user") String user)
            throws IOException, DuplicateException {

        UserDTO userDTO = new ObjectMapper().readValue(user, UserDTO.class);

        return new ResponseUtil(200, "save", userService.saveUser(userDTO,file));
}
    @PutMapping(path = "update")
    public ResponseUtil updateUser(@RequestParam("user") String user,@RequestParam("file") MultipartFile file)
            throws IOException {
        UserDTO userDTO=new ObjectMapper().readValue(user,UserDTO.class);
        userService.updateUser(userDTO,file);
        return new ResponseUtil(200,"Update Successfully",null);

    }

    @DeleteMapping
    public ResponseUtil deleteUser(String id){
        userService.deleteUser(id);
        return new ResponseUtil(200,"Delete SuccessFull",null);
    }

    @GetMapping(params = {"search"})
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseUtil searchUser(@RequestParam("search") String search){
        return new ResponseUtil(200,"Search is Completed..",userService.searchVehicle(search));
    }

    @GetMapping(path = "all")
    public ResponseUtil getAllUsers(){
        var data=userService.getAllUsers();
        return new ResponseUtil(200,"SuccessFully Completed.",data);
    }


}
