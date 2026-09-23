package version1;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Name & Date Output Verification ---");

        String sampleName = "Reyes, Carlos M.";
        LocalDate sampleDate = LocalDate.of(2026, 10, 14);

        System.out.println("Name: " + sampleName);
        System.out.println("Date: " + sampleDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)));

        System.out.println();
        System.out.println("--- Hourly Employee Payroll Test ---");

        HourlyEmployee hourly = new HourlyEmployee(101, sampleName,
                LocalDate.of(2001, 10, 14), LocalDate.of(2022, 7, 15));
        hourly.setTotalHoursWorked(46.0f);
        hourly.setRatePerHour(210.00);

        System.out.println("[displayHourlyEmployee()]");
        hourly.displayHourlyEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly);

        int birthMonth = hourly.getBirthDate().getMonthValue();
        int regularMonth = birthMonth % 12 + 1;
        printBirthdayIncentive(birthMonth, regularMonth,
                hourly.computeSalary(regularMonth), hourly.computeSalary(birthMonth),
                HourlyEmployee.BIRTHDAY_INCENTIVE);

        System.out.println();
        System.out.println("--- Piece Worker Employee Payroll Test ---");

        PieceWorkerEmployee piece = new PieceWorkerEmployee(201,
                "Cruz, Dana M.",
                LocalDate.of(1999, 7, 7), LocalDate.of(2021, 2, 3), 260, 16.00);

        System.out.println("[displayPieceWorkerEmployee()]");
        piece.displayPieceWorkerEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(piece);

        birthMonth = piece.getBirthDate().getMonthValue();
        regularMonth = birthMonth % 12 + 1;
        printBirthdayIncentive(birthMonth, regularMonth,
                piece.computeSalary(regularMonth), piece.computeSalary(birthMonth),
                PieceWorkerEmployee.BIRTHDAY_INCENTIVE);

        System.out.println();
        System.out.println("--- Commission Employee Payroll Test ---");

        CommissionEmployee comm = new CommissionEmployee();
        comm.setEmpID(301);
        comm.setEmpName("Marquez, Elena R.");
        comm.setBirthDate(LocalDate.of(1997, 3, 21));
        comm.setDateHired(LocalDate.of(2020, 1, 10));
        comm.setTotalSale(85000.00);

        System.out.println("[displayCommissionEmployee()]");
        comm.displayCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(comm);

        birthMonth = comm.getBirthDate().getMonthValue();
        regularMonth = birthMonth % 12 + 1;
        printBirthdayIncentive(birthMonth, regularMonth,
                comm.computeSalary(regularMonth), comm.computeSalary(birthMonth),
                CommissionEmployee.BIRTHDAY_INCENTIVE);

        System.out.println();
        System.out.println("--- Base Plus Commission Employee Payroll Test ---");

        BasePlusCommissionEmployee base = new BasePlusCommissionEmployee(401,
                "Tan, Henry J.",
                LocalDate.of(1995, 12, 12), LocalDate.of(2019, 8, 1));
        base.setTotalSale(120000.00);
        base.setBaseSalary(18500.00);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        base.displayBasePlusCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(base);

        birthMonth = base.getBirthDate().getMonthValue();
        regularMonth = birthMonth % 12 + 1;
        printBirthdayIncentive(birthMonth, regularMonth,
                base.computeSalary(regularMonth), base.computeSalary(birthMonth),
                BasePlusCommissionEmployee.BIRTHDAY_INCENTIVE);
    }

    private static void printBirthdayIncentive(int birthMonth, int regularMonth,
                                               double regularSalary, double birthMonthSalary,
                                               double incentive) {
        System.out.println();
        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (%s) Salary: ₱%,.2f%n",
                monthName(regularMonth), regularSalary);
        System.out.printf("Birth Month (%s) Salary (+₱%,.2f): ₱%,.2f%n",
                monthName(birthMonth), incentive, birthMonthSalary);
    }

    private static String monthName(int month) {
        return Month.of(month).getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }
}
