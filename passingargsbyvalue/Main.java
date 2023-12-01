package passingargsbyvalue;

public class Main {
    /**
     * parameters - variables that are declared in the method signature
     * arguments - values that are passed to the method
     */
    public static void main(String[] args) {
        //This is passing by value
        add(4, 0);
    }
     public static int add(int x, int y) {
        return x + y;
    }
}
