package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID, empName, birthDate, dateHired);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
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

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusBlocks = totalPiecesFinished / 100;
        double bonusPay = bonusBlocks * (10 * ratePerPiece);
        return basePay + bonusPay + super.computeSalary(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();
        System.out.printf("Pieces Finished: %d | Rate/Piece: ₱%,.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: ₱%,.2f, "
                        + "Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
