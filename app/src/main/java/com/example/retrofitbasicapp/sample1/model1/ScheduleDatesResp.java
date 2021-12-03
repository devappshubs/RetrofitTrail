package com.example.retrofitbasicapp.sample1.model1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScheduleDatesResp
{
    public static final int LayoutOne = 0;
    public static final int LayoutTwo = 1;
    int viewType;

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("createdBy")
    @Expose
    private Object createdBy;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("availableLocation")
    @Expose
    private String availableLocation;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("vehicle")
    @Expose
    private ScheduleDatesVehicle vehicle;
    @SerializedName("price")
    @Expose
    private Double price;

    public ScheduleDatesResp(int viewType, ScheduleDatesVehicle vehicle) {
        this.viewType = viewType;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getAvailableLocation() {
        return availableLocation;
    }

    public void setAvailableLocation(String availableLocation) {
        this.availableLocation = availableLocation;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ScheduleDatesVehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(ScheduleDatesVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
