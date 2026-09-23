package version2;

public class MyDate {

    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > daysInMonth(month, year)) {
            System.out.println("Invalid day. Value must be from 1 to " + daysInMonth(month, year) + ".");
            this.day = 1;
        } else {
            this.day = day;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Invalid month. Value must be from 1 to 12.");
            this.month = 1;
        } else {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1) {
            System.out.println("Invalid year. Value must not be zero or negative.");
            this.year = 2000;
        } else {
            this.year = year;
        }
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Returns the 3-letter month name, e.g. 9 -> "Sep"
    public static String getMonthName(int month) {
        if (month < 1 || month > 12) {
            return "N/A";
        }
        return MONTH_NAMES[month - 1];
    }

    public void displayDate() {
        System.out.println(this);
    }

    // Returns "DD Mon YYYY", e.g. "18 Sep 2026"
    @Override
    public String toString() {
        return String.format("%02d %s %04d", day, getMonthName(month), year);
    }
}
