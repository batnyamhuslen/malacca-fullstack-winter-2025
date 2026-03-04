import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("Tuguldur", 85));
        students.add(new Student("Khuslen", 90));
        students.add(new Student("Ochiroo", 78));
        students.add(new Student("davaadulam", 88));
        students.add(new Student("temuulen", 70));
// ------------------------------------------------------------------------------------------------------------------
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        double average = sum / students.size();
        System.out.println("================================");
        System.out.println("niit oyutnii dundaj: " + average);
        System.out.println("================================");
// ------------------------------------------------------------------------------------------------------------------
        Student ProStudent = students.get(0);
        for (Student student : students) {
            if (student.getGrade() > ProStudent.getGrade()) {
                ProStudent = student;
            }
        }
        System.out.println("Onts suragch: " + ProStudent.getName() + ": " + ProStudent.getGrade());
// ------------------------------------------------------------------------------------------------------------------
        System.out.println("============+80 guyz============");
        for (Student student : students) {
            if (student.getGrade() > 80) {
                System.out.println(student.getName() + " - " + student.getGrade());
            }
        }
        System.out.println("================================");
// ------------------------------------------------------------------------------------------------------------------  

    }
}