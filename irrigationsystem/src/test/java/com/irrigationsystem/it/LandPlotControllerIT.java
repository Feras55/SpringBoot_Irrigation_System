package com.irrigationsystem.it;


import com.irrigationsystem.entity.dto.LandPlot;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalTime;
import java.util.HashMap;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LandPlotControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("http://localhost:8080/api/landPlot/")
    private  String url;





    @Test
    void testGetLandPlot(){
        ResponseEntity<LandPlot> landPlot =this.restTemplate.getForEntity(url + "1", LandPlot.class);
        Assertions.assertNotNull(landPlot);
        Assertions.assertEquals(1,landPlot.getBody().getID());

    }



    @ParameterizedTest
    @CsvSource({"1"})
    void testIrrigateLandPlot(int id){
        HashMap<String, Integer> pathVariables = new HashMap<>();
        pathVariables.put("id", id);

        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url + "{id}/irrigate")
                .buildAndExpand(pathVariables);

        //This test is composed of two REST calls, PUT call to update the time slot
        //and GET call to retrieve the updated time slot

        //update the land plot's time slot
        this.restTemplate.put(uriComponents.toUriString(), null);

        //retrieve the updated time slot
        ResponseEntity<LandPlot> landPlot =this.restTemplate.getForEntity(url + "1", LandPlot.class);

        Assertions.assertNotNull(landPlot);
        Assertions.assertEquals(1,landPlot.getBody().getID());
        Assertions.assertEquals(LocalTime.of(2,30),landPlot.getBody().getTimeSlot());
    }

}
