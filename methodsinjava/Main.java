package methodsinjava;

public class Main {
    /**
     * void method - doesn't return anything - can be accessed outside of the class
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");

        // Calling a method
        printHelloWorld();
        printHelloWorld();
        printHelloWorld();
        sum(9,5); 
    }
    public static void printHelloWorld() {
        
    }
    /**
     * Value returning method - returns a value - can be accessed outside of the class
     */
     public static int sum(int x, int y) {
        return x + y;
     }

}
