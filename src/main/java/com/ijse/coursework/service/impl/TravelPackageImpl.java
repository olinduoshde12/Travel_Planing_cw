package com.ijse.coursework.service.impl;

import com.ijse.coursework.dto.TravelPackageDTO;
import com.ijse.coursework.entity.TravelPackage;
import com.ijse.coursework.exception.DuplicateException;
import com.ijse.coursework.repository.TravelPackageRepository;
import com.ijse.coursework.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TravelPackageImpl implements TravelPackageService {
    @Autowired
    TravelPackageRepository travelPackageRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveTravelPackage(TravelPackageDTO travelPackageDTO) throws DuplicateException {
        if (travelPackageRepository.existsById(travelPackageDTO.getTravelPackage_Id())){
            throw new DuplicateException("Travel Package Id Already Exits");
        }
        travelPackageRepository.save(modelMapper.map(travelPackageDTO, TravelPackage.class));
    }

    @Override
    public void updateTravelPackage(TravelPackageDTO travelPackageDTO) throws  DuplicateException {
        if (!travelPackageRepository.existsById(travelPackageDTO.getTravelPackage_Id())){
            throw new DuplicateException("Travel Package couldn't found");
        }
        travelPackageRepository.save(modelMapper.map(travelPackageDTO, TravelPackage.class));
    }

    @Override
    public TravelPackageDTO findPackageById(String packageId) {
        Optional<TravelPackage> aPackage = travelPackageRepository.findById(packageId);
        return aPackage.map(value -> modelMapper.map(value, TravelPackageDTO.class)).orElse(null);
    }

    @Override
    public List<TravelPackageDTO> getAllPackages() {
        return modelMapper.map(travelPackageRepository.findAll(),new TypeToken<List<TravelPackageDTO>>(){}.getType());
    }

    @Override
    public void deletePackage(String packageId) throws  DuplicateException {
        if (!travelPackageRepository.existsById(packageId)){
            throw new DuplicateException("Travel Package couldn't found");
        }
        travelPackageRepository.deleteById(packageId);
    }

    @Override
    public String getNextId() {
        List<TravelPackage> packageList = travelPackageRepository.getLastPackageId();
        String lastPackageId="";
        if (!packageList.isEmpty()){
            System.out.println(packageList.get(0).getTravelPackage_Id());
            lastPackageId=packageList.get(0).getTravelPackage_Id();
        }

        return this.generateNextPackagelId(lastPackageId);
    }

    private String generateNextPackagelId(String lastPackageId) {
        String date="";
        String newDate="";
        date=new SimpleDateFormat("yyyy/MM").format(new Date());
        newDate="T/"+date;//G/2020/10@0001

        if(!(lastPackageId.equals(""))) {
            String[] ids = lastPackageId.split("@");
            int id = Integer.parseInt(ids[1]);
            id += 1;


            boolean isEquals=isDateEquals(ids[0],newDate);
            if(!isEquals){
                ids[0]=newDate;
                id=1;
            }

            String newLoginId=String.format("@%03d",id);
            return ids[0] + newLoginId;
        }

        return newDate+"@0001";
    }

    private boolean isDateEquals(String id, String date) {
        if(id.equals(date)){
            return true;
        }
        return false;
    }
}
