package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() { super(); }
    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate) {
        this(empID, empName, birthDate, new MyDate(), 0.0, 0.0);
    }
    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate,
                                      double totalSale, double baseSalary) {
        this(empID, empName, birthDate, new MyDate(), totalSale, baseSalary);
    }
    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double value) {
        if (value < 0) {
            System.out.println("Invalid base salary. Value must not be negative.");
            baseSalary = 0.0;
        } else baseSalary = value;
    }

    @Override
    public double computeSalary() { return baseSalary + super.computeSalary(); }
    @Override
    public double computeSalary(int currentMonth) { return computeSalary() + birthdayBonus(currentMonth); }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%,.2f | Base Salary: ₱%,.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), getTotalSale(), baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, "
                        + "Base Salary: ₱%,.2f, Sales: ₱%,.2f, Rate: %.0f%%, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), baseSalary,
                getTotalSale(), getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BasePlusCommissionEmployee) || !super.equals(obj)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), baseSalary); }
    @Override
    public BasePlusCommissionEmployee clone() { return (BasePlusCommissionEmployee) super.clone(); }
}
