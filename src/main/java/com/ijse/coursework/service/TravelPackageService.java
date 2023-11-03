package com.ijse.coursework.service;

import com.ijse.coursework.dto.TravelPackageDTO;
import com.ijse.coursework.exception.DuplicateException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface TravelPackageService {
    void saveTravelPackage(TravelPackageDTO travelPackageDTO) throws DuplicateException;

    void updateTravelPackage(TravelPackageDTO travelPackageDTO) throws DuplicateException;

    TravelPackageDTO findPackageById(String packageId);

    List<TravelPackageDTO> getAllPackages();

    void deletePackage(String packageId) throws  DuplicateException;

    String getNextId();
}
