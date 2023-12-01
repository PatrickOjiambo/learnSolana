package javaarrayclass;

public class Main {
    public static void main(String[] args) {
        //sorting arrays.
        int[] numbers = {1,2,3,4,5};
        java.util.Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
        //seaching arrays.
        int[] numbers2 = {1,2,3,4,5};
        int index = java.util.Arrays.binarySearch(numbers2, 3);
        System.out.println(index);
        //The arrays should be sorted before searching.

        //Comparing arrays.
        int numbers3[] = {1,2,3,4,5};
        int numbers4[] = {1,2,3,4,5};
        System.out.println(java.util.Arrays.equals(numbers3, numbers4));
        //filling arrays.
        int[] numbers5 = new int[10];
        java.util.Arrays.fill(numbers5, 1);
        //output = {1,1,1,1,1,1,1,1,1,1}
        for (int i = 0; i < numbers5.length; i++) {
            System.out.println(numbers5[i] + " ");
        }
        //Creating empty arrays.
        int[] numbers6 = new int[10];
    
        

    }
}
