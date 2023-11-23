package scannerclassinjava;

import java.util.Scanner;

public class Main {
    /**
     * Scanner class -
     * System.in ponts to the keyboard
     * in - field of the keySystem - it is static
     * Input methods - methods used to read specific types of data from the keyboard
     * 
     */
    public static void main(String[] args) {
        // create an object/variable of type scanner
        Scanner input = new Scanner(System.in);
        //Program will pause for the user to enter some text.
        System.out.println(input.nextInt());
        input.nextInt();
        input.next();
        input.nextBoolean();
        input.nextByte();
        input.nextLine();
    }
}
