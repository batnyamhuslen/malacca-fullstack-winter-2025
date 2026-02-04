public class IncrementPractice {
   
    public static void main(String[] args) {
        int a = 5;

        System.out.println("a = " + a);           // ___

        System.out.println("a++ = " + (a++));     // ___ (хэвлээд ДАРАА нэмнэ)
        System.out.println("a = " + a);           // ___

        System.out.println("++a = " + (++a));     // ___ (ЭХЛЭЭД нэмээд хэвлэнэ)
        System.out.println("a = " + a);           // ___

        System.out.println("a-- = " + (a--));     // ___ (хэвлээд ДАРАА хасна)
        System.out.println("a = " + a);           // ___

        System.out.println("--a = " + (--a));     // ___ (ЭХЛЭЭД хасаад хэвлэнэ)
        System.out.println("a = " + a);           // ___
    }
}
