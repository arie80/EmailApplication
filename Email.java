package emailapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "mycompany.com";
    private String email;

    // Constructor to receive firstName and lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method random password
        this.password = randomPassword(defaultPasswordLength);

        setDepartment();

        // Combine element to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + companySuffix;
        System.out.println(showInfo());

    }

    private void setDepartment() {
        System.out.println("New Worker: " + firstName + " " + lastName
                + ", Department codes:\n1 for Sales\n2 for Development \n3 for Accounting \n- Enter any number for default \nEnter department code: ");
        Scanner in = new Scanner(System.in);
        String result = "";
        try {
            int depChoice = in.nextInt();
            if (depChoice == 1)
                result = "Sales";
            else if (depChoice == 2)
                result = "Dev";
            else if (depChoice == 3)
                result = "Acc";
            else
                result = "Work";
            this.department = result;
            in.close();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect code!");
            System.exit(0); // Exit the program
        }
    }

    // Generate random password
    private String randomPassword(int length) {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("EddMMyyyyhhmmss");
        String passwordSet = "abcdefghijklmnopqrstuvexyz" + ft.format(dNow);
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the email capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "YOUR TEMPORARY PASSWORD: " + password + "\nDISPLAY NAME: " + firstName + " " + lastName
                + "\nDEPARTMENT: " + department + "\nCOMPANY EMAIL: " + email + "\nMAILBOX CAPACITY: " + mailboxCapacity
                + "mb";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
