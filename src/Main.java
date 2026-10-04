import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);


    // Student menu
    public static void studentMenu() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("            STUDENT MENU");
            System.out.println("======================================");

            System.out.println("1. View Personal Clinic Records");
            System.out.println("2. View Personal Information");
            System.out.println("3. Submit Clinic Visit/Request");
            System.out.println("4. View Available Clinic Services");
            System.out.println("5. Logout");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();


            if (choice.equals("1")) {

                System.out.println("\n=== MY CLINIC VISIT RECORDS ===");

            } else if (choice.equals("2")) {

                System.out.println("\n=== MY PERSONAL INFORMATION ===");

            } else if (choice.equals("3")) {

                System.out.println("\n=== SUBMIT CLINIC VISIT REQUEST ===");
                System.out.println("Enter reason for visit");
                System.out.println("Enter symptoms");

            } else if (choice.equals("4")) {

                System.out.println("\n=== AVAILABLE CLINIC SERVICES ===");

            } else if (choice.equals("5")) {

                System.out.println("\nLogging out...");
                break;

            } else {

                System.out.println("\nInvalid choice.");
            }
        }
    }


    // Main program
    public static void main(String[] args) {

        // Create default administrator
        AccountManager.createDefaultAdmin();

        Login login = new Login();


        while (true) {

            System.out.println("\n======================================");
            System.out.println("     SCHOOL CLINIC MANAGEMENT");
            System.out.println("======================================");

            System.out.println("1. Login");
            System.out.println("2. Create Account");
            System.out.println("3. Exit");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();


            // LOGIN
            if (choice.equals("1")) {

                AccountManager.Account account =
                        login.loginUser();


                // Login failed
                if (account == null) {
                    continue;
                }


                // Administrator
                if (account.role.equals("Administrator")) {

                    Administrator administrator =
                            new Administrator();

                    administrator.administratorMenu();
                }


                // Nurse / Clinic Staff
                else if (account.role.equals("Nurse/Clinic Staff")) {

                    NurseClinicStaff staff =
                            new NurseClinicStaff();

                    staff.clinicStaffMenu();
                }


                // Student
                else if (account.role.equals("Student")) {

                    studentMenu();
                }
            }


            // CREATE ACCOUNT
            else if (choice.equals("2")) {

                login.createAccount();
            }


            // EXIT
            else if (choice.equals("3")) {

                System.out.println("\nProgram closed.");
                break;
            }


            else {

                System.out.println("\nInvalid choice.");
            }
        }


        scanner.close();
    }
}