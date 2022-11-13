package com.irrigationsystem.service;

import com.irrigationsystem.entity.dao.LandPlotRepository;
import com.irrigationsystem.entity.dto.Crop;
import com.irrigationsystem.entity.dto.LandPlot;
import com.irrigationsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class LandPlotServiceImpl implements LandPlotService {

    private LandPlotRepository landPlotRepository;
    private SensorService sensorService = new SensorServiceImpl();


    public LandPlotRepository getLandPlotDAO() {
        return landPlotRepository;
    }

    @Autowired
    public void setLandPlotDAO(LandPlotRepository landPlotRepository) {
        this.landPlotRepository = landPlotRepository;
    }

    @Override
    public LandPlot createorUpdateLandPlot(LandPlot landPlot) {

        return landPlotRepository.save(landPlot);
    }

    @Override
    public List<LandPlot> getAllLandPlots() {
        List<LandPlot> landPlots = landPlotRepository.findAll();
        return landPlots;
    }

    @Override
    public LandPlot getLandPlotById(int id) {
        LandPlot landPlot = landPlotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Land Plot", "id", id));
        return landPlot;
    }


    @Override
    public void deleteLandPlot(int id) {
        LandPlot landPlotRetrieved = landPlotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Land Plot", "id", id));
        landPlotRepository.delete(landPlotRetrieved);
    }

    @Override
    public LandPlot irrigateLandPlot(int id) {
        //retrieve land plot from database
        LandPlot landPlotRetrieved = landPlotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Land Plot", "id", id));
        Crop crop = landPlotRetrieved.getCrop();

        // get amount of water

        float waterPerFeddan = predictWaterAmount(landPlotRetrieved, crop);

        //calculate total amount of time
        Long minutesPerFeddan = predictSlotTime(landPlotRetrieved, crop);

        sensorService.irrigateCallToSensor(landPlotRetrieved, waterPerFeddan);

        //update the landplot with the new timeslot
        landPlotRetrieved.setTimeSlot(LocalTime.now().plusMinutes(minutesPerFeddan));
        return createorUpdateLandPlot(landPlotRetrieved);
    }


    private Float predictWaterAmount(LandPlot landPlotRetrieved, Crop cropRetrieved) {
        float waterPerFeddan = cropRetrieved.getWaterPerFeddan();
        //calculate total amount of water
        waterPerFeddan = waterPerFeddan * landPlotRetrieved.getAreaInFeddan();
        return waterPerFeddan;
    }


    private Long predictSlotTime(LandPlot landPlotRetrieved, Crop cropRetrieved) {

        Long timePerFeddan = cropRetrieved.getMinutesPerFeddan();

        timePerFeddan = landPlotRetrieved.getAreaInFeddan() * timePerFeddan;

        return timePerFeddan;
    }

}
