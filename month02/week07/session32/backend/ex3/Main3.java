public class Main3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Oyuna", "Math");
        Student student = new Student("Anu", 11);

        teacher.introduce();
        student.introduce();
    }
}