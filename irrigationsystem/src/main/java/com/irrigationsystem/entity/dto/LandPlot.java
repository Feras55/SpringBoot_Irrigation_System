package com.irrigationsystem.entity.dto;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "land_plot")
public class LandPlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;
    @Column(name = "area_in_feddan")
    private Integer areaInFeddan;

    @OneToOne
    private Crop crop;


    @Column(name = "time_slot")
    private LocalTime timeSlot;


    @Column(name = "x_coordinate")
    private int xCoordinate;

    @Column(name = "y_coordinate")
    private int yCoordinate;

    public LandPlot() {

    }

    public LandPlot(Integer areaInFeddan, Crop crop, LocalTime timeSlot, int xCoordinate, int yCoordinate) {
        this.areaInFeddan = areaInFeddan;
        this.crop = crop;
        this.timeSlot = timeSlot;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getAreaInFeddan() {
        return areaInFeddan;
    }

    public void setAreaInFeddan(Integer areaInFeddan) {
        this.areaInFeddan = areaInFeddan;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public LocalTime getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalTime timeSlot) {
        this.timeSlot = timeSlot;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
