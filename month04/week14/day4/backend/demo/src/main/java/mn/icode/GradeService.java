package mn.icode;

import java.util.*;
import java.util.stream.Collectors;

public class GradeService {
    private final GradeRepository gradeRepo;
    private final StudentRepository studentRepo;
    private final CourseRepository courseRepo;

    public GradeService(GradeRepository gradeRepo,
                        StudentRepository studentRepo,
                        CourseRepository courseRepo) {
        this.gradeRepo = gradeRepo;
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

   
    public Grade addGrade(Grade grade) throws ValidationException {
   
        if (studentRepo.findById(grade.getStudentId()).isEmpty()) {
            throw new ValidationException("Student not found: " + grade.getStudentId());
        }

       
        if (courseRepo.findById(grade.getCourseId()).isEmpty()) {
            throw new ValidationException("Course not found: " + grade.getCourseId());
        }

        
        if (grade.getGrade() < 0 || grade.getGrade() > 4.0) {
            throw new ValidationException("Grade must be between 0 and 4.0");
        }

      
        boolean isDuplicate = gradeRepo.findAll().stream()
                .anyMatch(g ->
                        g.getStudentId() == grade.getStudentId() &&
                        g.getCourseId() == grade.getCourseId() &&
                        g.getSemester().equals(grade.getSemester())
                );

        if (isDuplicate) {
            throw new ValidationException("Grade already exists for this student/course/semester");
        }

        return gradeRepo.save(grade);
    }

    public Grade updateGrade(Grade grade) throws ValidationException {
   
        if (gradeRepo.findById(grade.getId()).isEmpty()) {
            throw new ValidationException("Grade not found: " + grade.getId());
        }

     
        if (grade.getGrade() < 0 || grade.getGrade() > 4.0) {
            throw new ValidationException("Grade must be between 0 and 4.0");
        }

        return gradeRepo.save(grade);
    }

    
    public boolean deleteGrade(int id) {
        if (gradeRepo.findById(id).isPresent()) {
            gradeRepo.deleteById(id);
            return true;
        }
        return false;
    }

    
    public List<Grade> getGradesByStudent(int studentId) {
        if (studentRepo.findById(studentId).isEmpty()) {
            return Collections.emptyList();
        }

        return gradeRepo.findAll().stream()
                .filter(grade -> grade.getStudentId() == studentId)
                .collect(Collectors.toList());
    }

    
    public List<Grade> getGradesByCourse(int courseId) {
        if (courseRepo.findById(courseId).isEmpty()) {
            return Collections.emptyList();
        }

        return gradeRepo.findAll().stream()
                .filter(grade -> grade.getCourseId() == courseId)
                .collect(Collectors.toList());
    }

   
    public double getAverageGradeByCourse(int courseId) {
        List<Grade> grades = getGradesByCourse(courseId);

        if (grades.isEmpty()) {
            return 0.0;
        }

        return grades.stream()
                .mapToDouble(Grade::getGrade)
                .average()
                .orElse(0.0);
    }

    
  
    public Map<String, Integer> getGradeDistribution(int courseId) {
        Map<String, Integer> distribution = new LinkedHashMap<>();
        distribution.put("A", 0);
        distribution.put("B", 0);
        distribution.put("C", 0);
        distribution.put("D", 0);
        distribution.put("F", 0);

        List<Grade> grades = getGradesByCourse(courseId);

        for (Grade grade : grades) {
            double value = grade.getGrade();

            if (value >= 3.5) {
                distribution.put("A", distribution.get("A") + 1);
            } else if (value >= 2.5) {
                distribution.put("B", distribution.get("B") + 1);
            } else if (value >= 1.5) {
                distribution.put("C", distribution.get("C") + 1);
            } else if (value >= 0.5) {
                distribution.put("D", distribution.get("D") + 1);
            } else {
                distribution.put("F", distribution.get("F") + 1);
            }
        }

        return distribution;
    }

   
    public double getStudentGPA(int studentId) {
        List<Grade> grades = getGradesByStudent(studentId);

        if (grades.isEmpty()) {
            return 0.0;
        }

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            Optional<Course> course = courseRepo.findById(grade.getCourseId());
            if (course.isPresent()) {
                totalGradePoints += grade.getGrade() * course.get().getCredits();
                totalCredits += course.get().getCredits();
            }
        }

        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }

 
    public List<Grade> getGradesByStudentAndSemester(int studentId, String semester) {
        return gradeRepo.findAll().stream()
                .filter(grade -> grade.getStudentId() == studentId &&
                        grade.getSemester().equals(semester))
                .collect(Collectors.toList());
    }

   
    public List<Integer> getTopStudentsByCourse(int courseId, int limit) {
        return getGradesByCourse(courseId).stream()
                .sorted(Comparator.comparingDouble(Grade::getGrade).reversed())
                .limit(limit)
                .map(Grade::getStudentId)
                .distinct()
                .collect(Collectors.toList());
    }
}
