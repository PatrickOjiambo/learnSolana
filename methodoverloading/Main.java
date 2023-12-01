package methodoverloading;

public class Main {
    public static void main(String[] args) {
        /**
         * Method overloading is when you have multiple methods with the same name, but different parameters.
         */
        System.out.println(printy(4, 2));
        System.out.println(printy("Hello"));
    }
    public static void printy(int i, int j) {
        System.out.println("Printing int: " + i);
    }
    public static void printy(String s) {
        System.out.println("Printing string: " + s);
    }
}
