package mn.icode;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentRepository implements Repository<Student> {
    private final String filePath;
    private List<Student> students;

    public StudentRepository(String filePath) {
        this.filePath = filePath;
        this.students = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() {
        try {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                List<String> lines = Files.readAllLines(path);
                // Skip header line
                for (int i = 1; i < lines.size(); i++) {
                    students.add(Student.fromCSV(lines.get(i)));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading students: " + e.getMessage());
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            // Write header
            writer.println("id,firstName,lastName,email,birthDate,enrollmentDate");
            // Write data
            for (Student s : students) {
                writer.println(s.toCSV());
            }
        } catch (IOException e) {
            System.err.println("Error saving students: " + e.getMessage());
        }
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Optional<Student> findById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
    }

    @Override
    public void save(Student student) {
        student.setId(getNextId());
        students.add(student);
        saveToFile();
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                saveToFile();
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        students.removeIf(s -> s.getId() == id);
        saveToFile();
    }

    @Override
    public int getNextId() {
        return students.stream()
                .mapToInt(Student::getId)
                .max()
                .orElse(0) + 1;
    }

    // Additional query methods
    public List<Student> findByLastName(String lastName) {
        return students.stream()
                .filter(s -> s.getLastName().equalsIgnoreCase(lastName))
                .toList();
    }

    public List<Student> findByEmail(String email) {
        return students.stream()
                .filter(s -> s.getEmail().equalsIgnoreCase(email))
                .toList();
    }
}
