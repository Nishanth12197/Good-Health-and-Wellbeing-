import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String name;
    private int age;
    private String id;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

class Diagnosis {
    private String patientId;
    private String diagnosisDetails;
    private String date;

    public Diagnosis(String patientId, String diagnosisDetails, String date) {
        this.patientId = patientId;
        this.diagnosisDetails = diagnosisDetails;
        this.date = date;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Diagnosis: " + diagnosisDetails;
    }
}

public class Main {
    private List<Patient> patients;
    private List<Diagnosis> diagnoses;

    public Main() {
        patients = new ArrayList<>();
        diagnoses = new ArrayList<>();
    }

    public void registerPatient(String id, String name, int age) {
        Patient patient = new Patient(id, name, age);
        patients.add(patient);
        System.out.println("Patient registered: " + patient);
    }

    public void addDiagnosis(String patientId, String diagnosisDetails, String date) {
        Diagnosis diagnosis = new Diagnosis(patientId, diagnosisDetails, date);
        diagnoses.add(diagnosis);
        System.out.println("Diagnosis added for patient ID " + patientId);
    }

    public void showPatientHistory(String patientId) {
        System.out.println("Diagnosis history for patient ID " + patientId + ":");
        for (Diagnosis diagnosis : diagnoses) {
            if (diagnosis.getPatientId().equals(patientId)) {
                System.out.println(diagnosis);
            }
        }
    }

    public static void main(String[] args) {
        Main system = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n1. Register Patient");
                System.out.println("2. Add Diagnosis");
                System.out.println("3. Show Patient History");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Patient ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        system.registerPatient(id, name, age);
                        break;
                    case 2:
                        System.out.print("Enter Patient ID: ");
                        String patientId = scanner.nextLine();
                        System.out.print("Enter Diagnosis Details: ");
                        String diagnosisDetails = scanner.nextLine();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        system.addDiagnosis(patientId, diagnosisDetails, date);
                        break;
                    case 3:
                        System.out.print("Enter Patient ID: ");
                        String pid = scanner.nextLine();
                        system.showPatientHistory(pid);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
}
