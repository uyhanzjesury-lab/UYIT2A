import java.util.Scanner;

public class NurseClinicStaff {

    Scanner scanner = new Scanner(System.in);


    // Nurse / Clinic Staff menu
    public void clinicStaffMenu() {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("       NURSE / CLINIC STAFF");
            System.out.println("======================================");

            System.out.println("1. Register Clinic Visit");
            System.out.println("2. View Student Information");
            System.out.println("3. Record Symptoms and Treatment");
            System.out.println("4. Manage Medicine Records");
            System.out.println("5. Update Clinic Visit");
            System.out.println("6. View Clinic Reports");
            System.out.println("7. Logout");

            System.out.print("Choose: ");
            String choice = scanner.nextLine();


            if (choice.equals("1")) {

                registerClinicVisit();

            } else if (choice.equals("2")) {

                viewStudentInformation();

            } else if (choice.equals("3")) {

                recordSymptomsAndTreatment();

            } else if (choice.equals("4")) {

                manageMedicineRecords();

            } else if (choice.equals("5")) {

                updateClinicVisit();

            } else if (choice.equals("6")) {

                viewClinicReports();

            } else if (choice.equals("7")) {

                System.out.println("\nLogging out...");
                break;

            } else {

                System.out.println("\nInvalid choice.");
            }
        }
    }


    public void registerClinicVisit() {

        System.out.println("\n=== REGISTER CLINIC VISIT ===");

        System.out.println("Enter student information");
        System.out.println("Enter symptoms");
        System.out.println("Enter diagnosis");
        System.out.println("Enter treatment");
        System.out.println("Enter remarks");
    }


    public void viewStudentInformation() {

        System.out.println("\n=== STUDENT INFORMATION ===");
    }


    public void recordSymptomsAndTreatment() {

        System.out.println("\n=== RECORD SYMPTOMS AND TREATMENT ===");

        System.out.println("Enter symptoms");
        System.out.println("Enter diagnosis");
        System.out.println("Enter treatment");
        System.out.println("Enter remarks");
    }


    public void manageMedicineRecords() {

        System.out.println("\n=== MANAGE MEDICINE RECORDS ===");

        System.out.println("1. Create Medicine");
        System.out.println("2. View Medicines");
        System.out.println("3. Update Medicine");
        System.out.println("4. Delete Medicine");
    }


    public void updateClinicVisit() {

        System.out.println("\n=== UPDATE CLINIC VISIT ===");

        System.out.println("Update symptoms");
        System.out.println("Update diagnosis");
        System.out.println("Update treatment");
        System.out.println("Update remarks");
    }


    public void viewClinicReports() {

        System.out.println("\n=== CLINIC REPORTS ===");

        System.out.println("Total clinic visits");
        System.out.println("Number of students who visited");
        System.out.println("Common reasons for clinic visits");
        System.out.println("Medicines used");
        System.out.println("Low-stock medicines");
    }
}