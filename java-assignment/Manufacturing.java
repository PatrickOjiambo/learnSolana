import java.util.*;

/**
 * Company B is a company that is a subclass of Company.
 */
public class Manufacturing {

    private int productsManufactured;
    private double averageProductionCost;
    private String factoryLocation;
public Manufacturing(int companyNo, Name compName, double[] sharePrice, int ranking, String[] productsAndServices,
            String headQuarters, int productsManufactured, double averageProductionCost, String factoryLocation) {
        super(companyNo, compName, sharePrice, ranking, productsAndServices, headQuarters);
        this.productsManufactured = productsManufactured;
        this.averageProductionCost = averageProductionCost;
        this.factoryLocation = factoryLocation;
    }
    public int getProductsManufactured() {
        return productsManufactured;
    }

    public void setProductsManufactured(int productsManufactured) {
        this.productsManufactured = productsManufactured;
    }

    public double getAverageProductionCost() {
        return averageProductionCost;
    }

    public void setAverageProductionCost(double averageProductionCost) {
        this.averageProductionCost = averageProductionCost;
    }

    public String getFactoryLocation() {
        return factoryLocation;
    }

    public void setFactoryLocation(String factoryLocation) {
        this.factoryLocation = factoryLocation;
    }

    public double calculateProductionCost() {
        return productsManufactured * averageProductionCost;
    }

    public void displayFactoryLocation() {
        System.out.println("The factory is located in " + factoryLocation);
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
        System.out.println("This company manufactures products.");
    }

}
