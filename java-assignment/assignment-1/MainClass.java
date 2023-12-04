 import javax.swing.JOptionPane;
import javax.swing.*;
public class MainClass {
 
 
	public static void main(String[] args) {
            
    //get password from the user        
    JPasswordField pwdField = new JPasswordField();
    
    //To get the input from the user
    int choice = JOptionPane.showConfirmDialog(null, pwdField, "Enter the password:", JOptionPane.OK_CANCEL_OPTION);
 
    if (choice == JOptionPane.OK_OPTION) {
        char[] pwdChar = pwdField.getPassword();
        String inputPwd = new String(pwdChar);
 
        CompanyManager Mgr = new CompanyManager("password"); 
        
        //To check the password
        boolean isPassword = Mgr.checkPassword(inputPwd);
 
        if (isPassword) {
            JOptionPane.showMessageDialog(null, "Password is correct. Access granted.");
            // Create the allCompanies object here
            CompanyList allCompanies = new CompanyList(); 
            CompanyManager cMgr = new CompanyManager();
            allCompanies.readFile("Input.csv");
            Company highest = allCompanies.highestSharePrice();
 
            // Generate the main report
            String myReport = allCompanies.getAllDetails();

            cMgr.run();
            // Close the program when done
            // Write the report to the output file
            allCompanies.writeToFile("FTSE100Output.txt", highest);
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect password. Access denied.");
            // Close the program when the password is incorrect
            System.exit(0);
        }
    }
}
}