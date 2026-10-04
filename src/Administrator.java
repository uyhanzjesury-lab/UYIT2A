import java.util.Scanner;

public class Administrator {

    Scanner scanner = new Scanner(System.in);


    // Main administrator menu
    public void administratorMenu() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("        ADMINISTRATOR MENU");
            System.out.println("======================================");

            System.out.println("1. Manage User Accounts");
            System.out.println("2. Manage Student Records");
            System.out.println("3. Manage Medicine Records");
            System.out.println("4. View Clinic Records");
            System.out.println("5. Generate Reports");
            System.out.println("6. View System Activity Logs");
            System.out.println("7. Logout");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();


            if (choice.equals("1")) {

                manageUserAccounts();

            } else if (choice.equals("2")) {

                manageStudentRecords();

            } else if (choice.equals("3")) {

                manageMedicineRecords();

            } else if (choice.equals("4")) {

                viewClinicRecords();

            } else if (choice.equals("5")) {

                generateReports();

            } else if (choice.equals("6")) {

                viewActivityLogs();

            } else if (choice.equals("7")) {

                System.out.println("\nLogging out...");
                break;

            } else {

                System.out.println("\nInvalid choice.");
            }
        }
    }


    // Manage accounts
    public void manageUserAccounts() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       MANAGE USER ACCOUNTS");
            System.out.println("======================================");

            System.out.println("1. View Users");
            System.out.println("2. Activate User");
            System.out.println("3. Deactivate User");
            System.out.println("4. Back");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();


            if (choice.equals("1")) {

                AccountManager.viewAccounts();

            } else if (choice.equals("2")) {

                activateUser();

            } else if (choice.equals("3")) {

                deactivateUser();

            } else if (choice.equals("4")) {

                break;

            } else {

                System.out.println("Invalid choice.");
            }
        }
    }


    // Activate user
    public void activateUser() {

        System.out.println("\n=== ACTIVATE USER ===");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        AccountManager.Account account =
                AccountManager.findAccount(username);


        if (account == null) {

            System.out.println("User not found.");
            return;
        }


        if (account.role.equals("Administrator")) {

            System.out.println("Administrator account cannot be changed here.");
            return;
        }


        account.status = "Active";

        System.out.println("\nUser activated successfully!");
        System.out.println("Username : " + account.username);
        System.out.println("Role     : " + account.role);
        System.out.println("Status   : " + account.status);
    }


    // Deactivate user
    public void deactivateUser() {

        System.out.println("\n=== DEACTIVATE USER ===");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        AccountManager.Account account =
                AccountManager.findAccount(username);


        if (account == null) {

            System.out.println("User not found.");
            return;
        }


        if (account.role.equals("Administrator")) {

            System.out.println("Administrator account cannot be deactivated.");
            return;
        }


        account.status = "Inactive";

        System.out.println("\nUser deactivated successfully!");
        System.out.println("Username : " + account.username);
        System.out.println("Role     : " + account.role);
        System.out.println("Status   : " + account.status);
    }


    public void manageStudentRecords() {

        System.out.println("\n=== MANAGE STUDENT RECORDS ===");
        System.out.println("1. Create Student");
        System.out.println("2. View Students");
        System.out.println("3. Update Student");
        System.out.println("4. Delete Student");
    }


    public void manageMedicineRecords() {

        System.out.println("\n=== MANAGE MEDICINE RECORDS ===");
        System.out.println("1. Create Medicine");
        System.out.println("2. View Medicines");
        System.out.println("3. Update Medicine");
        System.out.println("4. Delete Medicine");
    }


    public void viewClinicRecords() {

        System.out.println("\n=== CLINIC RECORDS ===");
        System.out.println("View student clinic records");
        System.out.println("View previous clinic visits");
    }


    public void generateReports() {

        System.out.println("\n=== SCHOOL CLINIC HEALTH SUMMARY REPORT ===");

        System.out.println("Total clinic visits");
        System.out.println("Number of students who visited");
        System.out.println("Common reasons for clinic visits");
        System.out.println("Medicines used");
        System.out.println("Low-stock medicines");
    }


    public void viewActivityLogs() {

        System.out.println("\n=== SYSTEM ACTIVITY LOG ===");

        System.out.println("User login/logout");
        System.out.println("Record creation");
        System.out.println("Record updates");
        System.out.println("Record deletion/deactivation");
        System.out.println("Clinic visit entries");
        System.out.println("Medicine inventory changes");
    }
}