package mn.icode;

import java.util.*;

public class InMemoryGradeRepository implements GradeRepository {
    private final Map<Integer, Grade> grades = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Grade> findAll() {
        return new ArrayList<>(grades.values());
    }

    @Override
    public Optional<Grade> findById(int id) {
        return Optional.ofNullable(grades.get(id));
    }

    @Override
    public Grade save(Grade grade) {
        if (grade.getId() == 0) {
            grade.setId(nextId++);
        }
        grades.put(grade.getId(), grade);
        return grade;
    }

    @Override
    public void deleteById(int id) {
        grades.remove(id);
    }
}
