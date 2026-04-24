package mn.icode;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> findAll();
    Optional<Student> findById(int id);
    Student save(Student student);
    void deleteById(int id);
}
