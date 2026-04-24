package mn.icode;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryCourseRepository implements CourseRepository {
    private final Map<Integer, Course> courses = new HashMap<>();
    private int nextId = 1;

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }

    @Override
    public Optional<Course> findById(int id) {
        return Optional.ofNullable(courses.get(id));
    }

    @Override
    public Optional<Course> findByCode(String code) {
        return courses.values().stream()
                .filter(course -> course.getCode().equals(code))
                .findFirst();
    }

    @Override
    public List<Course> findByInstructor(String instructor) {
        return courses.values().stream()
                .filter(course -> course.getInstructor().equals(instructor))
                .collect(Collectors.toList());
    }

    @Override
    public Course save(Course course) {
        if (course.getId() == 0) {
            course.setId(nextId++);
        }
        courses.put(course.getId(), course);
        return course;
    }

    @Override
    public void deleteById(int id) {
        courses.remove(id);
    }
}