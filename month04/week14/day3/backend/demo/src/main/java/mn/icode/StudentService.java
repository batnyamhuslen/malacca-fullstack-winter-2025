package service;

import model.Student;
import model.Grade;
import model.Course;
import repository.StudentRepository;
import repository.GradeRepository;
import repository.CourseRepository;
import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentRepository studentRepo;
    private final GradeRepository gradeRepo;
    private final CourseRepository courseRepo;

    public StudentService(StudentRepository studentRepo,
                         GradeRepository gradeRepo,
                         CourseRepository courseRepo) {
        this.studentRepo = studentRepo;
        this.gradeRepo = gradeRepo;
        this.courseRepo = courseRepo;
    }

    // ========== CRUD Operations ==========

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    public Student addStudent(Student student) throws ValidationException {
        // Validation
        validateStudent(student);

        // Check email uniqueness
        if (isEmailExists(student.getEmail())) {
            throw new ValidationException("Email already exists: " + student.getEmail());
        }

        studentRepo.save(student);
        return student;
    }

    public Student updateStudent(Student student) throws ValidationException {
        // Check if exists
        if (studentRepo.findById(student.getId()).isEmpty()) {
            throw new ValidationException("Student not found: " + student.getId());
        }

        validateStudent(student);
        studentRepo.update(student);
        return student;
    }

    public boolean deleteStudent(int id) {
        if (studentRepo.findById(id).isEmpty()) {
            return false;
        }
        studentRepo.delete(id);
        return true;
    }

    // ========== Validation ==========

    private void validateStudent(Student student) throws ValidationException {
        List<String> errors = new ArrayList<>();

        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            errors.add("First name is required");
        }
        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            errors.add("Last name is required");
        }
        if (student.getEmail() == null || !isValidEmail(student.getEmail())) {
            errors.add("Valid email is required");
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(String.join(", ", errors));
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isEmailExists(String email) {
        return studentRepo.findAll().stream()
            .anyMatch(s -> s.getEmail().equalsIgnoreCase(email));
    }

    // ========== Business Logic ==========

    /**
     * Оюутны GPA тооцоолох
     */
    public double calculateGPA(int studentId) {
        List<Grade> grades = gradeRepo.findByStudentId(studentId);
        if (grades.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            Optional<Course> course = courseRepo.findById(grade.getCourseId());
            if (course.isPresent()) {
                int credits = course.get().getCredits();
                totalPoints += grade.getGrade() * credits;
                totalCredits += credits;
            }
        }

        return totalCredits > 0 ? totalPoints / totalCredits : 0.0;
    }

    /**
     * Оюутны статус тодорхойлох
     */
    public String getAcademicStatus(int studentId) {
        double gpa = calculateGPA(studentId);

        if (gpa >= 3.5) return "Honors";
        if (gpa >= 3.0) return "Good Standing";
        if (gpa >= 2.0) return "Satisfactory";
        if (gpa >= 1.0) return "Probation";
        return "Academic Warning";
    }

    /**
     * Top N GPA-тай оюутнууд
     */
    public List<Student> getTopStudents(int n) {
        return studentRepo.findAll().stream()
            .sorted((s1, s2) -> Double.compare(
                calculateGPA(s2.getId()),
                calculateGPA(s1.getId())
            ))
            .limit(n)
            .collect(Collectors.toList());
    }

    /**
     * Нэрээр хайх
     */
    public List<Student> searchByName(String query) {
        String lowerQuery = query.toLowerCase();
        return studentRepo.findAll().stream()
            .filter(s ->
                s.getFirstName().toLowerCase().contains(lowerQuery) ||
                s.getLastName().toLowerCase().contains(lowerQuery)
            )
            .collect(Collectors.toList());
    }

    /**
     * Оюутны дэлгэрэнгүй report
     */
    public StudentReport getStudentReport(int studentId) {
        Optional<Student> studentOpt = studentRepo.findById(studentId);
        if (studentOpt.isEmpty()) {
            return null;
        }

        Student student = studentOpt.get();
        List<Grade> grades = gradeRepo.findByStudentId(studentId);
        double gpa = calculateGPA(studentId);
        String status = getAcademicStatus(studentId);

        return new StudentReport(student, grades, gpa, status);
    }
}

// Custom Exception
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

// Report class
class StudentReport {
    private Student student;
    private List<Grade> grades;
    private double gpa;
    private String status;

    public StudentReport(Student student, List<Grade> grades, double gpa, String status) {
        this.student = student;
        this.grades = grades;
        this.gpa = gpa;
        this.status = status;
    }

    // Getters...

    public void print() {
        System.out.println("\n========== STUDENT REPORT ==========");
        System.out.printf("Name: %s %s%n", student.getFirstName(), student.getLastName());
        System.out.printf("Email: %s%n", student.getEmail());
        System.out.printf("GPA: %.2f%n", gpa);
        System.out.printf("Status: %s%n", status);
        System.out.println("\nGrades:");
        System.out.println("----------------------------------------");
        for (Grade g : grades) {
            System.out.printf("Course %d: %.2f (%s)%n",
                g.getCourseId(), g.getGrade(), g.getSemester());
        }
        System.out.println("=====================================");
    }
}
