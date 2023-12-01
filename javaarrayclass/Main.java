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
    }
}
