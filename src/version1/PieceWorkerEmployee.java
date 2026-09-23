package version1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PieceWorkerEmployee {

    public static final double BIRTHDAY_INCENTIVE = 5000.00;
    private static final DateTimeFormatter DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

    private int empID;
    private String empName;
    private LocalDate birthDate;
    private LocalDate dateHired;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.birthDate = null;
        this.dateHired = null;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, String empName, LocalDate birthDate, LocalDate dateHired) {
        this.empID = empID;
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, String empName, LocalDate birthDate, LocalDate dateHired,
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

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusBlocks = totalPiecesFinished / 100;
        double bonusPay = bonusBlocks * (10 * ratePerPiece);
        return basePay + bonusPay;
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

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: ₱%,.2f%n",
                empID, empName, formatDate(birthDate), formatDate(dateHired), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%,.2f, "
                        + "Total Salary: ₱%,.2f]",
                empID, empName, formatDate(birthDate), formatDate(dateHired), totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
