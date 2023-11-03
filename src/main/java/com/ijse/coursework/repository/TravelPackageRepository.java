package com.ijse.coursework.repository;

import com.ijse.coursework.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage,String> {

}
