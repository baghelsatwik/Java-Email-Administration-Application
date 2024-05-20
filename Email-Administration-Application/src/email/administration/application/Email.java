package email.administration.application;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int defaultPasswordLength = 8;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "anyCompany.com";
    
    //Constructor to receive the first and last Name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
 
        // call a method asking for the deparment - return the department
        this.department = setDepartment();

        //Call a methods that return a Password
        this.password = randomPassword(defaultPasswordLength);
        
        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("EMAIL CREATED: " + email);
        System.out.println("PASSWORD: " + this.password);
    }
    //Ask for the department
    private String setDepartment(){
        System.out.print("DEPARTMENT Codes: \n1 \t- for Sale\n2 \t- for Development\n3 \t- for Accounting\n4 \t- for none\nEnter Department Codes: ");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        sc.close();
        String dep = switch (depChoice) {
            case 1 -> "Sales";
            case 2 -> "Developement";
            case 3 -> "Accounting";
            default -> "";
        };
        
        return dep;
    } 
    //Generate a random Password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTWXYZ1234567890!@#$%&*";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int random = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }
    //get/set the mailbox Capacity
    public int getMailboxCapacity(){
        System.out.print("MAILBOX CAPACITY CHANGE TO: ");
        return mailboxCapacity;
    }
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    
    //get/set the alternate Email
    public String getAlternateEmail(){
        System.out.print("ALTERNATE EMAIL: ");
        return alternateEmail;
    }
    public void setALternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //get/set password
    public String getPassword(){
        System.out.print("PASSWORD CHANGED TO: ");
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + 
                "\nCOMPANY EMAIL: " + email + 
                "\nDEPARTMENT: " + department + 
                "\nMAILBOX CAPAPCITY: " + mailboxCapacity + "mb";
               
    }
    
    
}
