
package ru.irinavb.parks.model;

import java.util.HashMap;
import java.util.Map;

public class Exception {

    private ExceptionHours exceptionHours;
    private String startDate;
    private String name;
    private String endDate;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public ExceptionHours getExceptionHours() {
        return exceptionHours;
    }

    public void setExceptionHours(ExceptionHours exceptionHours) {
        this.exceptionHours = exceptionHours;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
