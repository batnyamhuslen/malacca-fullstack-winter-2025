package mn.icode;

import java.util.*;
import java.util.stream.Collectors;

public class CourseService {
    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepo.findById(id);
    }

    public Optional<Course> getCourseByCode(String code) {
        return courseRepo.findByCode(code);
    }

    public Course addCourse(Course course) throws ValidationException {
        if (courseRepo.findByCode(course.getCode()).isPresent()) {
            throw new ValidationException("Course code '" + course.getCode() + "' already exists");
        }

        if (course.getName() == null || course.getName().trim().isEmpty()) {
            throw new ValidationException("Course name cannot be empty");
        }

        if (course.getCredits() < 1 || course.getCredits() > 6) {
            throw new ValidationException("Credits must be between 1 and 6");
        }

        return courseRepo.save(course);
    }

    public Course updateCourse(Course course) throws ValidationException {
        Optional<Course> existing = courseRepo.findById(course.getId());
        if (existing.isEmpty()) {
            throw new ValidationException("Course with ID " + course.getId() + " not found");
        }

        if (course.getName() == null || course.getName().trim().isEmpty()) {
            throw new ValidationException("Course name cannot be empty");
        }

        if (course.getCredits() < 1 || course.getCredits() > 6) {
            throw new ValidationException("Credits must be between 1 and 6");
        }

        if (!existing.get().getCode().equals(course.getCode())) {
            if (courseRepo.findByCode(course.getCode()).isPresent()) {
                throw new ValidationException("Course code '" + course.getCode() + "' already exists");
            }
        }

        return courseRepo.save(course);
    }

    public boolean deleteCourse(int id) {
        if (courseRepo.findById(id).isPresent()) {
            courseRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Course> searchCourses(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String lowerQuery = query.toLowerCase().trim();

        return courseRepo.findAll().stream()
                .filter(course ->
                        course.getCode().toLowerCase().contains(lowerQuery) ||
                        course.getName().toLowerCase().contains(lowerQuery)
                )
                .collect(Collectors.toList());
    }

    public List<Course> getCoursesByInstructor(String instructor) {
        if (instructor == null || instructor.trim().isEmpty()) {
            return Collections.emptyList();
        }

        return courseRepo.findByInstructor(instructor);
    }
}