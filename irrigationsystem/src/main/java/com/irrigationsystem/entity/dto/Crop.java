package com.irrigationsystem.entity.dto;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "crop")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "crop_name")
    private String cropName;
    @Column(name = "water_per_feddan")
    private float waterPerFeddan;
    @Column(name = "time_per_feddan")
    private Long minutesPerFeddan;

    public Crop(Integer id, String crop_name, float waterPerFeddan, Long minutesPerFeddan) {
        this.id = id;
        this.cropName = crop_name;
        this.waterPerFeddan = waterPerFeddan;
        this.minutesPerFeddan = minutesPerFeddan;
    }

    public Crop() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String crop_name) {
        this.cropName = crop_name;
    }

    public float getWaterPerFeddan() {
        return waterPerFeddan;
    }

    public void setWaterPerFeddan(float waterPerFeddan) {
        this.waterPerFeddan = waterPerFeddan;
    }

    public Long getMinutesPerFeddan() {
        return minutesPerFeddan;
    }

    public void setMinutesPerFeddan(Long timePerFeddan) {
        this.minutesPerFeddan = timePerFeddan;
    }
}
