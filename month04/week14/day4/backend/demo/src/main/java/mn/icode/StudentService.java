package mn.icode;

import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    private final StudentRepository studentRepo;

    public StudentService(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepo.findById(id);
    }

    public Student addStudent(Student student) throws ValidationException {
        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            throw new ValidationException("First name cannot be empty");
        }

        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            throw new ValidationException("Last name cannot be empty");
        }

        if (student.getEmail() == null || !isValidEmail(student.getEmail())) {
            throw new ValidationException("Invalid email format: " + student.getEmail());
        }

        boolean emailExists = studentRepo.findAll().stream()
                .anyMatch(s -> s.getEmail().equalsIgnoreCase(student.getEmail()));

        if (emailExists) {
            throw new ValidationException("Email already exists: " + student.getEmail());
        }

        return studentRepo.save(student);
    }

    public Student updateStudent(Student student) throws ValidationException {
        if (studentRepo.findById(student.getId()).isEmpty()) {
            throw new ValidationException("Student not found: " + student.getId());
        }

        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            throw new ValidationException("First name cannot be empty");
        }

        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            throw new ValidationException("Last name cannot be empty");
        }

        if (student.getEmail() == null || !isValidEmail(student.getEmail())) {
            throw new ValidationException("Invalid email format: " + student.getEmail());
        }

        boolean emailExists = studentRepo.findAll().stream()
                .anyMatch(s -> s.getEmail().equalsIgnoreCase(student.getEmail()) &&
                        s.getId() != student.getId());

        if (emailExists) {
            throw new ValidationException("Email already exists: " + student.getEmail());
        }

        return studentRepo.save(student);
    }

  
    public boolean deleteStudent(int id) {
        if (studentRepo.findById(id).isPresent()) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }

 
    public List<Student> searchStudents(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String lowerQuery = query.toLowerCase().trim();

        return studentRepo.findAll().stream()
                .filter(student ->
                        student.getFirstName().toLowerCase().contains(lowerQuery) ||
                        student.getLastName().toLowerCase().contains(lowerQuery)
                )
                .collect(Collectors.toList());
    }

  
    public Optional<Student> getStudentByEmail(String email) {
        if (email == null || email.isEmpty()) {
            return Optional.empty();
        }

        return studentRepo.findAll().stream()
                .filter(student -> student.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

  
    public List<Student> getStudentsByLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            return Collections.emptyList();
        }

        return studentRepo.findAll().stream()
                .filter(student -> student.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

   
    public List<Student> getStudentsByFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            return Collections.emptyList();
        }

        return studentRepo.findAll().stream()
                .filter(student -> student.getFirstName().equalsIgnoreCase(firstName))
                .collect(Collectors.toList());
    }

   
    public List<Student> sortStudentsByFirstName(boolean ascending) {
        List<Student> students = studentRepo.findAll();
        if (ascending) {
            students.sort(Comparator.comparing(Student::getFirstName));
        } else {
            students.sort(Comparator.comparing(Student::getFirstName).reversed());
        }
        return students;
    }

   
    public List<Student> sortStudentsByLastName(boolean ascending) {
        List<Student> students = studentRepo.findAll();
        if (ascending) {
            students.sort(Comparator.comparing(Student::getLastName));
        } else {
            students.sort(Comparator.comparing(Student::getLastName).reversed());
        }
        return students;
    }


    public int getTotalStudentCount() {
        return studentRepo.findAll().size();
    }

  
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }

  
    public List<Student> getStudentsByEmailDomain(String domain) {
        if (domain == null || domain.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String lowerDomain = "@" + domain.toLowerCase();

        return studentRepo.findAll().stream()
                .filter(student -> student.getEmail().toLowerCase().endsWith(lowerDomain))
                .collect(Collectors.toList());
    }

   
    public boolean emailExists(String email) {
        return getStudentByEmail(email).isPresent();
    }

   
    public String getStudentFullName(int studentId) {
        return studentRepo.findById(studentId)
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .orElse("Student not found");
    }
}
