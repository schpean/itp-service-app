package org.loose.fis.sre.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.dizitart.no2.objects.Id;

import java.time.LocalDate;
import java.util.Objects;

public class Appointment {
    @Id
    private int id;
    private String ServiceName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate availability;
    private String customerUserName;

    private String engineerUserName;


    private String status;

    //public ObservableList<Appointment> appobs;

    public Appointment(int id, String serviceName, LocalDate availability, String customerUserName, String engineerUserName, String status) {
        this.id = id;
        this.ServiceName = serviceName;
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

    public LocalDate getAvailability() {
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

    public void setAvailability(LocalDate availability) {
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
