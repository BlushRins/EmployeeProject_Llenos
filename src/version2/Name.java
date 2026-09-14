package version2;

public class Name {

    private String firstname;
    private String middleN;
    private String lastname;

    public Name() {
        this("", "", "");
    }

    public Name(String firstname, String middleN, String lastname) {
        setFirstname(firstname);
        setMiddleN(middleN);
        setLastname(lastname);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = clean(firstname);
    }

    public String getMiddleN() {
        return middleN;
    }

    public void setMiddleN(String middleN) {
        this.middleN = clean(middleN);
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = clean(lastname);
    }

    private String clean(String value) {
        if (value == null) {
            return "";
        }
        return value.trim();
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (firstname.isEmpty() && middleN.isEmpty() && lastname.isEmpty()) {
            return "N/A";
        }

        String full = lastname;

        if (!firstname.isEmpty()) {
            full = full.isEmpty() ? firstname : full + ", " + firstname;
        }
        if (!middleN.isEmpty()) {
            full = full.isEmpty() ? middleN : full + " " + middleN;
        }
        return full;
    }
}
