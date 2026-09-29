package version3;

import java.util.Objects;

public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() { super(); }
    public HourlyEmployee(int empID, Name empName, MyDate birthDate) {
        this(empID, empName, birthDate, new MyDate(), 0.0f, 0.0);
    }
    public HourlyEmployee(int empID, Name empName, MyDate birthDate,
                          float totalHoursWorked, double ratePerHour) {
        this(empID, empName, birthDate, new MyDate(), totalHoursWorked, ratePerHour);
    }
    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public double getRatePerHour() { return ratePerHour; }

    public void setTotalHoursWorked(float value) {
        if (value < 0) {
            System.out.println("Invalid hours worked. Value must not be negative.");
            totalHoursWorked = 0.0f;
        } else totalHoursWorked = value;
    }

    public void setRatePerHour(double value) {
        if (value < 0) {
            System.out.println("Invalid rate per hour. Value must not be negative.");
            ratePerHour = 0.0;
        } else ratePerHour = value;
    }

    @Override
    public double computeSalary() {
        if (totalHoursWorked <= 40) return totalHoursWorked * ratePerHour;
        return 40 * ratePerHour + (totalHoursWorked - 40) * ratePerHour * 1.5;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeSalary() + birthdayBonus(currentMonth);
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%,.2f/hr%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, "
                        + "Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof HourlyEmployee) || !super.equals(obj)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour); }
    @Override
    public HourlyEmployee clone() { return (HourlyEmployee) super.clone(); }
}
