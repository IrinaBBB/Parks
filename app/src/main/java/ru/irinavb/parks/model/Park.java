
package ru.irinavb.parks.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Park {

    private String id;
    private String url;
    private String fullName;
    private String parkCode;
    private String description;
    private String latitude;
    private String longitude;
    private String latLong;
    private List<Activity> activities = null;
    private List<Topic> topics = null;
    private String states;
    private Contacts contacts;
    private List<EntranceFee> entranceFees = null;
    private List<Object> entrancePasses = null;
    private List<Object> fees = null;
    private String directionsInfo;
    private String directionsUrl;
    private List<OperatingHour> operatingHours = null;
    private List<Address> addresses = null;
    private List<Image> images = null;
    private String weatherInfo;
    private String name;
    private String designation;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getParkCode() {
        return parkCode;
    }

    public void setParkCode(String parkCode) {
        this.parkCode = parkCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<EntranceFee> getEntranceFees() {
        return entranceFees;
    }

    public void setEntranceFees(List<EntranceFee> entranceFees) {
        this.entranceFees = entranceFees;
    }

    public List<Object> getEntrancePasses() {
        return entrancePasses;
    }

    public void setEntrancePasses(List<Object> entrancePasses) {
        this.entrancePasses = entrancePasses;
    }

    public List<Object> getFees() {
        return fees;
    }

    public void setFees(List<Object> fees) {
        this.fees = fees;
    }

    public String getDirectionsInfo() {
        return directionsInfo;
    }

    public void setDirectionsInfo(String directionsInfo) {
        this.directionsInfo = directionsInfo;
    }

    public String getDirectionsUrl() {
        return directionsUrl;
    }

    public void setDirectionsUrl(String directionsUrl) {
        this.directionsUrl = directionsUrl;
    }

    public List<OperatingHour> getOperatingHours() {
        return operatingHours;
    }

    public void setOperatingHours(List<OperatingHour> operatingHours) {
        this.operatingHours = operatingHours;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
