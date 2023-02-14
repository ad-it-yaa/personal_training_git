package com.natwest.adapi.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.adapi.model.Advertisement;

@Repository
public interface AdvertisementRepo extends CrudRepository<Advertisement, Integer> {

	List<Advertisement> findAll(Sort by);

}
