package com.irrigationsystem;

import com.irrigationsystem.entity.dto.LandPlot;
import com.irrigationsystem.service.LandPlotService;
import com.irrigationsystem.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController()
@RequestMapping("/api/landPlot")
public class LandPlotController {

    private LandPlotService landPlotService;
    private SensorService sensorService;


    @Autowired
    public void setLandPlotService(LandPlotService landPlotService) {
        this.landPlotService = landPlotService;
    }

    @PostMapping
    public ResponseEntity<LandPlot> createOrUpdateLandPlot(@RequestBody LandPlot landPlot) {
        return new ResponseEntity<>(landPlotService.createorUpdateLandPlot(landPlot), HttpStatus.CREATED);
    }

    @GetMapping
    public List<LandPlot> getAllLandPlots() {
        return landPlotService.getAllLandPlots();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LandPlot> getLandPlotById(@PathVariable(name = "id") int id) {
        return ResponseEntity.ok(landPlotService.getLandPlotById(id));
    }


    @PutMapping
    public ResponseEntity<LandPlot> updateLandPlot(@RequestBody LandPlot landPlot) {
        LandPlot updatedLandPlot = landPlotService.createorUpdateLandPlot(landPlot);
        return new ResponseEntity<>(updatedLandPlot, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLandPlot(@PathVariable(name = "id") int id) {

        landPlotService.deleteLandPlot(id);
        return new ResponseEntity<>("Land Plot deleted Successfully", HttpStatus.OK);

    }

    //irrigate and update the land-plot's time slot

    @PutMapping("/{id}/irrigate")
    public ResponseEntity<LandPlot> irrigateLandPLot(@PathVariable(name = "id") int id){

        LandPlot irrigatedLandPlot = landPlotService.irrigateLandPlot(id);
        return new ResponseEntity<>(irrigatedLandPlot,HttpStatus.OK);

    }



}
