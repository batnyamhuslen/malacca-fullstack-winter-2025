package mn.icode;

import java.util.Objects;

public class Grade {
    private int id;
    private int studentId;
    private int courseId;
    private double grade; // 0.0 - 4.0
    private String semester;

    public Grade(int id, int studentId, int courseId, double grade, String semester) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.semester = semester;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", semester='" + semester + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade gradeObj = (Grade) o;
        return id == gradeObj.id && studentId == gradeObj.studentId &&
                courseId == gradeObj.courseId && Double.compare(gradeObj.grade, grade) == 0 &&
                Objects.equals(semester, gradeObj.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, courseId, grade, semester);
    }
}