
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String usn;
    String name;
    String dob;
    String MotherPhoneNumber;
    String FatherPhoneNumber;
    String studentPhoneNumber;
    int[] marks = new int[4];
    boolean eventParticipation;


    Student(String usn, String name, String dob, String MotherPhoneNumber,
            String FatherPhoneNumber, String studentPhoneNumber,
            int[] marks, boolean eventParticipation) {

        this.usn = usn;
        this.name = name;
        this.dob = dob;
        this.MotherPhoneNumber = MotherPhoneNumber;
        this.FatherPhoneNumber = FatherPhoneNumber;
        this.studentPhoneNumber = studentPhoneNumber;
        this.marks = marks;
        this.eventParticipation = eventParticipation;
    }

    void display() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Mother's Phone: " + MotherPhoneNumber);
        System.out.println("Father's Phone: " + FatherPhoneNumber);
        System.out.println("Student's Phone: " + studentPhoneNumber);

        for (int i = 0; i < 4; i++) {
            System.out.println("Semester " + (i + 1) + " Marks: " + marks[i]);
        }

        System.out.println("Event Participation: " +
                (eventParticipation ? "Yes" : "No"));
        System.out.println("-----------------------------------");
    }
}

public class StudentRecordManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
while (true) {
        System.out.println("\n===== STUDENT RECORD MANAGEMENT =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by USN");
        System.out.println("4. Delete Student");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine(); // Consume newline
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> viewStudent();
            case 3 -> searchStudent();
            case 4 -> deleteStudent();
            case 5 -> {
                System.out.println("Thank You!");
                System.exit(0);
            }
            default -> System.out.println("Invalid Choice!");
        }
    }
}

static void addStudent() {
    System.out.print("Enter USN: ");
    String usn = sc.nextLine();
    System.out.print("Enter Name: ");
    String name = sc.nextLine();
    System.out.print("Enter DOB: ");
    String dob = sc.nextLine();
    System.out.print("Enter Mother's Phone: ");
    String MotherPhoneNumber = sc.nextLine();
    System.out.print("Enter Father's Phone: ");
    String FatherPhoneNumber = sc.nextLine();
    System.out.print("Enter Student's Phone: ");
    String studentPhoneNumber = sc.nextLine();
    
    int[] marks = new int[4];
    for (int i = 0; i < 4; i++) {
        System.out.print("Enter Semester " + (i + 1) + " Marks: ");
        marks[i] = sc.nextInt();
    }
    
    System.out.print("Event Participation (1 for Yes, 0 for No): ");
    boolean eventParticipation = sc.nextInt() == 1;
    sc.nextLine();

    students.add(new Student(usn, name, dob, MotherPhoneNumber, FatherPhoneNumber, studentPhoneNumber, marks, eventParticipation));
    System.out.println("Student added successfully!");
}

static void viewStudent() {
    if (students.isEmpty()) {
        System.out.println("No students found!");
        return;
    }
    for (Student student : students) {
        student.display();
    }
}

static void searchStudent() {
    System.out.print("Enter USN to search: ");
    String usn = sc.nextLine();
    for (Student student : students) {
        if (student.usn.equals(usn)) {
            student.display();
            return;
        }
    }
    System.out.println("Student not found!");
}

static void deleteStudent() {
    System.out.print("Enter USN to delete: ");
    String usn = sc.nextLine();
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).usn.equals(usn)) {
            students.remove(i);
            System.out.println("Student deleted successfully!");
            return;
        }
    }
    System.out.println("Student not found!");
}
}