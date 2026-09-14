package version2;

public class CommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, double totalSale) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
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

    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Birthdate: %s | Total Sales: PHP%,.2f%n",
                empID, empName, birthDate, totalSale);
    }

    @Override
    public String toString() {
        return String.format(
                "CommissionEmployee [ID: %d, Name: %s, Birthdate: %s, Sales: PHP%,.2f, "
                        + "Rate: %.0f%%, Total Salary: PHP%,.2f]",
                empID, empName, birthDate, totalSale, getCommissionRate() * 100, computeSalary());
    }
}
