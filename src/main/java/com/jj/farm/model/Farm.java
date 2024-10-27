package com.jj.farm.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 * Class to hold the Farm details
 * 
 * @author Lavanya K
 * @since Oct 27, 2024
 *
 * @changelog
 * 
 *
 */

@Entity
public class Farm {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long farmId;
	
	private String farmerName;
	private String cropName;
	private Long farmArea;
	private Long harvestExpected;
	private Long harvestActual;
	private String season;
	
	public Farm(Long farmId, String farmerName, String cropName, Long farmArea, Long harvestExpected, Long harvestActual, String season) {
		this.farmId = farmId;
        this.farmerName = farmerName;
        this.cropName = cropName;
        this.farmArea = farmArea;
        this.harvestExpected = harvestExpected;
        this.harvestActual = harvestActual;
        this.season = season;
	}

	public Long getFarmId() {
		return farmId;
	}
	
	@JsonProperty("farmId")
	public void setFarmId(Long farmId) {
		this.farmId = farmId;
	}
	public String getFarmerName() {
		return farmerName;
	}
	
	@JsonProperty("farmerName")
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getCropName() {
		return cropName;
	}
	
	@JsonProperty("cropName")
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public Long getFarmArea() {
		return farmArea;
	}
	
	@JsonProperty("cropName")
	public void setFarmArea(Long farmArea) {
		this.farmArea = farmArea;
	}

	public Long getHarvestExpected() {
		return harvestExpected;
	}

	@JsonProperty("harvestExpected")
	public void setHarvestExpected(Long harvestExpected) {
		this.harvestExpected = harvestExpected;
	}

	public Long getHarvestActual() {
		return harvestActual;
	}
	
	@JsonProperty("harvestActual")
	public void setHarvestActual(Long harvestActual) {
		this.harvestActual = harvestActual;
	}

	public String getSeason() {
		return season;
	}
	
	@JsonProperty("season")
	public void setSeason(String season) {
		this.season = season;
	}
	
}
