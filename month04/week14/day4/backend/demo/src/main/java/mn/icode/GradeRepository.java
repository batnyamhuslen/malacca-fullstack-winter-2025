package mn.icode;

import java.util.List;
import java.util.Optional;

public interface GradeRepository {
    List<Grade> findAll();
    Optional<Grade> findById(int id);
    Grade save(Grade grade);
    void deleteById(int id);
}
