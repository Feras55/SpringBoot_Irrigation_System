package com.irrigationsystem.client;

import com.irrigationsystem.utilities.Status;


public class SensorClientImpl implements SensorClient {


    private static int generateRandomNumber() {
        int minimum = 0;
        int maximum = 10;
        return (int) Math.floor(Math.random() * (maximum - minimum + 1) + minimum);
    }

    @Override
    public boolean irrigate(int xCoordinate, int yCoordinate, float areaToIrrigate, float amountOfWater) {

        return getSensorStatus() == Status.AVAILABLE;
    }

    /**
     * Simulates the status of the sensor
     * Generates a random number n between 0-10.
     * if n < 5, sensor is not available
     * else, sensor is available
     *
     * @return boolean sensorAvailability
     */
    private Status getSensorStatus() {
        int random = generateRandomNumber();
        if (random < 5) {
            return Status.NOT_AVAILABLE;
        } else {
            return Status.AVAILABLE;
        }
    }


}
