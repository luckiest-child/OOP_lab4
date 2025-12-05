import java.util.ArrayList;
import java.util.TreeMap;

public class Patient extends Person {
    private static int IdNumber = 1000;
    private int patientId;
    private ArrayList<MedicalRecord> medicalHistory;
    private TreeMap<String, Appointment> appointments;

    public Patient(String name, String email, String phone) {
        super(name, email, phone);
        this.patientId = IdNumber++;
        this.medicalHistory = new ArrayList<>();
        this.appointments = new TreeMap<>();

    }

    public void addMedicalRecord(MedicalRecord record) {
        medicalHistory.add(record);
    }

    public void bookAppointment(MyDate date, Appointment appointment){
        appointments.put(date.toString(), appointment);
    }

    public ArrayList<MedicalRecord> getMedicalHistory() {
        return new ArrayList<>(medicalHistory);
    }

    public TreeMap<String, Appointment> getAppointments() {
        return appointments;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return patientId + "," + name + "," + email + "," + phone;
    }
}

