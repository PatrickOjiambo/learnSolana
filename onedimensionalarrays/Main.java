package onedimensionalarrays;

public class Main {
    /**
     * null values are values that have not been initialized.
     * e.g String s; s is null.
     * s = "Hello"; s is not null.
     * Arrays - a collection of variables of the same data type. - fixed size. - an array in java is an object. - arrays are indexed from 0. - arrays are initialized to null. - arrays are initialized to 0.0. - arrays are initialized to false. - arrays are initialized to '\u0000'. - arrays are initialized to 0.
     */
    public static void main(String[] args) {
        int[] arrayname; // declare an array of integers.
        arrayname = new int[10]; // create an array of integers with a size of 10.    }
        //Accessing elements of an array.
        arrayname[0] = 1; // set the first element of the array to 1.
        arrayname[2] = 2; // set the second element of the array to 2.
        //Array initializers
        double[] numbers={1.0,2.0,3.0,4.0,5.0}; // create an array of doubles with the values 1.0,2.0,3.0,4.0,5.0.
        //Printing arrays
        System.out.println(numbers); // prints the memory address of the array.
        //using for loops to print arrays.
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
}
}