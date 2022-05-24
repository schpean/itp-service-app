package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.Cursor;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.AppointmentAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.Appointment;

import java.time.LocalDate;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;
public class AppointmentService {

    private static ObjectRepository<Appointment> appointmentRepository;

    public static void initDatabase() throws UsernameAlreadyExistsException, AppointmentAlreadyExistsException {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("ScheduledAppointment.db").toFile())
                .openOrCreate("test", "test");
        appointmentRepository = database.getRepository(Appointment.class);
    }

    public static Appointment addAppointment(int id, String serviceName, LocalDate availability, String customerUserName, String engineerUserName, String status) throws UsernameAlreadyExistsException, AppointmentAlreadyExistsException {
        //checkAppointmentDoesNotAlreadyExist(serviceName, availability, customerUserName, engineerUserName);
        Appointment appointment = new Appointment(id, serviceName, availability, customerUserName, engineerUserName, status);
        appointmentRepository.insert(appointment);
        return appointment;
    }

    public static long getAppointments() {
        Cursor results = appointmentRepository.find();
        return appointmentRepository.size();
    }

    /*
 public static void checkAppointmentDoesNotAlreadyExist(String serviceName, LocalDate availability, String customerUserName, String engineerUserName) throws AppointmentAlreadyExistsException {
        for (Appointment appointment : appointmentRepository.find()) {
            if (Objects.equals(serviceName, appointment.getServiceName())
            && availability.compareTo( appointment.getAvailability()) == 0
            && Objects.equals(customerUserName, appointment.getCustomerUserName())
            && Objects.equals(engineerUserName, appointment.getEngineerUserName()))
               throw new AppointmentAlreadyExistsException("This appointment already exist in db!");
       }
    }*/
}

