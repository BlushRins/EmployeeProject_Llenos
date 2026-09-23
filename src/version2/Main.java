package version2;

public class Main {

    public static void main(String[] args) {

        // 1. Composition Verification
        System.out.println("--- Name & Date Output Verification ---");

        Name sampleName = new Name("Carlos", "Miguel", "Reyes");
        MyDate sampleDate = new MyDate(14, 10, 2026);

        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();

        // 2 & 3. Employee Instantiation + Payroll & Birthday Incentive Test
        System.out.println();
        System.out.println("--- Hourly Employee Payroll Test ---");

        HourlyEmployee hourly1 = new HourlyEmployee(101, sampleName,
                new MyDate(14, 10, 2001), new MyDate(15, 7, 2022));
        hourly1.setTotalHoursWorked(46.0f);
        hourly1.setRatePerHour(210.00);

        HourlyEmployee hourly2 = new HourlyEmployee(102,
                new Name("Andrea", "Luz", "Santos"),
                new MyDate(3, 5, 1998), new MyDate(20, 2, 2023), 38.5f, 185.00);

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.println();
        System.out.println("[Birthday Incentive Check]");
        printBirthdayCheck(hourly1.getEmpName(), hourly1.getBirthDate(),
                hourly1.computeSalary(nextMonth(hourly1.getBirthDate())),
                hourly1.computeSalary(hourly1.getBirthDate().getMonth()));
        printBirthdayCheck(hourly2.getEmpName(), hourly2.getBirthDate(),
                hourly2.computeSalary(nextMonth(hourly2.getBirthDate())),
                hourly2.computeSalary(hourly2.getBirthDate().getMonth()));

        System.out.println();
        System.out.println("--- Piece Worker Employee Payroll Test ---");

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201,
                new Name("Dana", "Marie", "Cruz"),
                new MyDate(7, 7, 1999), new MyDate(3, 2, 2021));
        piece1.setTotalPiecesFinished(260);
        piece1.setRatePerPiece(16.00);

        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202,
                new Name("Bryan", "Castro", "Jones", "Jr."),
                new MyDate(25, 1, 1996), new MyDate(11, 11, 2020), 85, 22.00);

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);

        System.out.println();
        System.out.println("[Birthday Incentive Check]");
        printBirthdayCheck(piece1.getEmpName(), piece1.getBirthDate(),
                piece1.computeSalary(nextMonth(piece1.getBirthDate())),
                piece1.computeSalary(piece1.getBirthDate().getMonth()));
        printBirthdayCheck(piece2.getEmpName(), piece2.getBirthDate(),
                piece2.computeSalary(nextMonth(piece2.getBirthDate())),
                piece2.computeSalary(piece2.getBirthDate().getMonth()));

        System.out.println();
        System.out.println("--- Commission Employee Payroll Test ---");

        CommissionEmployee comm1 = new CommissionEmployee();
        comm1.setEmpID(301);
        comm1.setEmpName(new Name("Elena", "Rose", "Marquez"));
        comm1.setBirthDate(new MyDate(21, 3, 1997));
        comm1.setDateHired(new MyDate(10, 1, 2020));
        comm1.setTotalSale(85000.00);

        CommissionEmployee comm2 = new CommissionEmployee(302,
                new Name("Frank", "Tan", "Lim"),
                new MyDate(5, 6, 1990), new MyDate(18, 9, 2018), 520000.00);

        System.out.println("[displayCommissionEmployee()]");
        comm1.displayCommissionEmployee();
        comm2.displayCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(comm1);
        System.out.println(comm2);

        System.out.println();
        System.out.println("[Birthday Incentive Check]");
        printBirthdayCheck(comm1.getEmpName(), comm1.getBirthDate(),
                comm1.computeSalary(nextMonth(comm1.getBirthDate())),
                comm1.computeSalary(comm1.getBirthDate().getMonth()));
        printBirthdayCheck(comm2.getEmpName(), comm2.getBirthDate(),
                comm2.computeSalary(nextMonth(comm2.getBirthDate())),
                comm2.computeSalary(comm2.getBirthDate().getMonth()));

        System.out.println();
        System.out.println("--- Base Plus Commission Employee Payroll Test ---");

        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee(401,
                new Name("Henry", "Jose", "Tan"),
                new MyDate(12, 12, 1995), new MyDate(1, 8, 2019));
        base1.setTotalSale(120000.00);
        base1.setBaseSalary(18500.00);

        BasePlusCommissionEmployee base2 = new BasePlusCommissionEmployee(402,
                new Name("Grace", "Ann", "Uy"),
                new MyDate(30, 4, 1992), new MyDate(6, 3, 2017), 75000.00, 20000.00);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();

        System.out.println();
        System.out.println("[toString()]");
        System.out.println(base1);
        System.out.println(base2);

        System.out.println();
        System.out.println("[Birthday Incentive Check]");
        printBirthdayCheck(base1.getEmpName(), base1.getBirthDate(),
                base1.computeSalary(nextMonth(base1.getBirthDate())),
                base1.computeSalary(base1.getBirthDate().getMonth()));
        printBirthdayCheck(base2.getEmpName(), base2.getBirthDate(),
                base2.computeSalary(nextMonth(base2.getBirthDate())),
                base2.computeSalary(base2.getBirthDate().getMonth()));
    }

    // A month that is guaranteed not to be the birth month (the month after it)
    private static int nextMonth(MyDate birthDate) {
        return birthDate.getMonth() % 12 + 1;
    }

    private static void printBirthdayCheck(Name name, MyDate birthDate,
                                           double regularSalary, double birthMonthSalary) {
        System.out.println(name);
        System.out.printf("Regular Month (%s) Salary: ₱%,.2f%n",
                MyDate.getMonthName(nextMonth(birthDate)), regularSalary);
        System.out.printf("Birth Month (%s) Salary (+₱%,.2f): ₱%,.2f%n",
                MyDate.getMonthName(birthDate.getMonth()), birthMonthSalary - regularSalary,
                birthMonthSalary);
    }
}
