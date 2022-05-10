package controller;

public class StudentInfo {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String department;

    public StudentInfo(String firstName, String lastName, String email, String phoneNumber, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDepartment() {
        return department;
    }


}
