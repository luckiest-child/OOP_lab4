import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class DriverClass {
    public static void main(String[] args) throws IOException {
        Patient patient1 = new Patient("Yaa", "yaa@email.com", "020111111");
        Patient patient2 = new Patient("Naa", "naa@gmail.com", "020222222");
        Patient patient3 = new Patient("Nii", "nii@gmail.com", "020333333");

        System.out.println(patient1.getPatientId());
        System.out.println(patient2.getPatientId());
        System.out.println(patient3.getPatientId());

        MyDate date1 = new MyDate(2, 5, 2001);
        MyDate date2 = new MyDate(3, 7, 2003);
        MedicalRecord record1 = new MedicalRecord(date1, ConsultType.CHECKUP_ROUTINE, "Dr.Akora", "N/A");
        MedicalRecord record2 = new MedicalRecord(date2, ConsultType.EYE_CLINIC, "Dr.Gaza", "Eye drops");

        patient1.addMedicalRecord(record1);
        patient1.addMedicalRecord(record2);

        MyDate date3 = new MyDate(31, 6, 2022);
        Appointment appt1 = new Appointment(ConsultType.DENTAL_VISIT, "Dr. Rashel");
        patient2.bookAppointment(date3, appt1);

        MyDate date4 = new MyDate(15, 12, 2024);
        MyDate date5 = new MyDate(30, 11, 2023);
        Appointment appt2 = new Appointment(ConsultType.MEDICATION_REFILL, "Dr. Kim");
        Appointment appt3 = new Appointment(ConsultType.ENT_VISIT, "Dr. Liang");
        patient3.bookAppointment(date4, appt2);
        patient3.bookAppointment(date5, appt3);

        MyDate date6 = new MyDate(2, 1, 2021);
        MyDate date7 = new MyDate(3, 7, 2011);
        MedicalRecord record3 = new MedicalRecord(date1, ConsultType.CHECKUP_ROUTINE, "Dr.Akora", "N/A");
        MedicalRecord record4 = new MedicalRecord(date2, ConsultType.LAB_TEST, "Dr.Gaza", "N/A");
        patient3.addMedicalRecord(record3);
        patient3.addMedicalRecord(record4);

        ArrayList<MedicalRecord> md1 = patient1.getMedicalHistory();
        for (MedicalRecord record: md1) {
            System.out.println(record.toString());
        }

        TreeMap<String, Appointment> appt_1 = patient3.getAppointments();

        for (Map.Entry<String, Appointment> entry : appt_1.entrySet()){
            System.out.println(entry.getKey() + entry.getValue().toString());
        }

        System.out.println(patient1.toString());
        System.out.println(patient2.toString());
        System.out.println(patient3.toString());

        Doctor doc1 = new Doctor("Dr. Lamptey", "lamptey@gmail.com", "055445555", 12, ConsultType.OBSTETRICS_GYNAE);
        MyDate time1 = new MyDate(8, 0);
        MyDate time2 = new MyDate(5, 30);
        doc1.updateHours("Monday to Wednesday", time1, time2);
        MyDate time3 = new MyDate(12, 30);
        MyDate time4 = new MyDate(9, 0);
        doc1.updateHours("Saturday", time3, time4);

        System.out.println(doc1.displayOfficeHours());

        doc1.editHours("Saturday");

        System.out.println(doc1.displayOfficeHours());
        System.out.println(doc1.toString());



        ClinicManagementSystem system = new ClinicManagementSystem();
        Doctor doc2 = new Doctor("Dr. Elikem", "eli@gmail.com", "055445455", 11, ConsultType.XRAY);
        system.addDoctor(doc1);
        system.addDoctor(doc2);

        System.out.println(system.findDoctor("Dr. Lamptey"));

        system.addPatient(patient1);
        system.addPatient(patient3);

        System.out.println(system.findPatient(patient3.getPatientId()));

        ArrayList<Appointment> appts = new ArrayList<>();
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);

        system.setAppointment(date5,appts);
        System.out.println(system.generateDailyAppointments(date5));
        System.out.println(system.generatePatientReport(patient3.getPatientId()));


        system.saveToFile("appointments.txt", system.generateDailyAppointments(date5));
        system.loadFromFile("appointments.txt");

    }
}
