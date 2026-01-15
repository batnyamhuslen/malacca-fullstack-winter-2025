public class LogicalPractice {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;
        boolean c = true;

        // AND (&&) - Хоёулаа үнэн бол үнэн
        System.out.println(a && b);  // ___
        System.out.println(a && c);  // ___
        System.out.println(b && b);  // ___

        // OR (||) - Аль нэг үнэн бол үнэн
        System.out.println(a || b);  // ___
        System.out.println(b || b);  // ___

        // NOT (!) - Эсрэгээр
        System.out.println(!a);      // ___
        System.out.println(!b);      // ___

        // Хослол
        System.out.println(a && !b); // ___
        System.out.println(!a || b); // ___
    }
}
