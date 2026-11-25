# EmployeeProject_Llenos

Java exercises that evolve from separate payroll classes in version 1 to a shared employee hierarchy in version 3.

From the repository root, with a JDK installed:

```sh
javac -encoding UTF-8 -d out src/version*/*.java
java -cp out version3.Main
```

Version 3 demonstrates overtime, piecework bonuses, tiered commission, base pay plus commission, and a ₱5,000 birthday-month incentive. Changing the month or year of a date clamps its day to the last valid day when needed.

Run the payroll regression checks with the JDK:

```sh
javac -encoding UTF-8 -d out src/version*/*.java test/PayrollTest.java
java -ea -cp out PayrollTest
```
