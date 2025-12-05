public class Appointment {
    ConsultType consultType;
    String consultingClinician;

    public Appointment(ConsultType consultType, String clinician) {
        this.consultType = consultType;
        this.consultingClinician = clinician;
    }

    public void setConsultType(ConsultType consultType) {
        this.consultType = consultType;
    }

    public void setConsultingClinician(String clinicianName) {
        this.consultingClinician = clinicianName;
    }

    public ConsultType getConsultType() {
        return consultType;
    }

    public String getConsultingClinician() {
        return consultingClinician;
    }

    @Override
    public String toString() {
        return "\nConsult Type: " + consultType + "\nClinician: " + consultingClinician;
    }
}
