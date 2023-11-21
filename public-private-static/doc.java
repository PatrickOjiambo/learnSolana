//Public class modifier
//Specify how to access classes, methods, and fields
//Class is accessed everywhere  - inside and outside classes and packages

//private access modifier
//Access level only inside the class
//You can access fields/methods using the class name
//Example
//System.out
//out is a static field of System hence can be accessed using the class name.

//static allows us to call the methods using the class name
public class doc{
    public static void main(String[] args) {
        sayHi();
    }
    public static void sayHi() {
        System.out.println("Pash");
    }
}