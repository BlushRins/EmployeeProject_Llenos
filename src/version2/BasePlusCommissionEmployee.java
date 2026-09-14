package version2;

public class BasePlusCommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        this.totalSale = 0;
        this.baseSalary = 0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate,
                                      double totalSale, double baseSalary) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
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

    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Birthdate: %s | Total Sales: PHP%,.2f | Base Salary: PHP%,.2f%n",
                empID, empName, birthDate, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        return String.format(
                "BasePlusCommissionEmployee [ID: %d, Name: %s, Birthdate: %s, Base Salary: PHP%,.2f, "
                        + "Sales: PHP%,.2f, Rate: %.0f%%, Total Salary: PHP%,.2f]",
                empID, empName, birthDate, baseSalary, totalSale, getCommissionRate() * 100, computeSalary());
    }
}
