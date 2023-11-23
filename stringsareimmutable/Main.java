package stringsareimmutable;

public class Main {
    /**
     * immutable objects - Objects whose contents cannot be changed - created from immutable classes
     */
    public static void main(String[] args) {
        //A value no longer reference is removed by grabage collecter
        //new reference is created.
        String str = "Old value";
        str = "New value";
    }
}
