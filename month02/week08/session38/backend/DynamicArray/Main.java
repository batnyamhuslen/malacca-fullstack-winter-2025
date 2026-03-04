public class Main {
    public static void main(String[] args) {

        int[] a = {1, 4, 6, 7, 8};

        int[] b = new int[a.length + 2];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        b[b.length - 2] = 10;
        b[b.length - 1] = 11;

        a = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            a[i] = b[i];
        }

        System.out.println("====================");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        int[] c = new int[a.length + 1];
        c[0] = 0;

        for (int i = 1; i < c.length; i++) {
            c[i] = a[i - 1];
        }

        System.out.println("====================");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

        int removeIndex = 5;
        int[] reducedArray = new int[c.length - 1];

        for (int i = 0, j = 0; i < c.length; i++) {
            if (i != removeIndex) {
                reducedArray[j++] = c[i];
            }
        }

        System.out.println("====================");
        for (int i = 0; i < reducedArray.length; i++) {
            System.out.println(reducedArray[i]);
        }
    }
}
