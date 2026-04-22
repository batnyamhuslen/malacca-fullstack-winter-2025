package model;

import java.time.LocalDate;

public class Grade {

    private int id;
    private int studentId;   // 🔥 холбоос
    private int courseId;
    private double grade;
    private String semester;
    private LocalDate gradeDate;

    public Grade() {}

    public Grade(int id, int studentId, int courseId, double grade, String semester, LocalDate gradeDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.semester = semester;
        this.gradeDate = gradeDate;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getGrade() {
        return grade;
    }

    public String getLetterGrade() {
        if (grade >= 3.7) return "A";
        if (grade >= 3.3) return "A-";
        if (grade >= 3.0) return "B+";
        if (grade >= 2.7) return "B";
        if (grade >= 2.0) return "C";
        if (grade >= 1.0) return "D";
        return "F";
    }

    @Override
    public String toString() {
        return "Grade{id=" + id +
                ", studentId=" + studentId +
                ", grade=" + grade +
                ", letter=" + getLetterGrade() +
                "}";
    }
}