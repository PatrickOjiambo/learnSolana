package relationallogicalconditional;

public class Main {
    /**
     * relational operators - compare two values and return a boolean value(make comparisons)
     * == ->equality operator
     * != ->not equal to operator
     * > ->greater than operator
     * < ->less than operator>
     * >= ->greater than or equal to operator
     * <= ->less than or equal to operator
     * logical operators - combine two or more relational expressions and return a boolean value
     * && ->and operator
     * || ->or operator
     * ! ->not operator
     * conditional operators - An operator that evaluates an expression based purely on the condition of the expression
     */
    public static void main(String[] args) {
        //condional operator
        //boolean expression ? value if true : value if false
        //Above also called ternary operator
        int x = 10;
        int y = 20;
        int z = x > y ? x : y;
        System.out.println(z);//output is 20
    }
}
