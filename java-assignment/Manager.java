import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class Manager {
    private JFrame frame;
    private JList<String> companyList;
    private JTextArea companyDetails;
    private JTextArea highestAvgSharePriceCompany;
    private JComboBox<String> sortMethod;
    private JComboBox<String> filterMethod;
    private JTextField companyIdField;
    private JTextField sharePriceField;
    private List<Company> companies;
    private CompanyList Companies;
    public void run() {
        Companies.readFile("Input.csv");

        // Create a list of companies
        List<Company> companies = new ArrayList<>();
        // Add companies to the list

        // Create an instance of Manager
        Manager manager = new Manager(companies);
    }

    public static void main(String[] args) {
        // Create and run the Manager
        Manager manager = new Manager();
        manager.run();
    }
    public Manager(List<Company> companies) {




        frame = new JFrame("Company Report");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        // Panel 1: List of companies
        companyList = new JList<>(companies.stream().map(Company::getCompName).toArray(String[]::new));
        companyList.addListSelectionListener(e -> updateCompanyDetails(companies.get(companyList.getSelectedIndex())));
        frame.add(new JScrollPane(companyList));

        // Panel 2: Company details
        companyDetails = new JTextArea();
        frame.add(new JScrollPane(companyDetails));

        // Panel 3: Highest average share price company
        highestAvgSharePriceCompany = new JTextArea();
        frame.add(new JScrollPane(highestAvgSharePriceCompany));

        // Panel 4: Controls
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(2, 2));
        sortMethod = new JComboBox<>(new String[] {"Sort Method 1", "Sort Method 2", "Sort Method 3"});
        sortMethod.addActionListener(e -> sortCompanies(companies, sortMethod.getSelectedIndex()));
        controls.add(sortMethod);
        filterMethod = new JComboBox<>(new String[] {"Filter Method 1", "Filter Method 2", "Filter Method 3"});
        filterMethod.addActionListener(e -> filterCompanies(companies, filterMethod.getSelectedIndex()));
        controls.add(filterMethod);
        companyIdField = new JTextField();
        controls.add(companyIdField);
        JButton viewButton = new JButton("View Company");
        viewButton.addActionListener(e -> viewCompany(companies, Integer.parseInt(companyIdField.getText())));
        controls.add(viewButton);
        sharePriceField = new JTextField();
        controls.add(sharePriceField);
        JButton updateButton = new JButton("Update Share Price");
        updateButton.addActionListener(e -> updateSharePrice(companies, companyList.getSelectedIndex(), Double.parseDouble(sharePriceField.getText())));
        controls.add(updateButton);
        frame.add(controls);

        updateHighestAvgSharePriceCompany(companies);

        frame.pack();
        frame.setVisible(true);
    }
   

    public List<Company> sortCompanies(List<Company> companies, int sortMethod) {
        List<Company> sortedCompanies = new ArrayList<>(companies);
        switch (sortMethod) {
            case 1: // Sort by name
                sortedCompanies.sort(Comparator.comparing(company -> company.getCompName()));
                break;
            case 2: // Sort by ranking
                sortedCompanies.sort(Comparator.comparingInt(Company::getRanking));
                break;
        }
        return sortedCompanies;
    }

    public List<Company> filterCompanies(List<Company> companies, int filterMethod) {
        List<Company> filteredCompanies = new ArrayList<>();
        switch (filterMethod) {
            case 1: // Filter by specific product or service
                String productOrService = "Product1"; // Replace with actual product or service
                filteredCompanies = companies.stream()
                        .filter(company -> Arrays.asList(company.getProductsAndServices()).contains(productOrService))
                        .collect(Collectors.toList());
                break;
            case 2: // Filter by ranking range
                int minRanking = 10; 
                int maxRanking = 20; 
                filteredCompanies = companies.stream()
                        .filter(company -> company.getRanking() >= minRanking && company.getRanking() <= maxRanking)
                        .collect(Collectors.toList());
                break;
        }
        return filteredCompanies;
    }
    public Company viewCompany(List<Company> companies, int companyNo) {
        for (Company company : companies) {
            if (company.getCompanyNo() == companyNo) {
                return company;
            }
        }
        return null;
    }
    public Company updateHighestAvgSharePriceCompany(List<Company> companies) {
        Company highestAvgSharePriceCompany = null;
        double highestAvgSharePrice = 0;
    
        for (Company company : companies) {
            double avgSharePrice = Arrays.stream(company.getSharePrice()).average().orElse(0);
            if (avgSharePrice > highestAvgSharePrice) {
                highestAvgSharePrice = avgSharePrice;
                highestAvgSharePriceCompany = company;
            }
        }
    
        return highestAvgSharePriceCompany;
    }
    public void updateSharePrice(List<Company> companies, int companyIndex, double newSharePrice) {
        if (companyIndex >= 0 && companyIndex < companies.size()) {
            Company company = companies.get(companyIndex);
            double[] sharePrices = company.getSharePrice();
            // Shift the share prices to the left and add the new share price at the end
            System.arraycopy(sharePrices, 1, sharePrices, 0, sharePrices.length - 1);
            sharePrices[sharePrices.length - 1] = newSharePrice;
            company.setSharePrice(sharePrices);
        }
        refreshGUI();
    }
    public void updateCompanyDetails(Company updatedCompany) {
        for (Company company : companies) {
            if (company.getCompanyNo() == updatedCompany.getCompanyNo()) {
                // Update the details of the company
                company.setCompName(updatedCompany.getCompName());
                company.setRanking(updatedCompany.getRanking());
                company.setSharePrice(updatedCompany.getSharePrice());
                company.setProductsAndServices(updatedCompany.getProductsAndServices());
                company.setHeadQuarters(updatedCompany.getHeadQuarters());
                break;
            }
        }
        refreshGUI();
    }
    public void refreshGUI() {
        // Update the companyList
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Company company : companies) {
            model.addElement(company.getCompName());
        }
        companyList.setModel(model);
    
        // Update the highestAvgSharePriceCompany
        updateHighestAvgSharePriceCompany(companies);
    }
}
