package com.jj.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jj.farm.model.Farm;

public interface FarmRepository extends JpaRepository<Farm, Long> {

}
