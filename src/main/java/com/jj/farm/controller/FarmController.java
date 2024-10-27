package com.jj.farm.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jj.farm.exception.ReportNotFoundException;
import com.jj.farm.model.Farm;
import com.jj.farm.service.FarmService;

@RestController
public class FarmController {
	private final FarmService farmService;
	
	@GetMapping("/")
	public String index() {
		return "Success!";
	}

    public FarmController(FarmService farmService) {
        this.farmService = farmService;
    }

    @PostMapping("/createFarm")
	public Farm createFarm(@RequestBody Farm farm) {
		return farmService.createFarm(farm);
	}
    
    @PostMapping("/updateFarm")
	public ResponseEntity<Farm> updateFarm(@RequestBody Farm farm) {
		return farmService.updateFarm(farm);
	}
    
    @GetMapping("/reports")
    public List<Farm> getAllReports() {
        return farmService.getAllReports();
    }

    @GetMapping("/reports/{farmId}")
    public Farm getReportByFarmId(@PathVariable Long farmId) throws ReportNotFoundException {
        return farmService.getReportByFarmId(farmId);
    }
    
    @GetMapping("/reports/{cropType}")
    public List<Farm> getReportByCrop(@PathVariable String cropType) throws ReportNotFoundException {
        return farmService.getReportsByCrop(cropType);
    }
  

}
