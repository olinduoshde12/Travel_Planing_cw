package com.ijse.coursework.controller;

import com.ijse.coursework.dto.TravelPackageDTO;
import com.ijse.coursework.exception.DuplicateException;
import com.ijse.coursework.service.TravelPackageService;
import com.ijse.coursework.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/travelPackage")
@RequiredArgsConstructor
public class TravelPackageController {
    @Autowired
    private  TravelPackageService travelPackageService;

    @GetMapping
    public String ping(){
        return "TravelPackage Controller Ok..";
    }

    @GetMapping(path = "find",params = {"packageId"})//find?packageId=T/2023/10@001
    public ResponseUtil findPackageById(String packageId){
        return new ResponseUtil(200,"Package found",travelPackageService.findPackageById(packageId));
    }

    @GetMapping(path = "find/all")
    public ResponseUtil getAllPackages(){
        return new ResponseUtil(200,"Package found",travelPackageService.getAllPackages());
    }

    @PostMapping(path = "save")
    public ResponseUtil savePackage(@RequestBody TravelPackageDTO packageDTO) throws DuplicateException {
        travelPackageService.saveTravelPackage(packageDTO);
        return new ResponseUtil(200,"Package saved",null);
    }

    @PutMapping(path = "update")
    public ResponseUtil updatePackage(@RequestBody TravelPackageDTO packageDTO) throws DuplicateException {
        travelPackageService.updateTravelPackage(packageDTO);
        return new ResponseUtil(200,"Package updated",null);
    }

    @DeleteMapping(path = "delete", params = {"packageId"})
    public ResponseUtil deletePackage(String packageId) throws DuplicateException {
        travelPackageService.deletePackage(packageId);
        return new ResponseUtil(200,"Package Deleted",null);
    }

    @GetMapping(path = "get/id")
    public ResponseUtil getNextPackageId(){
        return new ResponseUtil(200,"Next Package Id",travelPackageService.getNextId());
    }
}
