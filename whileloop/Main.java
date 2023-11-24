package whileloop;

public class Main {
    /**
     * Loops are used to execute a set of statements repeatedly until a particular condition is satisfied
     * While loop - executes a block of code as long as a condition is true
     * You can use break to exit a while loop
     */
    public static void main(String[] args) {
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
        //breaking out of a while loop 
        int j = 1;
        while (j <= 10) {
            System.out.println(j);
            if (j == 5) {
                break;
            }
            j++;
        }//output: 1 2 3 4 5
        //Continue statement
        int k = 1;
        while (k <= 10) {
            if (k == 5) {
                k++;
                continue;
            }
            System.out.println(k);
            k++;
        }//output: 1 2 3 4 6 7 8 9 10
        //Note break stops a loop and exits the loop, continue stops the current iteration and continues with the next iteration
    }
}
