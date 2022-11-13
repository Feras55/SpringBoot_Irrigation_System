package com.irrigationsystem.service;

import com.irrigationsystem.IrrigationsystemApplication;
import com.irrigationsystem.LandPlotController;
import com.irrigationsystem.entity.dao.LandPlotRepository;
import com.irrigationsystem.entity.dto.Crop;
import com.irrigationsystem.entity.dto.LandPlot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;

@RunWith(SpringRunner.class)
@WebMvcTest(value = LandPlotController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class LandPlotRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LandPlotService landPlotService;

    @Before
    public void setUp() throws Exception{

    }

    @Test
    public void whenPostLandPlot_thenCreateLandPlot() throws Exception{

        Crop crop = new Crop(1,"Wheat", (float) 2.54, 6L);
        LocalTime time = LocalTime.of(12,30);
        LandPlot landPlot = new LandPlot(5,crop,time,5,7);


    }
}
