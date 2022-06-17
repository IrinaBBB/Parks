
package ru.irinavb.parks.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contacts {

    private List<PhoneNumber> phoneNumbers = null;
    private List<EmailAddress> emailAddresses = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
