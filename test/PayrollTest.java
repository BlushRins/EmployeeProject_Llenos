import version3.CommissionEmployee;
import version3.Employee;
import version3.HourlyEmployee;
import version3.MyDate;
import version3.Name;

public final class PayrollTest {
    public static void main(String[] args) {
        MyDate birth = new MyDate(29, 2, 2000);
        Name name = new Name("Alice", "", "Smith", "Jr.");
        Employee worker = new HourlyEmployee();
        worker.setEmpName(name);
        worker.setBirthDate(birth);
        name.setFirstName("Changed");
        birth.setYear(2001);
        worker.getBirthDate().setMonth(1);
        assert worker.getBirthDate().getDay() == 29 && birth.getDay() == 28;
        assert worker.getEmpName().toString().equals("Smith, Alice Jr.");
        assert worker.clone().equals(worker);
        assert worker.clone().hashCode() == worker.hashCode();
        assert worker.computeSalary(2) - worker.computeSalary(1) == Employee.BIRTHDAY_INCENTIVE;

        version2.MyDate earlierVersion = new version2.MyDate(31, 3, 2024);
        earlierVersion.setMonth(4);
        assert earlierVersion.getDay() == 30;

        CommissionEmployee sales = new CommissionEmployee();
        double[] thresholds = {49_999, 50_000, 100_000, 500_000};
        double[] rates = {0.05, 0.10, 0.15, 0.20};
        for (int i = 0; i < thresholds.length; i++) {
            sales.setTotalSale(thresholds[i]);
            assert sales.getCommissionRate() == rates[i];
        }
    }
}
