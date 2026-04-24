package mn.icode;

import java.util.List;

public class App {
    public static void main(String[] args) {

        CourseRepository courseRepo = new InMemoryCourseRepository();
        StudentRepository studentRepo = new InMemoryStudentRepository();
        GradeRepository gradeRepo = new InMemoryGradeRepository();


        CourseService courseService = new CourseService(courseRepo);
        StudentService studentService = new StudentService(studentRepo);
        GradeService gradeService = new GradeService(gradeRepo, studentRepo, courseRepo);

        try {

            System.out.println("========== СУРГАЛТЫН УДИРДЛАГА ==========\n");

            Course course1 = new Course(0, "CS101", "Компьютерийн шинжлэх ухааны танилцуулга", 3, "Dr. Khangai");
            Course course2 = new Course(0, "CS201", "Өгөгдлийн бүтэц", 4, "Dr.Tulga");
            Course course3 = new Course(0, "MATH101", "Тооцооллын I", 4, "Dr. Brad");

            courseService.addCourse(course1);
            courseService.addCourse(course2);
            courseService.addCourse(course3);

            System.out.println("Бүх сургалтууд");
            courseService.getAllCourses().forEach(System.out::println);

            System.out.println("\n'CS' хайлтын үр дүн:");
            courseService.searchCourses("CS").forEach(System.out::println);

            System.out.println("\nДоктор Хангайн хичээлүүд");
            courseService.getCoursesByInstructor("Dr. Smith").forEach(System.out::println);

            System.out.println("\nID 1-ээр хичээл авах:");
            courseService.getCourseById(1).ifPresent(System.out::println);

            System.out.println("\n'CS201' кодоор сургалтанд хамрагдах:");
            courseService.getCourseByCode("CS201").ifPresent(System.out::println);


            System.out.println("\n\n========== ОЮУТНЫ МЕНЕЖМЕНТ ==========\n");

            Student student1 = new Student(0, "Batnyam", "Huslen", "batnyamhuslen@email.com");
            Student student2 = new Student(0, "Jane", "Ochiroo", "ochiroo@email.com");
            Student student3 = new Student(0, "Bob", "Dadu", "Dadu@email.com");
            Student student4 = new Student(0, "Alice", "Tuguldur", "tuguldur@email.com");

            studentService.addStudent(student1);
            studentService.addStudent(student2);
            studentService.addStudent(student3);
            studentService.addStudent(student4);

            System.out.println("Бүх оюутнууд:");
            studentService.getAllStudents().forEach(System.out::println);

            System.out.println("\nОюутнуудыг хайх 'Huslen':");
            studentService.searchStudents("Huslen").forEach(System.out::println);

            System.out.println("\nОвогтой оюутнууд 'Jane':");
            studentService.getStudentsByLastName("Jane").forEach(System.out::println);

            System.out.println("\nОвогоор нь эрэмбэлсэн оюутнууд (өсөх дарааллаар):");
            studentService.sortStudentsByLastName(true).forEach(System.out::println);

            System.out.println("\nОюутныг имэйлээр авах 'batnyamhuslen@email.com':");
            studentService.getStudentByEmail("batnyamhuslen@gmail.com.com").ifPresent(System.out::println);

            System.out.println("\nИ-мэйл домэйнээр дамжуулан оюутнууд '@email.com':");
            studentService.getStudentsByEmailDomain("email.com").forEach(System.out::println);

            System.out.println("\nНийт сурагчдын тоо: " + studentService.getTotalStudentCount());

            System.out.println("\nEmail 'ochiroo@email.com' exists: " + 
                    studentService.emailExists("ochiroo@email.com"));


            System.out.println("\n\n========== ЗЭРГИЙН УДИРДЛАГА ==========\n");

            Grade grade1 = new Grade(0, 1, 1, 3.8, "Хавар 2026");
            Grade grade2 = new Grade(0, 1, 2, 3.5, "Хавар 2026");
            Grade grade3 = new Grade(0, 1, 3, 3.9, "Хавар 2026");

            Grade grade4 = new Grade(0, 2, 1, 3.9, "Хавар 2026");
            Grade grade5 = new Grade(0, 2, 2, 3.2, "Хавар 2026");
            Grade grade6 = new Grade(0, 2, 3, 3.6, "Хавар 2026");

            Grade grade7 = new Grade(0, 3, 1, 2.8, "Хавар 2026");
            Grade grade8 = new Grade(0, 3, 2, 3.1, "Хавар 2026");

            Grade grade9 = new Grade(0, 4, 1, 3.5, "Хавар 2026");
            Grade grade10 = new Grade(0, 4, 3, 3.7, "Хавар 2026");

            gradeService.addGrade(grade1);
            gradeService.addGrade(grade2);
            gradeService.addGrade(grade3);
            gradeService.addGrade(grade4);
            gradeService.addGrade(grade5);
            gradeService.addGrade(grade6);
            gradeService.addGrade(grade7);
            gradeService.addGrade(grade8);
            gradeService.addGrade(grade9);
            gradeService.addGrade(grade10);

            System.out.println("1-р сурагчийн дүн (Batnyam Huslen):");
            gradeService.getGradesByStudent(1).forEach(System.out::println);

            System.out.println("\n1-р курс (CS101)-ийн дүн:");
            gradeService.getGradesByCourse(1).forEach(System.out::println);

            System.out.println("\n1-р хичээлийн дундаж дүн (CS101):" + 
                    String.format("%.2f", gradeService.getAverageGradeByCourse(1)));

            System.out.println("\n 2-р хичээлийн дундаж дүн (CS201):" + 
                    String.format("%.2f", gradeService.getAverageGradeByCourse(2)));

            System.out.println("\n3-р хичээлийн дундаж дүн (MATH101): " + 
                    String.format("%.2f", gradeService.getAverageGradeByCourse(3)));

            System.out.println("\n1-р курсын дүнгийн хуваарилалт (CS101):");
            gradeService.getGradeDistribution(1).forEach((letter, count) ->
                    System.out.println("  " + letter + ": " + count)
            );

            System.out.println("\n2-р курсын дүнгийн хуваарилалт (CS201):");
            gradeService.getGradeDistribution(2).forEach((letter, count) ->
                    System.out.println("  " + letter + ": " + count)
            );

            System.out.println("\nStudent 1 (Batnyam Huslen) GPA: " + 
                    String.format("%.2f", gradeService.getStudentGPA(1)));

            System.out.println("\nStudent 2 (Jane Ochiroo) GPA: " + 
                    String.format("%.2f", gradeService.getStudentGPA(2)));

            System.out.println("\nStudent 3 (Bob Dadu) GPA: " + 
                    String.format("%.2f", gradeService.getStudentGPA(3)));

            System.out.println("\n2026 оны хавар 1-р ангийн сурагчийн дүн:");
            gradeService.getGradesByStudentAndSemester(1, "Spring 2026").forEach(System.out::println);

            System.out.println("\n1-р курсын шилдэг 2 оюутан (CS101):");
            List<Integer> topStudents1 = gradeService.getTopStudentsByCourse(1, 2);
            topStudents1.forEach(studentId ->
                    System.out.println("  " + studentService.getStudentFullName(studentId))
            );

            System.out.println("\n2-р курсын шилдэг 2 оюутан (CS201):");
            List<Integer> topStudents2 = gradeService.getTopStudentsByCourse(2, 2);
            topStudents2.forEach(studentId ->
                    System.out.println("  " + studentService.getStudentFullName(studentId))
            );


            System.out.println("\n\n========== ШИНЭЧЛЭХ ҮЙЛ АЖИЛЛАГАА ==========\n");

            System.out.println("1-р хичээлийн кредитийг 3-аас 4 болгон шинэчилж байна...");
            Course updateCourse = courseService.getCourseById(1).get();
            updateCourse.setCredits(4);
            courseService.updateCourse(updateCourse);
            System.out.println("Updated: " + courseService.getCourseById(1).get());

            System.out.println("\n1-р оюутны имэйлийг шинэчилж байна...");
            Student updateStudent = studentService.getStudentById(1).get();
            updateStudent.setEmail("batnyamhuslen.updated@email.com");
            studentService.updateStudent(updateStudent);
            System.out.println("Updated: " + studentService.getStudentById(1).get());

            System.out.println("\n1-р ангийг шинэчилж байна (Жонсын CS101 үнэлгээг 3.8-аас 3.9 болгож байна)...");
            List<Grade> johnGrades = gradeService.getGradesByStudent(1);
            Grade gradeToUpdate = johnGrades.get(0);
            gradeToUpdate.setGrade(3.9);
            gradeService.updateGrade(gradeToUpdate);
            System.out.println("Дүнг 3.9 болгож шинэчилсэн");
            System.out.println("Шинэ оюутны 1-р голч дүн:" + String.format("%.2f", gradeService.getStudentGPA(1)));


            System.out.println("\n\n========== ҮЙЛДЛҮҮДИЙГ УСТГАХ ==========\n");

            System.out.println("3-р курс (MATH101)-г устгаж байна...");
            boolean deletedCourse = courseService.deleteCourse(3);
            System.out.println("Курс устгагдсан: " + deletedCourse);
            System.out.println("Үлдсэн хичээлүүд:" + courseService.getAllCourses().size());

            System.out.println("\n4-р сурагчийг (Алис Браун) устгаж байна...");
            boolean deletedStudent = studentService.deleteStudent(4);
            System.out.println("Оюутныг устгасан:" + deletedStudent);
            System.out.println("Үлдсэн оюутнууд:" + studentService.getTotalStudentCount());

            System.out.println("\n\n========== ЭЦСИЙН ХУРААНГУЙ ==========\n");

            System.out.println("Нийт хичээлүүд:" + courseService.getAllCourses().size());
            System.out.println("Нийт оюутнууд:" + studentService.getTotalStudentCount());

            System.out.println("\nБүх үйл ажиллагаа амжилттай дууссан!");

        } catch (ValidationException e) {
            System.err.println("Баталгаажуулалтын алдаа:" + e.getMessage());
            e.printStackTrace();
        }
    }
}
