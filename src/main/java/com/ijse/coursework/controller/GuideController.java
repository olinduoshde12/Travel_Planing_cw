package com.ijse.coursework.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ijse.coursework.dto.GuideDTO;
import com.ijse.coursework.service.GuideService;
import com.ijse.coursework.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin
@RequiredArgsConstructor
public class GuideController {
    @Autowired
    GuideService guideService;

    @PostMapping(path = "save")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUtil saveUser(@RequestParam("file") MultipartFile file, @RequestParam("guide") String guide) throws IOException{

        GuideDTO guideDTO = new ObjectMapper().readValue(guide, GuideDTO.class);

        return new ResponseUtil(200, "save",guideService.saveGuide(guideDTO,file));
    }

    @DeleteMapping(path = "delete")
    public ResponseUtil deleteHotel(String id){
        guideService.deleteGuide(id);
        return  new ResponseUtil(200,"deleted..",null);
    }

    @GetMapping(params = {"search"})
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseUtil searchGuide(@RequestParam("search") String search){
        return new ResponseUtil(200,"Search is Completed..",guideService.searchGuide(search));
    }

    @GetMapping(path = "all")
    public ResponseUtil getAllGuides(){
        var data=guideService.getAllGuides();
        return new ResponseUtil(200,"SuccessFully Completed.",data);
    }

    @PutMapping
    public ResponseUtil updateGuide(@RequestParam("guide") String guide,@RequestParam("file") MultipartFile file)
            throws IOException {
        GuideDTO guideDTO=new ObjectMapper().readValue(guide,GuideDTO.class);
        guideService.updateGuide(guideDTO,file);
        return new ResponseUtil(200,"Update Successfully",null);

    }

}
