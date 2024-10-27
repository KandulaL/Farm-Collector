package com.jj.farm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jj.farm.exception.ReportNotFoundException;
import com.jj.farm.model.Farm;
import com.jj.farm.repository.FarmRepository;

/**
 * FarmService contains methods used for accessing farm details
 * 
 * @author Lavanya K
 * @Version 1.0
 * @Changelog
 * 
 */

@Service
public class FarmService {

	@Autowired
	private final FarmRepository farmRepository;

    public FarmService(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }

	public Farm createFarm(@RequestBody Farm farm) {
		return farmRepository.save(farm);
	}
	
	public ResponseEntity<Farm> updateFarm(@RequestBody Farm farm) {

		return farmRepository.findById(farm.getFarmId()).map(existingFarm -> {
			existingFarm.setHarvestActual(farm.getHarvestActual());

			return ResponseEntity.ok().body(farmRepository.save(existingFarm));
		}).orElse(ResponseEntity.notFound().build());
	}
    
    
    public List<Farm> getAllReports() {
        return farmRepository.findAll();
    }

    public Farm getReportByFarmId(Long farmId) throws ReportNotFoundException {
        return farmRepository.findById(farmId)
        		.orElseThrow(() -> new ReportNotFoundException("Report not found for farmId: " + farmId));
    }

    public List<Farm> getReportsByCrop(String cropType) {
        return farmRepository.findAll().stream()
                .filter(report -> report.getCropName().equals(cropType))
                .collect(Collectors.toList());
    }

}
