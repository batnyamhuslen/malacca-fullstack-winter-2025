package mn.icode;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Student() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public static Student fromCSV(String line) {
        String[] parts = line.split(",");

        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid CSV: " + line);
        }

        Student s = new Student();
        s.setId(Integer.parseInt(parts[0]));
        s.setFirstName(parts[1]);
        s.setLastName(parts[2]);
        s.setEmail(parts[3]);

        return s;
    }

    public String toCSV() {
        return id + "," + firstName + "," + lastName + "," + email;
    }
}