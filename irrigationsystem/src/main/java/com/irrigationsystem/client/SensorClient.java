package com.irrigationsystem.client;


public interface SensorClient {
    boolean irrigate(int xCoordinate, int yCoordinate, float areaToIrrigate, float amountOfWater);


}

