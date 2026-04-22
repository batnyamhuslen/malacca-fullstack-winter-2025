package mn.icode;

public class App {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository("students.csv");

        Student s = new Student();
        s.setFirstName("khuslen");
        s.setLastName("batnyam");
        s.setEmail("khuslen@gmail.com");

        repo.save(s);

        Student s2 = new Student();
        s.setFirstName("ochiroo");
        s.setLastName("h");
        s.setEmail("ochiroo@gmail.com");

        repo.save(s2);
        
        System.out.println("All students:");
        repo.findAll().forEach(st ->
            System.out.println(st.getId() + " " + st.getFirstName() + " " + st.getLastName())
        );
    }
}