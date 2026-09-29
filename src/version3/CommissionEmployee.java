package version3;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() { super(); }
    public CommissionEmployee(int empID, Name empName, MyDate birthDate) {
        this(empID, empName, birthDate, new MyDate(), 0.0);
    }
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, double totalSale) {
        this(empID, empName, birthDate, new MyDate(), totalSale);
    }
    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double value) {
        if (value < 0) {
            System.out.println("Invalid total sale. Value must not be negative.");
            totalSale = 0.0;
        } else totalSale = value;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        if (totalSale < 100000) return 0.10;
        if (totalSale < 500000) return 0.15;
        return 0.20;
    }

    @Override
    public double computeSalary() { return totalSale * getCommissionRate(); }
    @Override
    public double computeSalary(int currentMonth) { return computeSalary() + birthdayBonus(currentMonth); }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%,.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%,.2f, "
                        + "Rate: %.0f%%, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalSale, getCommissionRate() * 100, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CommissionEmployee) || !super.equals(obj)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalSale); }
    @Override
    public CommissionEmployee clone() { return (CommissionEmployee) super.clone(); }
}
