import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CompanyReport {
    public static void generateReport(List<Company> companies) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("CompanyReport.txt"));

            // Write short details of all companies
            for (Company company : companies) {
                writer.write(company.getShortDetails());
                writer.newLine();
            }

            // Find company with highest share price average
            Company highestAvgSharePriceCompany = companies.get(0);
            for (Company company : companies) {
                if (company.getAverageSharePrice() > highestAvgSharePriceCompany.getAverageSharePrice()) {
                    highestAvgSharePriceCompany = company;
                }
            }

            // Write details of company with highest share price average
            writer.write("Company with highest average share price: ");
            writer.newLine();
            writer.write(highestAvgSharePriceCompany.getShortDetails());

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This will create a text file named "CompanyReport.txt" in your project directory. 
     * The file will contain the short details of all companies and the details of the
     *  company with the highest average share price.
     * List<Company> companies = // your list of companies
     * CompanyReport.generateReport(companies);
     */
}