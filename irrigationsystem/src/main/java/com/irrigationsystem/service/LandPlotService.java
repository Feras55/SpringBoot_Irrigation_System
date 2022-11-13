package com.irrigationsystem.service;

import com.irrigationsystem.entity.dto.LandPlot;

import java.util.List;


public interface LandPlotService {

    LandPlot createorUpdateLandPlot(LandPlot landPlot);

    List<LandPlot> getAllLandPlots();

    LandPlot getLandPlotById(int id);

//    LandPlot updateLandPlot(LandPlot landPlot, int id);

    public LandPlot irrigateLandPlot(int id);

    void deleteLandPlot(int id);

}
