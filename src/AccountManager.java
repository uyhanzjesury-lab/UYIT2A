import java.util.ArrayList;

public class AccountManager {

    // Stores all accounts temporarily while the program is running
    static ArrayList<Account> accounts = new ArrayList<>();


    // Account class
    static class Account {

        String fullName;
        String username;
        String password;
        String role;
        String status;

        // Constructor
        Account(String fullName, String username, String password, String role) {

            this.fullName = fullName;
            this.username = username;
            this.password = password;
            this.role = role;

            // New accounts are inactive by default
            this.status = "Inactive";
        }
    }


    // Creates the default administrator account
    public static void createDefaultAdmin() {

        if (accounts.size() == 0) {

            Account admin = new Account(
                    "System Administrator",
                    "admin",
                    "admin123",
                    "Administrator"
            );

            // Administrator is active by default
            admin.status = "Active";

            accounts.add(admin);
        }
    }


    // Create a new account
    public static boolean createAccount(
            String fullName,
            String username,
            String password,
            String role) {

        // Check if username already exists
        for (Account account : accounts) {

            if (account.username.equalsIgnoreCase(username)) {
                return false;
            }
        }

        Account newAccount = new Account(
                fullName,
                username,
                password,
                role
        );

        accounts.add(newAccount);

        return true;
    }


    // Find account using username and password
    public static Account login(String username, String password) {

        for (Account account : accounts) {

            if (account.username.equals(username)
                    && account.password.equals(password)) {

                return account;
            }
        }

        return null;
    }


    // Find account using username
    public static Account findAccount(String username) {

        for (Account account : accounts) {

            if (account.username.equalsIgnoreCase(username)) {
                return account;
            }
        }

        return null;
    }


    // Display all accounts
    public static void viewAccounts() {

        System.out.println("\n======================================");
        System.out.println("          USER ACCOUNTS");
        System.out.println("======================================");

        if (accounts.size() == 0) {

            System.out.println("No accounts found.");
            return;
        }

        for (Account account : accounts) {

            System.out.println("--------------------------------------");
            System.out.println("Name     : " + account.fullName);
            System.out.println("Username : " + account.username);
            System.out.println("Role     : " + account.role);
            System.out.println("Status   : " + account.status);
        }

        System.out.println("--------------------------------------");
    }


    // Change account status
    public static boolean changeStatus(String username, String newStatus) {

        Account account = findAccount(username);

        if (account == null) {
            return false;
        }

        account.status = newStatus;

        return true;
    }
}