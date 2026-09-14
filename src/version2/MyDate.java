package version2;

public class MyDate {
    private int day;
    private int mon;
    private int y;

    public MyDate() {
        this(1, 1, 1900);
    }

    public MyDate(int day, int mon, int y) {
        this.day = day;
        this.mon = mon;
        this.y = y;
    }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = day; }

    public int getMon() { return mon; }
    public void setMon(int mon) { this.mon = mon; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", mon, day, y);
    }
}