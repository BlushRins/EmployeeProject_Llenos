package version3;

public class Main {

    private static final String LINE =
            "======================================================================";

    public static void main(String[] args) {

        HourlyEmployee hourly = new HourlyEmployee(101,
                new Name("Carlos", "Miguel", "Reyes"),
                new MyDate(14, 10, 2001), new MyDate(15, 7, 2022), 46.0f, 210.00);

        PieceWorkerEmployee piece = new PieceWorkerEmployee(201,
                new Name("Bryan", "Castro", "Jones", "Jr."),
                new MyDate(25, 1, 1996), new MyDate(11, 11, 2020), 260, 16.00);

        CommissionEmployee comm = new CommissionEmployee(301,
                new Name("Elena", "Rose", "Marquez"),
                new MyDate(21, 3, 1997), new MyDate(10, 1, 2020), 85000.00);

        BasePlusCommissionEmployee base = new BasePlusCommissionEmployee(401,
                new Name("Henry", "Jose", "Tan"),
                new MyDate(12, 12, 1995), new MyDate(1, 8, 2019), 120000.00, 18500.00);

        // 1. Polymorphic Collection & Payroll Processing
        Employee[] employees = {hourly, piece, comm, base};
        int targetMonth = 10;

        System.out.println(LINE);
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: " + MyDate.getMonthName(targetMonth) + ")");
        System.out.println(LINE);

        for (int i = 0; i < employees.length; i++) {
            Employee emp = employees[i];
            double basePay = emp.computeSalary();
            double totalPayout = emp.computeSalary(targetMonth);
            double bonus = totalPayout - basePay;

            System.out.printf("%d. %s [ID: %d, Name: %s, DOB: %s, Hired: %s]%n",
                    i + 1, emp.getClass().getSimpleName(),
                    emp.getEmpID(), emp.getEmpName(), emp.getBirthDate(), emp.getDateHired());
            System.out.printf(" Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n",
                    basePay, bonus, bonus > 0 ? "Eligible" : "Ineligible");
            System.out.printf(" Total Payout: ₱%,.2f%n", totalPayout);
            System.out.println();
        }

        // 3. Equivalence & Hash Code Verification
        HourlyEmployee emp1 = hourly;
        HourlyEmployee emp1Identical = new HourlyEmployee(101,
                new Name("Carlos", "Miguel", "Reyes"),
                new MyDate(14, 10, 2001), new MyDate(15, 7, 2022), 46.0f, 210.00);
        HourlyEmployee emp2 = new HourlyEmployee(101,
                new Name("Carlos", "Miguel", "Reyes"),
                new MyDate(14, 10, 2001), new MyDate(15, 7, 2022), 40.0f, 210.00);

        System.out.println(LINE);
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println(LINE);
        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode()
                + " | emp1Identical hashCode: " + emp1Identical.hashCode()
                + " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));
        System.out.println();

        // 2. Deep Copy Verification
        HourlyEmployee empOriginal = hourly;
        HourlyEmployee empClone = empOriginal.clone();

        System.out.println(LINE);
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println(LINE);
        System.out.println("Original Name before modification: " + empOriginal.getEmpName());

        empClone.getEmpName().setLastName("Garcia");
        System.out.println("Clone Name changed to:         " + empClone.getEmpName());

        boolean unaffected = empOriginal.getEmpName().getLastName().equals("Reyes");
        System.out.println("Original Name after modification: " + empOriginal.getEmpName()
                + (unaffected ? " (Deep copy successful!)" : " (Shallow copy - original was changed!)"));
    }
}
