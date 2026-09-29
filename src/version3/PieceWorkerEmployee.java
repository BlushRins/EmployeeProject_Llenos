package version3;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() { super(); }
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate) {
        this(empID, empName, birthDate, new MyDate(), 0, 0.0);
    }
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate,
                               int totalPiecesFinished, double ratePerPiece) {
        this(empID, empName, birthDate, new MyDate(), totalPiecesFinished, ratePerPiece);
    }
    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public double getRatePerPiece() { return ratePerPiece; }

    public void setTotalPiecesFinished(int value) {
        if (value < 0) {
            System.out.println("Invalid piece count. Value must not be negative.");
            totalPiecesFinished = 0;
        } else totalPiecesFinished = value;
    }

    public void setRatePerPiece(double value) {
        if (value < 0) {
            System.out.println("Invalid rate per piece. Value must not be negative.");
            ratePerPiece = 0.0;
        } else ratePerPiece = value;
    }

    @Override
    public double computeSalary() {
        double productionPay = totalPiecesFinished * ratePerPiece;
        double hundredPieceBonus = (totalPiecesFinished / 100) * 10 * ratePerPiece;
        return productionPay + hundredPieceBonus;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeSalary() + birthdayBonus(currentMonth);
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Pieces Finished: %d | Rate/Piece: ₱%,.2f%n",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, "
                        + "Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PieceWorkerEmployee) || !super.equals(obj)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece); }
    @Override
    public PieceWorkerEmployee clone() { return (PieceWorkerEmployee) super.clone(); }
}
