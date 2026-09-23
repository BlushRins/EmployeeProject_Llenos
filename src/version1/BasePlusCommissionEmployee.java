package version1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class BasePlusCommissionEmployee {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

    private int empID;
    private String empName;
    private LocalDate birthDate;
    private LocalDate dateHired;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.birthDate = null;
        this.dateHired = null;
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, LocalDate birthDate, LocalDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, LocalDate birthDate, LocalDate dateHired,
                                      double totalSale, double baseSalary) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            System.out.println("Invalid total sale. Value must not be negative.");
            this.totalSale = 0;
        } else {
            this.totalSale = totalSale;
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            System.out.println("Invalid base salary. Value must not be negative.");
            this.baseSalary = 0;
        } else {
            this.baseSalary = baseSalary;
        }
    }

    public double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    public double computeSalary() {
        return baseSalary + (totalSale * getCommissionRate());
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

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%,.2f | Base Salary: ₱%,.2f%n",
                empID, empName, formatDate(birthDate), formatDate(dateHired), totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Base Salary: ₱%,.2f, "
                        + "Sales: ₱%,.2f, Rate: %.0f%%, Total Salary: ₱%,.2f]",
                empID, empName, formatDate(birthDate), formatDate(dateHired), baseSalary, totalSale,
                getCommissionRate() * 100, computeSalary());
    }
}
