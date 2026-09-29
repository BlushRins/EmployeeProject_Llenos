package version3;

import java.util.Locale;
import java.util.Objects;

public class Name implements Cloneable {

    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    public Name() { this("N/A", "", "N/A", ""); }
    public Name(String firstName, String lastName) { this(firstName, "", lastName, ""); }
    public Name(String firstName, String middleName, String lastName) { this(firstName, middleName, lastName, ""); }

    public Name(String firstName, String middleName, String lastName, String suffix) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { firstName = requiredText(value); }
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String value) { middleName = optionalText(value); }
    public String getLastName() { return lastName; }
    public void setLastName(String value) { lastName = requiredText(value); }
    public String getSuffix() { return suffix; }
    public void setSuffix(String value) { suffix = optionalText(value); }

    // Aliases keep the shorter names used by the original version 3 code working.
    public String getFirstname() { return getFirstName(); }
    public void setFirstname(String value) { setFirstName(value); }
    public String getMiddleN() { return getMiddleName(); }
    public void setMiddleN(String value) { setMiddleName(value); }
    public String getLastname() { return getLastName(); }
    public void setLastname(String value) { setLastName(value); }

    private String requiredText(String value) {
        return value == null || value.trim().isEmpty() ? "N/A" : value.trim();
    }

    private String optionalText(String value) { return value == null ? "" : value.trim(); }

    private String middleInitial() {
        return middleName.isEmpty() ? "" : middleName.substring(0, 1) + ".";
    }

    public void displayName() { System.out.println(this); }
    public void display() { displayName(); }

    @Override
    public String toString() {
        if ("N/A".equals(firstName) && "N/A".equals(lastName)) return "N/A";
        String result = lastName + ", " + firstName;
        if (!middleInitial().isEmpty()) result += " " + middleInitial();
        if (!suffix.isEmpty()) result += " " + suffix;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Name)) return false;
        Name other = (Name) obj;
        return firstName.equalsIgnoreCase(other.firstName)
                && middleName.equalsIgnoreCase(other.middleName)
                && lastName.equalsIgnoreCase(other.lastName)
                && suffix.equalsIgnoreCase(other.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(Locale.ROOT), middleName.toLowerCase(Locale.ROOT),
                lastName.toLowerCase(Locale.ROOT), suffix.toLowerCase(Locale.ROOT));
    }

    @Override
    public Name clone() {
        try { return (Name) super.clone(); }
        catch (CloneNotSupportedException exception) { throw new AssertionError(exception); }
    }
}
