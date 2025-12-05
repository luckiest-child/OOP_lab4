import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ClinicManagementSystem implements FileOperations, ReportGenerator{
    private HashMap<Integer, Patient> patients;
    private ArrayList<Doctor> doctors;
    private TreeMap<String, ArrayList<Appointment>> appointmentsByDate;
    private static int nextPatientId = 1;

    public ClinicManagementSystem() {
        this.patients = new HashMap<>();
        this.doctors = new ArrayList<>();
        this.appointmentsByDate = new TreeMap<>();
    }

    @Override
    public void saveToFile(String filename, String info) throws IOException {
        File file = new File(filename);
        if (file.exists()) {
            //appending to the file
            FileWriter fw = new FileWriter(file, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(info);
            pw.close();
        } else {
            //creating a new file
            PrintWriter pw = new PrintWriter(file);
            pw.println(info);
            pw.close();
        }
    }

    @Override
    public void loadFromFile(String filename) throws IOException {
        //using scanner to read patient data
        try(Scanner scanner = new Scanner(new File(filename))) {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }

    public void addPatient(Patient patient) {
        patients.put(patient.getPatientId(), patient);
    }

    public Patient findPatient(int patientId) {
        return patients.get(patientId);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public Doctor findDoctor(String name) {
        for (Doctor doc : doctors) {
            if (doc.getName().equalsIgnoreCase(name)) {
                return doc;
            }
        }
        return null;
    }

    public void setAppointment(MyDate date, ArrayList<Appointment> appointment) {
        appointmentsByDate.put(date.toString(), appointment);
    }

    @Override
    public String generatePatientReport(int patientId) {
        ArrayList<MedicalRecord> record = patients.get(patientId).getMedicalHistory();
        String patientRecord = "";

        for (MedicalRecord medicalRecord: record) {
            patientRecord += medicalRecord.toString() + "\n";
        }

        return patientRecord;
    }

    @Override
    public String generateDailyAppointments(MyDate date) {
        String output = date.toString();
        for (Map.Entry<String, ArrayList<Appointment>> entry : appointmentsByDate.entrySet()) {
            if (entry.getKey().equals(date.toString())) {
                for (Appointment appt : entry.getValue()) {
                    output += appt.toString();
                }
            }
        }
        return output;
    }
}
