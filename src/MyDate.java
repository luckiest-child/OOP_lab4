public class MyDate  {
    private static int  MAX_DAYS = 31;
    private static int CURRENT_YEAR= 2025;
    private static int MAX_MONTH = 12;
    private static int MAX_HOUR = 24;
    private static int MAX_MINUTE = 60;
    int day;
    int month;
    int year;
    int hour;
    int minute;
    boolean isDateTime = false;
    boolean isTime = false;

    public MyDate(int day, int month, int year) {
        if (year > CURRENT_YEAR || year < 1200) {
            year = CURRENT_YEAR;
        }
        if (month > MAX_MONTH) {
            month %= MAX_MONTH;
        }
        if (month == 0 || month < 0) {
            month = 12;
        }

        switch (month) {
            case 4, 6, 9, 11 -> MAX_DAYS = 30;
            case 2 -> MAX_DAYS = 28;
            default -> MAX_DAYS = 31;
        }

        if (day > MAX_DAYS) {
            day %= MAX_DAYS;
        }
        if (day == 0) {
            day = MAX_DAYS;
        }

        this.day = day;
        this.month = month;
        this.year = year;


    }

    public MyDate(int day, int month, int year, int hour, int minute) {
        if (year > CURRENT_YEAR || year < 1200) {
            year = CURRENT_YEAR;
        }
        if (month > MAX_MONTH) {
            month %= MAX_MONTH;
        }
        if (month == 0 || month < 0) {
            month = 12;
        }

        switch (month) {
            case 4, 6, 9, 11 -> MAX_DAYS = 30;
            case 2 -> MAX_DAYS = 28;
            default -> MAX_DAYS = 31;
        }

        if (day > MAX_DAYS) {
            day %= MAX_DAYS;
        }
        if (day == 0) {
            day = MAX_DAYS;
        }

        this.day = day;
        this.month = month;
        this.year = year;
        this.minute = (minute % MAX_MINUTE);
        this.hour = (hour + (minute/MAX_MINUTE))%MAX_HOUR;
        isDateTime = true;
    }

    public MyDate(int hour, int minute) {
        this.minute = (minute % MAX_MINUTE);
        this.hour = (hour + (minute/MAX_MINUTE))%MAX_HOUR;
        isTime = true;
    }

    public void setDay (int day) {
        if (day > MAX_DAYS) {
            day %= MAX_DAYS;
        }
        if (day == 0) {
            day = MAX_DAYS;
        }
        this.day = day;
    }

    public void setYear(int year) {
        if (year > CURRENT_YEAR || year < 1200) {
            year = CURRENT_YEAR;
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month > MAX_MONTH) {
            month %= MAX_MONTH;
        }
        if (month == 0 || month < 0) {
            month = 12;
        }
        this.month = month;
    }

    public void setTime(int hour, int minute) {
        this.minute = (minute % MAX_MINUTE);
        this.hour = (hour + (minute/MAX_MINUTE))%MAX_HOUR;
        isTime = true;
    }

    public void setHour(int hour) {
        this.hour = (hour + (minute/MAX_MINUTE))%MAX_HOUR;
    }

    public void setMinute(int minute) {
        this.minute = (minute % MAX_MINUTE);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear(){
        return year;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        if (isDateTime) {
            return String.format("%02d-%02d-%4d | %02d:%02d", day, month, year, hour, minute);
        } else if (isTime) {
            return String.format("%02d:%02d",hour, minute);
        } else {
            return String.format("%02d-%02d-%4d", day, month, year);
        }
    }
}
