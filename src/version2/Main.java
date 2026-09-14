package version2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hourly Employee Test");

        HourlyEmployee hourly1 = new HourlyEmployee(101,
                new Name("Alice", "Grace", "Smith"),
                new MyDate(14, 3, 1998));
        hourly1.setTotalHoursWorked(45.0f);
        hourly1.setRatePerHour(200.00);

        HourlyEmployee hourly2 = new HourlyEmployee(102,
                new Name("Carlos", "Miguel", "Reyes"),
                new MyDate(2, 11, 1995), 38.5f, 150.00);

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.println();
        System.out.println("Piece Worker Employee Test");

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201,
                new Name("Bob", "Allan", "Jones"),
                new MyDate(29, 2, 2000));
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15.00);

        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202,
                new Name("Dana", "Marie", "Cruz"),
                new MyDate(7, 7, 1993), 80, 25.00);

        System.out.println("[displayPieceWorkerEmployee()]");
        piece1.displayPieceWorkerEmployee();
        piece2.displayPieceWorkerEmployee();

        System.out.println("[toString()]");
        System.out.println(piece1);
        System.out.println(piece2);

        System.out.println();
        System.out.println("Commission Employee Test");

        CommissionEmployee comm1 = new CommissionEmployee();
        comm1.setEmpID(301);
        comm1.setEmpName(new Name("Elena", "Rose", "Marquez"));
        comm1.setBirthDate(new MyDate(21, 9, 1990));
        comm1.setTotalSale(45000.00);

        CommissionEmployee comm2 = new CommissionEmployee(302,
                new Name("Frank", "Tan", "Lim"),
                new MyDate(5, 1, 1988), 520000.00);

        System.out.println("[displayCommissionEmployee()]");
        comm1.displayCommissionEmployee();
        comm2.displayCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(comm1);
        System.out.println(comm2);

        System.out.println();
        System.out.println("Base Plus Commission Employee Test");

        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee(401,
                new Name("Grace", "Ann", "Uy"),
                new MyDate(30, 6, 1992));
        base1.setTotalSale(120000.00);
        base1.setBaseSalary(18000.00);

        BasePlusCommissionEmployee base2 = new BasePlusCommissionEmployee(402,
                new Name("Henry", "Jose", "Tan"),
                new MyDate(12, 12, 1985), 75000.00, 20000.00);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(base1);
        System.out.println(base2);

        System.out.println();
        System.out.println("Name and MyDate Test");

        Name n1 = new Name("Juan", "", "Dela Cruz");
        Name n2 = new Name(null, null, null);

        n1.display();
        n2.display();

        MyDate d1 = new MyDate(25, 12, 2001);
        d1.display();

        System.out.println("[validation checks]");
        MyDate bad = new MyDate(31, 2, 2001);
        System.out.println("Rejected Feb 31 -> " + bad);
    }
}
