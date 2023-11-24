package forloop;

public class Main {
    /**
     * for loop - executes a block of code a limited amount of times
     */
    public static void main(String[] args) {
        //example
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }
        //advanced example
        for (int j = 1; j <= 10; j++) {
            System.out.println(j);
            if (j == 5) {
                break;
            }
        }//output: 1 2 3 4 5
         }     //Note break stops a loop and exits the loop, continue stops the current iteration and continues with the next iteration
}
