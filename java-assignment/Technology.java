import java.util.*;

/**
 * Company C is a company that is a subclass of Company.
 */
public class Technology extends Company {

    private String[] programmingLanguagesUsed;

    public Technology(int companyNo, Name compName, double[] sharePrice, int ranking, String[] productsAndServices,
            String headQuarters, String[] programmingLanguagesUsed) {
        super(companyNo, compName, sharePrice, ranking, productsAndServices, headQuarters);
        this.programmingLanguagesUsed = programmingLanguagesUsed;
    }

    public void developSoftware() {
        // Implementation of software development
        System.out.println("This company develops software.");
    }

    // Getter and Setter for programmingLanguagesUsed
    public String[] getProgrammingLanguagesUsed() {
        return programmingLanguagesUsed;
    }

    public void setProgrammingLanguagesUsed(String[] programmingLanguagesUsed) {
        this.programmingLanguagesUsed = programmingLanguagesUsed;
    }

    /*
     * The getAverageSharePrice method calculates the average share price based on
     * the input array sharePrice.
     * First, it checks if the array is empty; if so, it returns 0.0. Next, it sorts
     * the array in ascending order using Arrays.sort(sharePrice).
     * If the number of share prices is odd, it directly returns the middle value.
     * If the number of share prices is even, it calculates the average of the two
     * middle values.
     * This method ensures that the average share price is determined by the middle
     * value (or average of middle two values for even-sized arrays) after sorting
     * the share prices in ascending order.
     */
    // method implementation
    public double getAverageSharePrice() {
        double[] sharePrice = getSharePrice(); // Access the sharePrice field using the getter method

        int n = sharePrice.length;

        if (n == 0) {
            return 0.0; // Return 0 if there are no share prices
        }

        // Sort the share prices array in ascending order
        Arrays.sort(sharePrice);

        // If the number of share prices is odd, take the middle value
        if (n % 2 != 0) {
            return sharePrice[n / 2];
        } else {
            // If the number of share prices is even, take the average of the middle two
            // values
            int middle1 = n / 2 - 1;
            int middle2 = n / 2;
            return (sharePrice[middle1] + sharePrice[middle2]) / 2.0;
        }
    }
    public void companyType() {
        System.out.println("This company develops software.");
    }

}
