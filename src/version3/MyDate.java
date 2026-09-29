package version3;

import java.util.Objects;

public class MyDate implements Cloneable {

    private static final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    private int day;
    private int month;
    private int year;

    public MyDate() { this(1, 1, 2000); }

    public MyDate(int day, int month, int year) {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public int getDay() { return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }

    public void setDay(int value) {
        if (value < 1 || value > daysInMonth(month, year)) {
            System.out.println("Invalid day. Value must be from 1 to " + daysInMonth(month, year) + ".");
            day = 1;
        } else day = value;
    }

    public void setMonth(int value) {
        if (value < 1 || value > 12) {
            System.out.println("Invalid month. Value must be from 1 to 12.");
            month = 1;
            return;
        }
        month = value;
        if (day > daysInMonth(month, year)) day = daysInMonth(month, year);
    }

    public void setYear(int value) {
        if (value < 1) {
            System.out.println("Invalid year. Value must not be zero or negative.");
            year = 2000;
        } else year = value;
        if (day > daysInMonth(month, year)) day = daysInMonth(month, year);
    }

    // Aliases keep the shorter names used by the original version 3 code working.
    public int getMon() { return getMonth(); }
    public void setMon(int value) { setMonth(value); }
    public int getY() { return getYear(); }
    public void setY(int value) { setYear(value); }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 4: case 6: case 9: case 11: return 30;
            case 2: return isLeapYear(year) ? 29 : 28;
            default: return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static String getMonthName(int month) {
        return month >= 1 && month <= 12 ? MONTH_NAMES[month - 1] : "N/A";
    }

    public void displayDate() { System.out.println(this); }
    public void display() { displayDate(); }

    @Override
    public String toString() { return String.format("%02d %s %04d", day, getMonthName(month), year); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyDate)) return false;
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() { return Objects.hash(day, month, year); }

    @Override
    public MyDate clone() {
        try { return (MyDate) super.clone(); }
        catch (CloneNotSupportedException exception) { throw new AssertionError(exception); }
    }
}
