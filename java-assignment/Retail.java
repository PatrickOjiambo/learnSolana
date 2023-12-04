import java.util.*;
import java.util.Arrays;

/**
 * Retail is a company that is a subclass of Company.
 */
public class Retail extends Company {
    private int productsSold;
    private double averageSales;
    private String storeLocation;

    public Retail(int companyNo, Name compName, double[] sharePrice, int ranking, String[] productsAndServices,
            String headQuarters, int productsSold, double averageSales, String storeLocation) {
        super(companyNo, compName, sharePrice, ranking, productsAndServices, headQuarters);
        this.productsSold = productsSold;
        this.averageSales = averageSales;
        this.storeLocation = storeLocation;
    }

    // Getters and setters for the instance variables
    public int getProductsSold() {
        return productsSold;
    }

    public void setProductsSold(int productsSold) {
        this.productsSold = productsSold;
    }

    public double getAverageSales() {
        return averageSales;
    }

    public void setAverageSales(double averageSales) {
        this.averageSales = averageSales;
    }

    public String getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(String storeLocation) {
        this.storeLocation = storeLocation;
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

    public double calculateProfit() {
        return averageSales - getAverageSharePrice();
    }

    public void displayStoreLocation() {
        System.out.println("The store is located at " + storeLocation);
    }
    public void companyType() {
        System.out.println("This company is a retail company.");
    }
}
