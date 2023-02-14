package com.natwest.awareness_api.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.awareness_api.model.Awareness;

@Repository
public interface AwarenessRepo extends CrudRepository<Awareness, Integer> {

	List<Awareness> findAll(Sort by);

}
