package version2;

public class MyDate {

    private int day;
    private int mon;
    private int y;

    public MyDate() {
        this(1, 1, 1900);
    }

    public MyDate(int day, int mon, int y) {
        setY(y);
        setMon(mon);
        setDay(day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day < 1 || day > daysInMonth(mon, y)) {
            System.out.println("Invalid day. Value must be from 1 to " + daysInMonth(mon, y) + ".");
            this.day = 1;
        } else {
            this.day = day;
        }
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        if (mon < 1 || mon > 12) {
            System.out.println("Invalid month. Value must be from 1 to 12.");
            this.mon = 1;
        } else {
            this.mon = mon;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 1) {
            System.out.println("Invalid year. Value must not be zero or negative.");
            this.y = 1900;
        } else {
            this.y = y;
        }
    }

    private int daysInMonth(int mon, int y) {
        switch (mon) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(y) ? 29 : 28;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", mon, day, y);
    }
}
