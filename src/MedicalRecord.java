public class MedicalRecord {
    MyDate dateOfConsult;
    ConsultType consultType;
    String consultingClinician;
    String prescription;

    public MedicalRecord(MyDate date, ConsultType consultType, String clinicianConsulted, String prescriptionName) {
        this.dateOfConsult = date;
        this.consultType = consultType;
        this.consultingClinician = clinicianConsulted;
        this.prescription = prescriptionName;
    }

    public MyDate getDateOfConsult() {
        return dateOfConsult;
    }

    public ConsultType getConsultType() {
        return consultType;
    }

    public String getConsultingClinician() {
        return consultingClinician;
    }

    public String getPrescription() {
        return prescription;
    }

    @Override
    public String toString() {
        return "Date of consult: " + dateOfConsult + "\nConsult Type: " + consultType +
                "\nClinician Consulted: " + consultingClinician + "\nPrescription(s): " + prescription;
    }
}
