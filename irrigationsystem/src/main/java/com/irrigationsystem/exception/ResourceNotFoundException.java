package com.irrigationsystem.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private String resourceName;
    private String fieldName;
    private int fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, int fieldValue) {
        //custom resource not found exception message
        super(String.format(resourceName + " not found with " + fieldName + ": " + fieldValue));      //land_plot not found with id: 1
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;

    }

    public String getResourceName() {
        return resourceName;
    }


    public String getFieldName() {
        return fieldName;
    }


    public int getFieldValue() {
        return fieldValue;
    }


}