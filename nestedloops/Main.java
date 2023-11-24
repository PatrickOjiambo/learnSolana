package nestedloops;

public class Main {
    /**
     * nested loops - a loop inside a loop
     */
    public static void main(String[] args) {
        //example
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop iteration " + i);
            for (int j = 1; j <= 3; j++) {
                System.out.println("i = " + i + "; j = " + j);
            }
        }
        //output:
        //Outer loop iteration 1
        //i = 1; j = 1
        //i = 1; j = 2
        //i = 1; j = 3
        //Outer loop iteration 2
        //i = 2; j = 1
        //i = 2; j = 2
        //i = 2; j = 3
        //Outer loop iteration 3
        //i = 3; j = 1
        //i = 3; j = 2
        //i = 3; j = 3
        //advanced example
        for (int i = 1; i <= 3; i++) {
            System.out.println("Outer loop iteration " + i);
            for (int j = 1; j <= 3; j++) {
                System.out.println("i = " + i + "; j = " + j);
                if (j == 2) {
                    break;
                }
            }
        }
        //output:
        //Outer loop iteration 1
        //i = 1; j = 1
        //i = 1; j = 2
        //Outer loop iteration 2
        //i = 2; j = 1
        //i = 2; j = 2
        //Outer loop iteration 3
        //i = 3; j = 1
        //i = 3; j = 2
        //Note: the break statement only breaks out of the inner loop
    }
}
