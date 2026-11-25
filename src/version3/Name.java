package version3;

import java.util.Objects;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() {
        this.firstName = "N/A";
        this.middleName = "";
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
            if ("N/A".equalsIgnoreCase(this.middleName)) this.middleName = "";
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
        if (middleName.isEmpty()) {
            return "";
        }
        return middleName.charAt(0) + ".";
    }

    public void displayName() {
        System.out.println(this);
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name other = (Name) obj;
        return firstName.equals(other.firstName)
                && middleName.equals(other.middleName)
                && lastName.equals(other.lastName)
                && suffix.equals(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, lastName, suffix);
    }

    // All fields are immutable Strings, so super.clone() is already a full copy
    @Override
    public Name clone() {
        try {
            return (Name) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
