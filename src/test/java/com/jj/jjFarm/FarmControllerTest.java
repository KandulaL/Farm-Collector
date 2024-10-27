package com.jj.jjFarm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.jj.farm.controller.FarmController;
import com.jj.farm.model.Farm;
import com.jj.farm.service.FarmService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FarmController.class)
public class FarmControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private FarmService farmService;
    
    @Test
    public void testGetAllReport() throws Exception {
        // Mock data
        List<Farm> farmDataList = Arrays.asList(
                new Farm(1L, "Farm 1", "corn", 100L, 100L, 100L ,"Spring"),
                new Farm(2L, "Farm 2", "potato", 100L, 100L, 100L , "Fall")
        );

        // Mock the service call
        when(farmService.getAllReports()).thenReturn(farmDataList);

        // Perform the GET request and verify the response
        mockMvc.perform(get("/reports")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Farm 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Farm 2"));
    }
    
    @Test
    public void testGetFarmById() throws Exception {
        Farm report = new Farm(1L, "Farm 1", "corn", 100L, 100L, 100L ,"Spring");
        // Set up the farm report object with appropriate data

        when(farmService.getReportByFarmId(1L)).thenReturn(report);

        mockMvc.perform(get("/reports/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.farmId").value("1L"));
                
    }
    
    @Test
    public void testGetFarmByCrop() throws Exception {
    	List<Farm> farmDataList = Arrays.asList(
                new Farm(1L, "Farm 1", "corn", 100L, 100L, 100L ,"Spring"),
                new Farm(3L, "Farm 3", "corn", 100L, 100L, 100L ,"Spring")
        );
        // Set up the farm report object with appropriate data

        when(farmService.getReportsByCrop("corn")).thenReturn(farmDataList);

        mockMvc.perform(get("/reports/corn"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.farmId").value("1L"))
        		.andExpect(jsonPath("$.farmId").value("3L"));
    }
}
