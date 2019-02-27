package emailapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmailApp {

    public static void main(String[] args) {
        showDetails();
    }

    public static void showDetails() {
        Scanner in = new Scanner(System.in);
        System.out.println("Insert your name: ");
        String str = in.nextLine();
        try {
            String[] name = str.split("\\s");
            String firstName = name[0];
            String lastName = name[1];
            Email eml = new Email(firstName, lastName);
            in.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No lastname provided!");
        }
    }
}
