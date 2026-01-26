

public class Array01 {
    public static void main(String[] args) {
        System.out.println("array creation");
        int a = 5;
        int b = 6;
        int c = 7;

        int[] d= {9,10,11,12};
        System.out.println(d);

        System.out.println(d[0]);
        System.out.println(d[1]);
        System.out.println(d[3]);

        String[] favoriteColors = new String[5];
        favoriteColors[0] = "red";
        favoriteColors[1] = "green";
        favoriteColors[2] = "blue";
        favoriteColors[3] = "orange";
        favoriteColors[4] = "tomato";

        favoriteColors[1] ="purple";
        favoriteColors[3] ="yellow";

    for(int i=0; i<favoriteColors.length;i++){
        System.out.println(favoriteColors[i]);
    }
    }
}
