package version1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HourlyEmployee {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

    private int empID;
    private String empName;
    private LocalDate birthDate;
    private LocalDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.birthDate = null;
        this.dateHired = null;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName, LocalDate birthDate, LocalDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName, LocalDate birthDate, LocalDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        if (empName == null || empName.trim().isEmpty()) {
            this.empName = "N/A";
        } else {
            this.empName = empName;
        }
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(LocalDate dateHired) {
        this.dateHired = dateHired;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            System.out.println("Invalid hours worked. Value must not be negative.");
            this.totalHoursWorked = 0;
        } else {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            System.out.println("Invalid rate per hour. Value must not be negative.");
            this.ratePerHour = 0;
        } else {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary() {
        double regularPay;
        double overtimePay = 0;

        if (totalHoursWorked <= 40) {
            regularPay = totalHoursWorked * ratePerHour;
        } else {
            regularPay = 40 * ratePerHour;
            overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
        }
        return regularPay + overtimePay;
    }

    // Adds the birthday incentive when the payroll month is the employee's birth month
    public double computeSalary(int payrollMonth) {
        if (birthDate != null && payrollMonth == birthDate.getMonthValue()) {
            return computeSalary() + BIRTHDAY_INCENTIVE;
        }
        return computeSalary();
    }

    private String formatDate(LocalDate date) {
        if (date == null) {
            return "N/A";
        }
        return date.format(DATE_FORMAT);
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%,.2f/hr%n",
                empID, empName, formatDate(birthDate), formatDate(dateHired), totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%,.2f, "
                        + "Total Salary: ₱%,.2f]",
                empID, empName, formatDate(birthDate), formatDate(dateHired), totalHoursWorked, ratePerHour, computeSalary());
    }
}
