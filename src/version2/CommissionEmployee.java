package version2;

public class CommissionEmployee {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                              double totalSale) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        if (empName == null) {
            this.empName = new Name();
        } else {
            this.empName = empName;
        }
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) {
            this.birthDate = new MyDate();
        } else {
            this.birthDate = birthDate;
        }
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) {
            this.dateHired = new MyDate();
        } else {
            this.dateHired = dateHired;
        }
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

    // Regular earnings without the birthday incentive
    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    // Adds the birthday incentive when the payroll month is the employee's birth month
    public double computeSalary(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return computeSalary() + BIRTHDAY_INCENTIVE;
        }
        return computeSalary();
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%,.2f%n",
                empID, empName, birthDate, dateHired, totalSale);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%,.2f, Rate: %.0f%%, "
                        + "Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalSale, getCommissionRate() * 100, computeSalary());
    }
}
