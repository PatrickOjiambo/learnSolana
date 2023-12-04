import javax.swing.JOptionPane;
/**
 * The CompanyManager class manages a list of companies and provides methods for user interaction and company operations.
 */
public class CompanyManager {
    /**
     * Instance variable for storing the list of companies.
     */
    private CompanyList Companies;
    
    /**
     * Initializes the CompanyManager with an empty CompanyList.
     */
    public CompanyManager() {
        Companies = new CompanyList();
    }
    private String securityPassword; // Store the securityPassword here
/**
* Initializes the CompanyManager with a security password.
*
* @param pwd The security password for accessing manager functions.
*/
    public CompanyManager(String pwd) {
        this.securityPassword = pwd;
    }
/**
* Checks if the input password matches the security password.
*
* @param inputPwd The input password to be checked.
* @return true if the input password matches the security password, false otherwise.
*/
    public boolean checkPassword(String inputPwd) {
        return securityPassword.equals(inputPwd);
    }
    
/**
 * Reads company data from a CSV file, displays the list of companies,
 * and allows the user to search for a specific company by its number.
 * Displays short details of the specific company in a dialog box and
 * full details in the console.
 */
    public void run() {
    // Load company data
    Companies.readFile("Input.csv");

    System.out.println("\n\n Share Price Report \n\n");

    // Print the list of all companies
    System.out.println(Companies.getAllDetails());

    // Try out the search, give 5 tries
    boolean okay = false;
    int count = 0;

    while (!okay && count < 5) {
        String input = JOptionPane.showInputDialog(null, "Company Number");
        
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Company Number.");
            continue; // Skip current iteration and input again.
        }
/**
 * Adds a new company to the list.
 *
 * @param company The company to be added.
 */
        int companyNo;
        try {
            companyNo = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "invalid!!... please try again");
            continue; // Skip current iteration and input again.
        }

        Company company = Companies.findById(companyNo);

        count++;

        if (company != null) {
            String shortDetails = "Company " + company.getCompName() + " headquartered at " + company.getHeadQuarters() + " has average share price of " + String.format("%.2f", company.getAverageSharePrice());
            JOptionPane.showMessageDialog(null, "Short Details for " + companyNo + ":\n" + shortDetails);

            System.out.println("Short Details for " + companyNo);
            System.out.println(shortDetails);

            String fullDetails = company.getFullDetails(company);
            System.out.println("Full Details for " + companyNo);
            System.out.println(fullDetails);

            okay = true;
        } else {
            JOptionPane.showMessageDialog(null, "Company not found for Company Number " + companyNo);
            if (count < 5) {
                JOptionPane.showMessageDialog(null, "Try once again");
            }
        }
    }
}

    // Add more methods to perform various operations on the list of companies.
}
