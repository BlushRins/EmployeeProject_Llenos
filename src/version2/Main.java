package version2;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hourly Employee Test");

        HourlyEmployee hourly1 = new HourlyEmployee(101, "Alice Smith");
        hourly1.setTotalHoursWorked(45.0f);
        hourly1.setRatePerHour(200.00);

        HourlyEmployee hourly2 = new HourlyEmployee(102, "Carlos Reyes", 38.5f, 150.00);

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        hourly2.displayHourlyEmployee();

        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println(hourly2);

        System.out.println();
        System.out.println("Piece Worker Employee Test");

        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201, "Bob Jones");
        piece1.setTotalPiecesFinished(250);
        piece1.setRatePerPiece(15.00);

        PieceWorkerEmployee piece2 = new PieceWorkerEmployee(202, "Dana Cruz", 80, 25.00);

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
        comm1.setEmpName("Elena Marquez");
        comm1.setTotalSale(45000.00);

        CommissionEmployee comm2 = new CommissionEmployee(302, "Frank Lim", 520000.00);

        System.out.println("[displayCommissionEmployee()]");
        comm1.displayCommissionEmployee();
        comm2.displayCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(comm1);
        System.out.println(comm2);

        System.out.println();
        System.out.println("Base Plus Commission Employee Test");

        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee(401, "Grace Uy");
        base1.setTotalSale(120000.00);
        base1.setBaseSalary(18000.00);

        BasePlusCommissionEmployee base2 =
                new BasePlusCommissionEmployee(402, "Henry Tan", 75000.00, 20000.00);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        base1.displayBasePlusCommissionEmployee();
        base2.displayBasePlusCommissionEmployee();

        System.out.println("[toString()]");
        System.out.println(base1);
        System.out.println(base2);
    }
}
