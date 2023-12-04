class Name {
    private String firstName;
    private String middleName;
    private String lastName;
    private String compName;

    public Name(String firstName, String middleName, String lastName, String compName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.compName = compName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getCompName() {
        return compName;
    }
    public void setCompName(String compName) {
        this.compName = compName;
    }
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        if (!middleName.isEmpty()) {
            return firstName + " " + middleName + " " + lastName;
        } else {
            return firstName + " " + lastName;
        }
    }

    @Override
    public String toString() {
        return getFullName();
    }
}