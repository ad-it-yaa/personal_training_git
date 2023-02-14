package com.stackroute.smartparkingapp.repo;

import com.stackroute.smartparkingapp.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface is used to extend JpaRepository to manipulate/manage Parking related data
 * Annotate this class with @Repository annotation
 *
 * @Repository annotation indicates that an annotated class is a "Repository"
 **/
public interface ParkingRepo extends JpaRepository<Parking, Integer> {
}
