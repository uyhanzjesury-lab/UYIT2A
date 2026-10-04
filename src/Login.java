import java.util.Scanner;

public class Login {

    Scanner scanner = new Scanner(System.in);


    // Login function
    public AccountManager.Account loginUser() {

        System.out.println("\n======================================");
        System.out.println("              LOGIN");
        System.out.println("======================================");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();


        // Find account
        AccountManager.Account account =
                AccountManager.login(username, password);


        // Username or password is incorrect
        if (account == null) {

            System.out.println("\nInvalid username or password.");
            return null;
        }


        // Check account status
        if (account.status.equals("Inactive")) {

            System.out.println("\nYour account is INACTIVE.");
            System.out.println("Please wait for the Administrator");
            System.out.println("to activate your account.");

            return null;
        }


        // Login successful
        System.out.println("\nLogin successful!");
        System.out.println("Welcome, " + account.fullName + "!");

        return account;
    }


    // Create account
    public void createAccount() {

        System.out.println("\n======================================");
        System.out.println("           CREATE ACCOUNT");
        System.out.println("======================================");

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();


        System.out.println("\nSelect User Role:");
        System.out.println("1. Nurse/Clinic Staff");
        System.out.println("2. Student");

        System.out.print("Choose: ");
        String roleChoice = scanner.nextLine();


        String role;


        if (roleChoice.equals("1")) {

            role = "Nurse/Clinic Staff";

        } else if (roleChoice.equals("2")) {

            role = "Student";

        } else {

            System.out.println("Invalid role.");
            return;
        }


        // Create the account
        boolean created = AccountManager.createAccount(
                fullName,
                username,
                password,
                role
        );


        if (created) {

            System.out.println("\nAccount created successfully!");
            System.out.println("Role   : " + role);
            System.out.println("Status : Inactive");
            System.out.println("\nThe Administrator must activate");
            System.out.println("your account before you can login.");

        } else {

            System.out.println("\nUsername already exists.");
            System.out.println("Please choose another username.");
        }
    }
}