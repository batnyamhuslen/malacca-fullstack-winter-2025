package mn.icode;

import model2.Student;
import model.Grade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        List<Grade> grades = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Show Student Grades");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            // ➤ Add Student
            if (choice == 1) {
                System.out.print("Student ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                students.add(new Student(id, name));

                System.out.println("✅ Student added");
            }

            // ➤ Add Grade
            else if (choice == 2) {
                System.out.print("Grade ID: ");
                int id = sc.nextInt();

                System.out.print("Student ID: ");
                int studentId = sc.nextInt();

                System.out.print("Grade (0-4): ");
                double gradeVal = sc.nextDouble();

                grades.add(new Grade(
                        id,
                        studentId,
                        101,
                        gradeVal,
                        "2024-Spring",
                        LocalDate.now()
                ));

                System.out.println("✅ Grade added");
            }

            // ➤ Show Student + Grades
            else if (choice == 3) {

                for (Student s : students) {

                    System.out.println("\n👤 " + s);

                    for (Grade g : grades) {
                        if (g.getStudentId() == s.getId()) {
                            System.out.println("   ➜ " + g);
                        }
                    }
                }
            }

            else if (choice == 0) {
                break;
            }
        }
    }
}