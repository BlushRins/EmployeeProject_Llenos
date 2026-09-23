package version2;

public class HourlyEmployee {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
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

    // Regular earnings without the birthday incentive
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
    public double computeSalary(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return computeSalary() + BIRTHDAY_INCENTIVE;
        }
        return computeSalary();
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Hours: %.2f | Rate: ₱%,.2f/hr%n",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Hours: %.2f, Rate: ₱%,.2f, "
                        + "Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalHoursWorked, ratePerHour, computeSalary());
    }
}
