package scopeandlocalvariables;

public class Main {
    /**
     * scope - part of the program where the variable is accessible
     * local variable - variable declared inside a method
     */
    public static void main(String[] args) {
        
        //example
        int x = 5;
        System.out.println(x);
        
        //advanced example
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        //System.out.println(i); //i is not accessible here
    }
}
