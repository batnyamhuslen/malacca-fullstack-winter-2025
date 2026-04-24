package mn.icode;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {
    List<Course> findAll();

    Optional<Course> findById(int id);

    Optional<Course> findByCode(String code);

    List<Course> findByInstructor(String instructor);

    Course save(Course course);

    void deleteById(int id);
}
