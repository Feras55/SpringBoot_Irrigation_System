package com.irrigationsystem.service;

import com.irrigationsystem.client.SensorClient;
import com.irrigationsystem.client.SensorClientImpl;
import com.irrigationsystem.entity.dao.CropRepository;
import com.irrigationsystem.entity.dao.LandPlotRepository;
import com.irrigationsystem.entity.dto.LandPlot;
import com.irrigationsystem.exception.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorServiceImpl implements SensorService {
    private static int counter = 0;
    LandPlotRepository landPlotRepository;
    CropRepository cropRepository;
    SensorClient sensorClient = new SensorClientImpl();

    @Autowired
    public void setCropDAO(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }


    @Autowired
    public void setLandPlotDAO(LandPlotRepository landPlotRepository) {
        this.landPlotRepository = landPlotRepository;
    }

    /**
     * Calls the sensor simulation and sends a landplot, recieves whether the request has been sent
     * and irrigation has been performed successfully or not
     * if request fails, performs retry pattern
     *
     * @param landPlotRetrieved,waterPerFeddan
     * @return void
     */
    @Override
    public void irrigateCallToSensor(LandPlot landPlotRetrieved, float waterPerFeddan) {
        try {
            irrigate(landPlotRetrieved, waterPerFeddan);
            System.out.println("Irrigation Performed");
            //it should call the landplotservice to do the update part?
            //now since the irrigation is performed
            //the new timeslot of the landplot should be ((predictedTimeSlot + landplot.timeslot)%24 (24 hours time format (12 AM == 0.0))

        } catch (SensorNotFoundException e) {

            if (counter < 3) {
                System.out.println("Irrigation call failed, attempt number: " + counter + ". Retry!");
                counter++;
                irrigateCallToSensor(landPlotRetrieved, waterPerFeddan); //it is calling irrigate here in the catch block, it should call irrigateCallToSensor

            } else {
                System.out.println("Number of attempts exceeded limit, Sensor is out of service!!");
                throw e;
            }
        }

    }

    private void irrigate(LandPlot landPlotRetrieved, float waterPerFeddan) {
        sensorClient.irrigate(landPlotRetrieved.getxCoordinate(), landPlotRetrieved.getyCoordinate(), landPlotRetrieved.getAreaInFeddan(), waterPerFeddan);
        counter = 0;
    }


}
