package version2;

public class PieceWorkerEmployee {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            System.out.println("Invalid piece count. Value must not be negative.");
            this.totalPiecesFinished = 0;
        } else {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            System.out.println("Invalid rate per piece. Value must not be negative.");
            this.ratePerPiece = 0;
        } else {
            this.ratePerPiece = ratePerPiece;
        }
    }

    // Regular earnings without the birthday incentive
    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusBlocks = totalPiecesFinished / 100;
        double bonusPay = bonusBlocks * (10 * ratePerPiece);
        return basePay + bonusPay;
    }

    // Adds the birthday incentive when the payroll month is the employee's birth month
    public double computeSalary(int currentMonth) {
        if (birthDate.getMonth() == currentMonth) {
            return computeSalary() + BIRTHDAY_INCENTIVE;
        }
        return computeSalary();
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: ₱%,.2f%n",
                empID, empName, birthDate, dateHired, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%,.2f, "
                        + "Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
