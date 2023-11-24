package ifstatements;

public class Main {
    /**
     * if statement - executes a block of code if a specified condition is true
     */
    //if statement
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        if (x > y) {
            System.out.println("x is greater than y");
        }
        //if else statement
        if (x > y) {
            System.out.println("x is greater than y");
        } else {
            System.out.println("x is less than y");
        }
        //if else if statement
        if (x > y) {
            System.out.println("x is greater than y");
        } else if (x < y) {
            System.out.println("x is less than y");
        } else {
            System.out.println("x is equal to y");
        }
        //nested if statement
        if (x > y) {
            System.out.println("x is greater than y");
        } else {
            if (x < y) {
                System.out.println("x is less than y");
            } else {
                System.out.println("x is equal to y");
            }
        }
    }
}
