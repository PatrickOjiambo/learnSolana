import java.util.Arrays;

/**
 * Main company class(Superclass)
 */
public abstract class Company {
    /**
     * Company number – must be an integer.
     */
    private int companyNo;

    /**
     * Company name – use the Name class (from the lectures).
     */
    private Name compName;

    /**
     * Current ranking in the chosen stock exchange – 1 for top of the list and 100
     * for the bottom of the list.
     */
    int ranking;

    /**
     * Share Price for last five days.
     */
    protected double[] sharePrice;

    /**
     * Company Product or Service – between 2 and 5 values which describe the
     * product or service,
     * that the company generates.
     */
    private String[] productsAndServices;
    private String type;//Retail, manufacturing or technology
    /**
     * An Extra attribute - headQuarters.
     */
    private String headQuarters;

    /**
     * Constructs a Company object with the specified parameters.
     *
     * @param number             The company number.
     * @param name               The company name.
     * @param sharePriceData     An array of share prices for the last five days.
     * @param ranking            The current ranking of the company in the stock
     *                           exchange.
     * @param productsOrServices An array of strings representing the products or
     *                           services offered by the company.
     * @param hq                 The headquarters of the company.
     */
    public Company(int number, Name name, double[] sharePriceData, int ranking, String[] productsOrServices, String hq, String type)// constructor
                                                                                                                       // implementation
    {
        this.companyNo = number;
        this.compName = name;
        this.type = type;
        this.sharePrice = sharePriceData;
        this.ranking = ranking;
        this.productsAndServices = productsOrServices;
        this.headQuarters = hq; // Initialize headQuarters
    }

    // Getters for the instance variables
    public int getCompanyNo() {
        return companyNo;
    }

    public Name getCompName() {
        return compName;
    }

    public int getRanking() {
        return ranking;
    }

    public double[] getSharePrice() {
        return sharePrice;
    }

    public String[] getProductsAndServices() {
        return productsAndServices;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    // Setters for the instance variables

    public void setCompanyNo(int companyNo) {
        this.companyNo = companyNo;
    }

    public void setCompName(Name compName) {
        this.compName = compName;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public void setSharePrice(double[] sharePrice) {
        this.sharePrice = sharePrice;
    }

    public void setProductsAndServices(String[] productsAndServices) {
        this.productsAndServices = productsAndServices;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    /**
     * Generates and returns a detailed string representation of the company.
     *
     * @param company The company for which the details are generated.
     * @return A string containing the complete details of the company.
     */
    public String getFullDetails(Company company) {
        StringBuilder details = new StringBuilder();
        details.append("Company Number: ").append(String.format("%03d", company.getCompanyNo())).append(", name ")
                .append(company.getCompName().getFullName()).append(".\n");
        details.append("Ranking: ").append(company.getRanking()).append("\n");
        details.append("Product or Service: ").append(String.join(", ", company.getProductsAndServices())).append("\n");
        details.append("Share Price Data:\n");
        details.append("Over the past five days the share price has been: ");
        for (int i = 0; i < company.getSharePrice().length; i++) {
            details.append(company.getSharePrice()[i]);
            if (i < company.getSharePrice().length - 1) {
                details.append(", ");
            }
        }
        details.append("\nAverage share price is of ").append(String.format("%.2f", company.getAverageSharePrice()));
        return details.toString();
    }
    /**
 * Generates and returns a short string representation of the company.
 *
 * @return A string containing the short details of the company.
 */
public String getShortDetails() {
    return "CN " + String.format("%03d", companyNo) + " (" + headQuarters + ") has an average share price of " + String.format("%.2f", getAverageSharePrice());
}
  
public abstract double getAverageSharePrice();
//Display the company type
public abstract void companyType();


}