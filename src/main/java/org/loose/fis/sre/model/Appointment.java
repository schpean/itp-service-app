package org.loose.fis.sre.model;

import org.dizitart.no2.objects.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {

    @Id
    private int id;

    private String ServiceName;

    private LocalDateTime availability;

    private String customerUserName;

    private String engineerUserName;

    private String status;

    public Appointment() {

    }

    public Appointment(int id, String serviceName, LocalDateTime availability, String customerUserName, String engineerUserName, String status) {
        this.id = id;
        ServiceName = serviceName;
        this.availability = availability;
        this.customerUserName = customerUserName;
        this.engineerUserName = engineerUserName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public LocalDateTime getAvailability() {
        return availability;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public String getEngineerUserName() {
        return engineerUserName;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public void setAvailability(LocalDateTime availability) {
        this.availability = availability;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public void setEngineerUserName(String engineerUserName) {
        this.engineerUserName = engineerUserName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return id == that.id && Objects.equals(ServiceName, that.ServiceName) && Objects.equals(availability, that.availability) && Objects.equals(customerUserName, that.customerUserName) && Objects.equals(engineerUserName, that.engineerUserName) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ServiceName, availability, customerUserName, engineerUserName, status);
    }
}
