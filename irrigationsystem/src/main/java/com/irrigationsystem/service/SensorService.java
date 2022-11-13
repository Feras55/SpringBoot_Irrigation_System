package com.irrigationsystem.service;

import com.irrigationsystem.entity.dto.Crop;
import com.irrigationsystem.entity.dto.LandPlot;

import java.time.LocalTime;

public interface SensorService {

    public void irrigateCallToSensor(LandPlot landPlotRetrieved, float waterPerFeddan);


}
