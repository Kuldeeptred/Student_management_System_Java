import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {

    private int rollNo;
    private String name;
    private int age;
    private double spi;
    private String emailId;
    private String mobileNumber;
    private String department;
    private int semester;
    private String division;
    private String collegeName;
    private String counselorName;

    public Student(int rollNo, String name, int age, double spi, String emailId, String mobileNumber, String department,
            int semester, String division, String collegeName, String counselorName) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.spi = spi;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.department = department;
        this.semester = semester;
        this.division = division;
        this.collegeName = collegeName;
        this.counselorName = counselorName;
    }

    public String getDetails() {
        return String.format(
                "Roll No: %-5d\n" +
                        "Name   : %-15s\n" +
                        "Age    : %-3d\n" +
                        "SPI    : %-4.2f\n" +
                        "Email  : %-20s\n" +
                        "Mobile : %-10s\n" +
                        "Dept   : %-15s\n" +
                        "Sem    : %-2d\n" +
                        "Div    : %-5s\n" +
                        "College: %-20s\n" +
                        "Counselor: %-15s\n",
                rollNo, name, age, spi, emailId, mobileNumber, department, semester, division, collegeName,
                counselorName);
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpi(double spi) {
        this.spi = spi;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setCounselorName(String counselorName) {
        this.counselorName = counselorName;
    }
}

public class A6_Student_Management_System {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static JTextArea outputArea;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createGUI();

        while (true) {
            try {
                System.out.println("\n=========================================");
                System.out.println("        Student Management System        ");
                System.out.println("=========================================");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student Details");
                System.out.println("5. Exit");
                System.out.println("=========================================");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        displayStudents();
                        break;
                    case 3:
                        searchStudent(scanner);
                        break;
                    case 4:
                        updateStudent(scanner);
                        break;
                    case 5:
                        System.out.println("\nThank you for using the system! Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        try {
            System.out.print("\nEnter Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            System.out.print("Enter SPI: ");
            double spi = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter Email ID: ");
            String emailId = scanner.nextLine();

            System.out.print("Enter Mobile Number: ");
            String mobileNumber = scanner.nextLine();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine();

            System.out.print("Enter Semester: ");
            int semester = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Division: ");
            String division = scanner.nextLine();

            System.out.print("Enter College Name: ");
            String collegeName = scanner.nextLine();

            System.out.print("Enter Counselor Name: ");
            String counselorName = scanner.nextLine();

            students.add(new Student(rollNo, name, age, spi, emailId, mobileNumber, department, semester, division,
                    collegeName, counselorName));
            System.out.println("\n Student added successfully!\n");
        } catch (Exception e) {
            System.out.println("⚠ Error while adding student: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            outputArea.setText("⚠ No students to display!\n");
            return;
        }

        StringBuilder output = new StringBuilder();
        output.append("===================================\n");
        output.append("        Student Information List          \n");
        output.append("===================================\n");

        for (Student student : students) {
            output.append(student.getDetails()).append("\n");
        }

        output.append("===================================\n");
        outputArea.setText(output.toString());
    }

    private static void searchStudent(Scanner scanner) {
        try {
            System.out.print("\n🔍 Enter Roll No to Search: ");
            int searchRollNo = scanner.nextInt();

            for (Student student : students) {
                if (student.getRollNo() == searchRollNo) {
                    outputArea.setText("\n Student Found!\n" + student.getDetails());
                    return;
                }
            }
            outputArea.setText("\nStudent Not Found!\n");
        } catch (Exception e) {
            System.out.println(" Error while searching for student: " + e.getMessage());
            scanner.nextLine();
        }
    }

    private static void updateStudent(Scanner scanner) {
        try {
            System.out.print("\n Enter Roll No to Update: ");
            int searchRollNo = scanner.nextInt();
            scanner.nextLine();

            for (Student student : students) {
                if (student.getRollNo() == searchRollNo) {
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    student.setName(newName);

                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    student.setAge(newAge);

                    System.out.print("Enter New SPI: ");
                    double newSpi = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter New Email ID: ");
                    String newEmailId = scanner.nextLine();
                    student.setEmailId(newEmailId);

                    System.out.print("Enter New Mobile Number: ");
                    String newMobileNumber = scanner.nextLine();
                    student.setMobileNumber(newMobileNumber);

                    System.out.print("Enter New Department: ");
                    String newDepartment = scanner.nextLine();
                    student.setDepartment(newDepartment);

                    System.out.print("Enter New Semester: ");
                    int newSemester = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Division: ");
                    String newDivision = scanner.nextLine();
                    student.setDivision(newDivision);

                    System.out.print("Enter New College Name: ");
                    String newCollegeName = scanner.nextLine();
                    student.setCollegeName(newCollegeName);

                    System.out.print("Enter New Counselor Name: ");
                    String newCounselorName = scanner.nextLine();
                    student.setCounselorName(newCounselorName);

                    System.out.println("\nStudent details updated successfully!\n");
                    return;
                }
            }
            System.out.println("\n Student Not Found!\n");
        } catch (Exception e) {
            System.out.println("⚠ Error while updating student: " + e.getMessage());
 y           scanner.nextLine();
        }
    }

    private static void createGUI() {

        JFrame frame = new JFrame("🎓 Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout(10, 10));

        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("Student Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(titleLabel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.BOLD, 14));
        outputArea.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
