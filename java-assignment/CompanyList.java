import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * The CompanyList class represents a list of companies and provides methods for managing and processing company data.
 */
public class CompanyList {
/**
     * ArrayList to store the list of companies.
     */

	private ArrayList<Company> CompanyList;
/**
     * Creates an empty CompanyList.
     */	

	public CompanyList() {
		CompanyList = new ArrayList<Company> ();
	}
/**
     * Adds a company to the list.
     *
     * @param cm The company to be added.
     */	
	public void add(Company cm) {
		CompanyList.add(cm);
	}
 /**
     * Returns the number of companies in the list.
     *
     * @return The number of companies in the list.
     */
	public int getSize() {
		return CompanyList.size();
	}
	
/**
     * Returns the Company object at the specified index position in the list.
     *
     * @param index The index position.
     * @return The Company object at the specified index.
     */
	public Company getIndex(int index) {
		return CompanyList.get(index);
	}
	
/**
     * Finds a company by its company number and returns the corresponding Company object.
     *
     * @param id The company number to be searched.
     * @return The Company object with the specified company number, or null if not found.
     */
        public Company findById(int id) {
            for (Company company : CompanyList) {
                if (company.getCompanyNo() == id) {
                    return company;
                }
            }
            return null;
        }
    

	
/**
     * Finds the company with the highest share price across the past 5 days.
     *
     * @return The Company object with the highest share price.
     */
    public Company highestSharePrice() {
    Company highest = null;
    int max = 0;

    for (Company company : CompanyList) {
        int maxPrice = getMaximum(company);
        if (maxPrice > max) {
            max = maxPrice;
            highest = company;
        }
    }
    return highest;
}
/**
     * Generates a report containing details of all companies, including share prices and statistical information.
     *
     * @return A formatted report containing company details.
     */
    public String getAllDetails() {
    StringBuilder myReport = new StringBuilder();
    myReport.append("Number\tName\t\t\t\t\tFive-Day Share Price\n");

    // Find the cm with the highest share price
    Company highest = highestSharePrice();

    int maxLength = 0;
        for (Company cm : CompanyList) {
            int compNameLength = cm.getCompName().getFullName().length();
            if (compNameLength > maxLength) {
                maxLength = compNameLength;
            }
        }
    for (Company cm : CompanyList) {
        // update the myReport for each cM cm
        myReport.append(String.format("%03d", cm.getCompanyNo()));
        myReport.append("\t").append(String.format("%-" + maxLength + "s\t", cm.getCompName().getFullName()));

        myReport.append("\t");

        double[] sharePriceData = cm.getSharePrice();
        
        for (double price : sharePriceData) {
            myReport.append((int) price).append("\t");
        }

        myReport.append("\n");
    }

    myReport.append("\n"); 
    
    // Statistic information
    myReport.append("There are ").append(CompanyList.size()).append(" companies in total.\n");
    if (highest != null) {
        myReport.append("The company with the highest share price is")
                .append(highest.getCompName().getFullName())
                .append(" with a score of ").append(getMaximum(highest)).append(".\n");

        // Calculate the share price frequency and append it
        String freqReport = generateFreqReport(highest);
        myReport.append(freqReport);
    } else {
        myReport.append("No company found with the highest share price.\n");
    }

    return myReport.toString();
}
/**
     * Generates a frequency report showing how many times each individual share price was hit for a specific company.
     *
     * @param cm The company for which the frequency report is generated.
     * @return A formatted frequency report.
     */
	public String generateFreqReport(Company cm) 
        {
         StringBuilder freqReport = new StringBuilder();
//report.append("There are ").append(CompanyList.size()).append(" companies.\n");
           
        //To store frequency of each share price
        Map<Integer, Integer> Frequency = new HashMap<>();
        int maxSharePrice = 0;
        String companyWithHighestSharePrice = "";

        for (Company currentcompany : CompanyList) {
        double[] sharePrices = currentcompany.getSharePrice();
        for (double price : sharePrices) {
            int myPrice = (int) price; // Convert double to int
            Frequency.put(myPrice, Frequency.getOrDefault(myPrice, 0) + 1);

            if (myPrice > maxSharePrice) {
                maxSharePrice = myPrice;
                companyWithHighestSharePrice = cm.getCompName().getFullName();
            }
            }
        }

        return freqReport.toString();
    }
        
          
/**
     * Calculates the average share price based on the input array of share prices.
     *
     * @param sharePrice The array of share prices.
     * @return The average share price.
     */

private double getAverageSharePrice(double[] sharePrice) {
    int n = sharePrice.length;
    
    if (n == 0) {
        return 0.0; // Return 0 if there are no share prices
    }
    
    double totalSharePrice = 0.0;
    double average;
    
    // Sort the share prices array in ascending order
    Arrays.sort(sharePrice);
    
    // If the number of share prices is odd, take the middle value
    if (n % 2 != 0) {
        average = sharePrice[n / 2];
    } else {
        // If the number of share prices is even, take the average of the middle two values
        int middle1 = n / 2 - 1;
        int middle2 = n / 2;
        average = (sharePrice[middle1] + sharePrice[middle2]) / 2.0;
    }
    return Double.parseDouble(String.format("%.2f", average));
}
/**
     * Finds the minimum share price for a given company.
     *
     * @param company The company for which the minimum share price is found.
     * @return The minimum share price.
     */
    public int getMinimum(Company company) {
    double[] sharePrice = company.getSharePrice();
    int min = Integer.MAX_VALUE;

    for (double price : sharePrice) {
        if (price < min) {
            min = (int) price;
        }
    }

    return min;
}
/**
     * Finds the maximum share price for a given company.
     *
     * @param company The company for which the maximum share price is found.
     * @return The maximum share price.
     */
public int getMaximum(Company company) {
    double[] sharePriceData = company.getSharePrice();
    int maxPrice = Integer.MIN_VALUE;

    for (double price : sharePriceData) {
        if (price > maxPrice) {
            maxPrice = (int) price;
        }
    }

    return maxPrice;
}

/**
     * Calculates the mean share price for a given company.
     *
     * @param company The company for which the mean share price is calculated.
     * @return The mean share price.
     */
public double getMeanPrice(Company company) {
    double[] sharePriceData = company.getSharePrice();
    double total = 0.0;

    for (double price : sharePriceData) {
        total += price;
    }

    if (sharePriceData.length == 0) {
        return 0.0; // Handle division by zero
    }

    return total / sharePriceData.length;
}


/**
     * Writes the company data to a file.
     *
     * @param filename The name of the file to be written to.
     * @param highest  The company with the highest share price.
     */
public void writeToFile(String filename, Company highest) {
    try {
        FileWriter fw = new FileWriter(filename);

        // Find the maximum length of cm names
        int maxLength = 0;
        for (Company company : CompanyList) {
            int compNameLength = company.getCompName().getFullName().length();
            if (compNameLength > maxLength) {
                maxLength = compNameLength;
            }
        }

        // Write the CompanyName column header with adjusted width
        fw.write("Number\tCompany Name\t\t\t\tPast Five-Day Share Price\tOverall\tMaximum\tMinimum\tMean\tProducts\n");

        for (Company cM : CompanyList) {
            fw.write(String.format("%d\t", cM.getCompanyNo()));
            String companyName = cM.getCompName().getFullName();
            fw.write(String.format("%-" + maxLength + "s\t", companyName));

            double[] sharePriceData = cM.getSharePrice();

            // Past Five-Day Share Price
            for (double price : sharePriceData) {
                fw.write(String.format("%d\t", (int) price));
            }

            // Overall, Maximum, Minimum, Mean
            double averageSharePrice = getAverageSharePrice(sharePriceData);
            int minPrice = getMinimum(cM);
            int maxPrice = getMaximum(cM);
            double meanPrice = getMeanPrice(cM);

            fw.write(String.format("%.1f\t", averageSharePrice));
            fw.write(String.format("%d\t%d\t%.1f\t", maxPrice, minPrice, meanPrice));

            // Products
            String[] products = cM.getProductsAndServices();
            if (products.length > 0) {
                fw.write(products[0]);
                for (int i = 1; i < products.length; i++) {
                    fw.write(", " + products[i]);
                }
            }

            fw.write("\n");
        }

        // Check if highest is not null and generate the myReport only for it
        if (highest != null) {
            fw.write("\nSTATISTICAL\n");
            fw.write("There are " + CompanyList.size() + " companies.\n");
            fw.write("The company with the highest share price across the past 5 days was " +
                    highest.getCompName().getFullName() +
                    " with a score of " + getMaximum(highest) + ".\n");

            // Calculate the share price frequency and append it
            //String freqReport = generateFreqReport(highest);
            //fw.write(freqReport);
            // Call this method with the highest as an argument
            
            // Call printSharePriceAndFrequency with the highest as an argument
            printSharePriceAndFrequency(highest, fw);
       }
        fw.close();

    } catch (IOException ioe) {
        ioe.printStackTrace();
        System.exit(1);
    }
}
/**
     * Prints the share prices and their frequencies for a specific company to a FileWriter.
     *
     * @param highest The company for which share prices and frequencies are printed.
     * @param fw      The FileWriter object to write the data.
     */
    public void printSharePriceAndFrequency(Company highest, FileWriter fw) {
    if (highest != null) {
        try {
            fw.write("Share Price:     ");
            double[] sharePrice = highest.getSharePrice();
            Map<Integer, Integer> Frequency = new HashMap<>();

            for (double price : sharePrice) {
                int priceInt = (int) price;
                Frequency.put(priceInt, Frequency.getOrDefault(priceInt, 0) + 1);
            }

            boolean firstEntry = true;
            for (Map.Entry<Integer, Integer> entry : Frequency.entrySet()) {
                if (!firstEntry) {
                    fw.write(" \t");
                }
                fw.write(entry.getKey() + "");
                firstEntry = false;
            }
            
            fw.write("\nFrequency:       ");
            firstEntry = true;
            for (Map.Entry<Integer, Integer> entry : Frequency.entrySet()) {
                if (!firstEntry) {
                    fw.write(" ");
                }
                fw.write(entry.getValue() + "\t");
                firstEntry = false;
            }

            fw.write("\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
/**
     * Reads data from a file, extracts company data, and creates Company objects.
     *
     * @param filename The name of the input file.
     */
public void readFile(String filename) {
    try {
        File f = new File(filename);
        Scanner scanner = new Scanner(f);

        // Skip the first line (header)
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }

        while (scanner.hasNextLine()) {
            // Read and process the data lines
            String inputLine = scanner.nextLine();
            if (inputLine.length() != 0) {
                processLine(inputLine);
            }
        }

        scanner.close(); // Close the scanner when done
    } catch (FileNotFoundException fnf) {
        System.out.println(filename + " not found ");
        System.exit(0);
    }
}
     
/**
     * Processes a line of data, extracts company data, and creates a Company object.
     *
     * @param line The line of data to be processed.
     */
	private void processLine(String line) {
    try {
        String[] parts = line.split(",");
        if (parts.length >= 10) {
            int companyNo = Integer.parseInt(parts[0]);
            String fullName = parts[1];
            
            String headQuarters = parts[2];
            // Process and split the share price data
          
            double Day1 = Double.parseDouble(parts[3]);
            double Day2 = Double.parseDouble(parts[4]);
            double Day3 = Double.parseDouble(parts[5]);
            double Day4 = Double.parseDouble(parts[6]);
            double Day5 = Double.parseDouble(parts[7]);
                
            double[] sharePrice = {Day1, Day2, Day3, Day4, Day5};
            
            int ranking = Integer.parseInt(parts[8]);

            String[] productsAndServices = parts[9].split(",");

            // Split the full name into first name, middle name, and last name
            String[] nameParts = fullName.split(" ");
            String firstName = "";
            String middleName = "";
            String lastName = "";

            if (nameParts.length >= 1) {
                firstName = nameParts[0];
            }
            if (nameParts.length >= 2) {
                middleName = nameParts[1];
            }
            if (nameParts.length >= 3) {
                lastName = nameParts[2];
            }

            // Create a Company object and add it to the list
            Name cN = new Name(firstName, middleName, lastName);
            
            Company company = new Company(companyNo, cN, sharePrice, ranking, productsAndServices, headQuarters);
            CompanyList.add(company);
        } else {
            System.out.println("Incomplete data in line: " + line);
        }
    } catch (NumberFormatException nfe) {
        System.out.println("Number conversion error in '" + line + "' - " + nfe.getMessage());
    } catch (ArrayIndexOutOfBoundsException air) {
        System.out.println("Not enough items in: '" + line + "' index position: " + air.getMessage());
    }
}


}


