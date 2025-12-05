import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Doctor extends Person {
    private String name;
    private String email;
    private String phone;
    private int officeNumber;
    private ConsultType department;
    private TreeMap<String, ArrayList<MyDate>> operatingTimes;


    public Doctor(String name, String email, String phone, int officeNumber, ConsultType department) {
        super(name,email,phone);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.officeNumber = officeNumber;
        this.department = department;
        this.operatingTimes = new TreeMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getOfficeNumber() {
        return this.officeNumber;
    }

    public ConsultType getDepartment() {
        return this.department;
    }

    public TreeMap<String, ArrayList<MyDate>> getOperatingTimes() {
        return this.operatingTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public void setDepartment(ConsultType department) {
        this.department = department;
    }

    public void updateHours(String dayName, MyDate startTime, MyDate endTime) {
        ArrayList<MyDate> operatingHours = new ArrayList<MyDate>();
        operatingHours.add(startTime);
        operatingHours.add(endTime);
        operatingTimes.put(dayName, operatingHours);
    }

    public void editHours(String dayName) {
        operatingTimes.remove(dayName);
    }

    public String displayOfficeHours() {
        String hours = "";
        for (Map.Entry<String, ArrayList<MyDate>> entry : operatingTimes.entrySet()) {
            String day = entry.getKey();
            ArrayList<MyDate> times = entry.getValue();

            hours += day + " | " + times.get(0).toString() + " - " + times.get(1).toString() + "\n";
        }

        return hours;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nDepartment: " + department +
                "\nOperating Hours: " + displayOfficeHours() + "Office Number: " + officeNumber;
    }
}
