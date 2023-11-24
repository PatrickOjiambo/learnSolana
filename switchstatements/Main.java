package switchstatements;

public class Main {
    /**
     * switch statement - selects one of many blocks of code to be executed
     * --used to execute different cases based on equality with a variable
     * break statement - used to terminate a switch statement
     * If you omit break, the next case will be executed
     * 
     */
    //example
    public static void main(String[] args) {
        int x = 10;
        switch (x) {
            case 10:
                System.out.println("x is 10");
                break;
            case 20:
                System.out.println("x is 20");
                break;
            default:
                System.out.println("x is not 10 or 20");
        }
        //output: x is 10
    }
}
