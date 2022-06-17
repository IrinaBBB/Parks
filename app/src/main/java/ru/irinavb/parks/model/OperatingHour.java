
package ru.irinavb.parks.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatingHour {

    private List<Exception> exceptions = null;
    private String description;
    private StandardHours standardHours;
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StandardHours getStandardHours() {
        return standardHours;
    }

    public void setStandardHours(StandardHours standardHours) {
        this.standardHours = standardHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
