package version3;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- Name & Date Output Verification ---");
        Name sampleName = new Name("Carlos", "Miguel", "Reyes");
        MyDate sampleDate = new MyDate(14, 9, 2026);
        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();

        HourlyEmployee hourly = new HourlyEmployee(101,
                new Name("Alice", "Grace", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.00);
        PieceWorkerEmployee piece = new PieceWorkerEmployee(201,
                new Name("Bob", "Calvin", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.00);
        CommissionEmployee commission = new CommissionEmployee(301,
                new Name("Elena", "Rose", "Marquez"),
                new MyDate(21, 9, 1990), new MyDate(10, 1, 2020), 85000.00);
        BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(401,
                new Name("Henry", "Jose", "Tan"),
                new MyDate(12, 12, 1985), new MyDate(1, 8, 2019), 120000.00, 18000.00);

        Employee[] employees = {hourly, piece, commission, basePlus};
        int targetMonth = 9;

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: " + MyDate.getMonthName(targetMonth) + ")");
        System.out.println("======================================================================");
        for (int index = 0; index < employees.length; index++) {
            Employee employee = employees[index];
            double regularPay = employee.computeSalary();
            double totalPayout = employee.computeSalary(targetMonth);
            double birthdayBonus = totalPayout - regularPay;
            System.out.printf("%n%d. %s%n", index + 1, employee);
            System.out.printf("   Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n",
                    regularPay, birthdayBonus, birthdayBonus > 0 ? "Eligible" : "Ineligible");
            System.out.printf("   Total Payout: ₱%,.2f%n", totalPayout);
        }

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");
        HourlyEmployee identical = new HourlyEmployee(101,
                new Name("Alice", "Grace", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.00);
        System.out.println("emp1 equals emp1Identical: " + hourly.equals(identical));
        System.out.println("emp1 hashCode: " + hourly.hashCode()
                + " | emp1Identical hashCode: " + identical.hashCode()
                + " (Match: " + (hourly.hashCode() == identical.hashCode()) + ")");
        identical.setRatePerHour(210.00);
        System.out.println("emp1 equals modified instance: " + hourly.equals(identical));

        System.out.println();
        System.out.println("DEEP CLONE VERIFICATION");
        HourlyEmployee clone = hourly.clone();
        System.out.println("Original Name before modification: " + hourly.getEmpName());
        clone.getEmpName().setFirstName("Taylor");
        clone.getBirthDate().setMonth(10);
        System.out.println("Clone Name changed to:              " + clone.getEmpName());
        System.out.println("Original Name after modification:   " + hourly.getEmpName());
        System.out.println("Original Birth Month: " + MyDate.getMonthName(hourly.getBirthDate().getMonth()));
        System.out.println("Clone Birth Month:    " + MyDate.getMonthName(clone.getBirthDate().getMonth()));
        System.out.println("Deep copy successful: "
                + (!hourly.getEmpName().equals(clone.getEmpName())
                && !hourly.getBirthDate().equals(clone.getBirthDate())));

        System.out.println();
        System.out.println("--- Individual Display Methods ---");
        hourly.displayHourlyEmployee();
        piece.displayPieceWorkerEmployee();
        commission.displayCommissionEmployee();
        basePlus.displayBasePlusCommissionEmployee();
    }
}
