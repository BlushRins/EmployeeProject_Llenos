package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
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

    // Commission (and birthday incentive) come from CommissionEmployee
    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        displayEmployee();
        System.out.printf("Total Sales: ₱%,.2f | Base Salary: ₱%,.2f%n", getTotalSale(), baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Base Salary: ₱%,.2f, "
                        + "Sales: ₱%,.2f, Rate: %.0f%%, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), baseSalary,
                getTotalSale(), getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
