package dowhileloop;

public class Main {
    /**
     * do while loop - executes a block of code at least once, then repeats the loop as long as a condition is true
     */
    public static void main(String[] args) {
        //example
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);
        //advanced example
        int j = 1;
        do {
            System.out.println(j);
            if (j == 5) {
                break;
            }
            j++;
        } while (j <= 10);//output: 1 2 3 4 5
    }
}
