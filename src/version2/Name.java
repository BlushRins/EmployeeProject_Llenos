package version2;

public class Name {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "N/A";
        this.lastName = "N/A";
        this.suffix = "";
    }

    public Name(String firstName, String lastName) {
        this(firstName, "", lastName, "");
    }

    public Name(String firstName, String middleName, String lastName) {
        this(firstName, middleName, lastName, "");
    }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            this.firstName = "N/A";
        } else {
            this.firstName = firstName.trim();
        }
    }

    public String getMiddleName() {
        return middleName;
    }

    // A middle name is optional, so a blank value is stored as ""
    public void setMiddleName(String middleName) {
        if (middleName == null) {
            this.middleName = "";
        } else {
            this.middleName = middleName.trim();
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            this.lastName = "N/A";
        } else {
            this.lastName = lastName.trim();
        }
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        if (suffix == null) {
            this.suffix = "";
        } else {
            this.suffix = suffix.trim();
        }
    }

    private String getMiddleInitial() {
        if (middleName.isEmpty() || middleName.equals("N/A")) {
            return "";
        }
        return middleName.charAt(0) + ".";
    }

    // Prints "lastName, firstName MI"
    public void displayName() {
        String initial = getMiddleInitial();
        if (initial.isEmpty()) {
            System.out.println(lastName + ", " + firstName);
        } else {
            System.out.println(lastName + ", " + firstName + " " + initial);
        }
    }

    // Returns "lastName, firstName MI [suffix]", e.g. "Smith, Alice M." or "Jones, Bob C. Jr."
    @Override
    public String toString() {
        if (firstName.equals("N/A") && lastName.equals("N/A")) {
            return "N/A";
        }

        String full = lastName + ", " + firstName;
        String initial = getMiddleInitial();

        if (!initial.isEmpty()) {
            full = full + " " + initial;
        }
        if (!suffix.isEmpty()) {
            full = full + " " + suffix;
        }
        return full;
    }
}
