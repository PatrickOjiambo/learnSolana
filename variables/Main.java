package variables;

public class Main {
    public static void main(String[] args) {
        /**
         * variables - Used to store values in memory - has a type, value can change hence variable, each has a unique name, do not redefine.
         * declaration - allocating space in memory, we allocate space by declaring a variable
         * assignment - store a value in a variable = ->assignment operator
         * initialization - assigning a value during declaration (assignment + declaration)
         */
        //declare varr
        String myName;
        //assignment
        myName = "Pash";
        //initialization
        String variableName = "An expression";
        //Always initialize a variable
        System.out.println(myName);
        System.out.println(variableName);
    }
}
