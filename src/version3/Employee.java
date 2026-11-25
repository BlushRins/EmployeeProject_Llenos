package version3;

import java.util.Objects;

public abstract class Employee implements Cloneable {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName.clone();
    }

    public void setEmpName(Name empName) {
        if (empName == null) {
            this.empName = new Name();
        } else {
            this.empName = empName.clone();
        }
    }

    public MyDate getBirthDate() {
        return birthDate.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) {
            this.birthDate = new MyDate();
        } else {
            this.birthDate = birthDate.clone();
        }
    }

    public MyDate getDateHired() {
        return dateHired.clone();
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) {
            this.dateHired = new MyDate();
        } else {
            this.dateHired = dateHired.clone();
        }
    }

    // Common birthday incentive.
    // Subclasses add their own pay on top of super.computeSalary(currentMonth).
    public double computeSalary(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return BIRTHDAY_INCENTIVE;
        }
        return 0;
    }

    // Regular earnings without the birthday incentive (-1 never matches a month)
    public double computeSalary() {
        return computeSalary(-1);
    }

    public abstract void displayEmployee();

    protected void displayIdentity() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("Employee [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return empID == other.empID
                && empName.equals(other.empName)
                && birthDate.equals(other.birthDate)
                && dateHired.equals(other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    // Deep copy: the Name and MyDate objects are cloned too, so changing the
    // clone's name or dates does not affect the original
    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = empName.clone();
            copy.birthDate = birthDate.clone();
            copy.dateHired = dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
