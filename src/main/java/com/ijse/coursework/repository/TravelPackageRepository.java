package com.ijse.coursework.repository;

import com.ijse.coursework.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage,String> {
    @Query(value = "select t from TravelPackage t order by t.travelPackage_Id desc")
    List<TravelPackage> getLastPackageId();
}
