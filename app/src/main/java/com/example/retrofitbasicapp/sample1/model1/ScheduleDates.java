package com.example.retrofitbasicapp.sample1.model1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScheduleDates
{
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("startLocation")
    @Expose
    private String startLocation;
    @SerializedName("direction")
    @Expose
    private String direction;
    @SerializedName("serviceType")
    @Expose
    private String serviceType;
    @SerializedName("classType")
    @Expose
    private String classType;
    @SerializedName("distance")
    @Expose
    private Double distance;

    public ScheduleDates(String startTime, String endTime, String startLocation,
                         String direction, String serviceType, String classType,
                         Double distance)
    {
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLocation = startLocation;
        this.direction = direction;
        this.serviceType = serviceType;
        this.classType = classType;
        this.distance = distance;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

}
