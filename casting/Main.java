package casting;

public class Main {
    /**
     *  - casting is the process of converting one data type to another
     *  - implicit casting is done automatically by the compiler when the data type is compatible from a narrower to a wider type e.g. int to double
     *  - explicit casting is done by the programmer when the data type is compatible from a wider to a narrower type e.g. double to int
     */
    public static void main(String[] args) {
        // implicit casting
        int a = 10;
        double b = a;
        System.out.println(b);

        // explicit casting
        //(new data type) expression
        double c = 10.5;
        int d = (int) c;
        System.out.println(d);

        // explicit casting
        int e = 10;
        byte f = (byte) e;
        System.out.println(f);

        // explicit casting
        int g = 10;
        char h = (char) g;
        System.out.println(h);

        // explicit casting
        char i = 'a';
        int j = (int) i;
        System.out.println(j);

        // explicit casting
        char k = 'a';
        byte l = (byte) k;
        System.out.println(l);

        // explicit casting
        byte m = 10;
        char n = (char) m;
        System.out.println(n);

        // explicit casting
        byte o = 10;
        int p = (int) o;
        System.out.println(p);

        // explicit casting
        byte q = 10;
        double r = (double) q;
        System.out.println(r);

        // explicit casting
        double s = 10.5;
        byte t = (byte) s;
        System.out.println(t);

        // explicit casting
        double u = 10.5;
        char v = (char) u;
        System.out.println(v);

        // explicit casting
        char w = 'a';
        double x = (double) w;
        System.out.println(x);

        // explicit casting
        char y = 'a';
        byte z = (byte) y;
        System.out.println(z);
    }
}
