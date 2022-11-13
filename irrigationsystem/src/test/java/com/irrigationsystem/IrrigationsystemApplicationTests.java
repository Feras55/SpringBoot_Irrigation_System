package com.irrigationsystem;

import com.irrigationsystem.service.LandPlotService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
class IrrigationsystemApplicationTests {

    @Autowired
    private LandPlotService landPlotService;



    @Test
    void contextLoads() {
    }

}

