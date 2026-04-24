package mn.icode;

import java.util.*;

public class InMemoryStudentRepository implements StudentRepository {
    private final Map<Integer, Student> students = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public Optional<Student> findById(int id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public Student save(Student student) {
        if (student.getId() == 0) {
            student.setId(nextId++);
        }
        students.put(student.getId(), student);
        return student;
    }

    @Override
    public void deleteById(int id) {
        students.remove(id);
    }
}
