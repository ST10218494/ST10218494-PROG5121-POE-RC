import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Task {

    private String Name_;
    private String Surname_;
    private String Username_Registration;
    private String Password_Registration;
    private String Username_Login;
    private String Password_Login;
    boolean flag;
    boolean flag1;
    boolean flag2;
    String regex =  "^(?=.*[0-9]) (?=.*[a-z])(?=.*[A-Z]) (?=.*[@#$%^&+=]) (?=\\S+$).{8,20}$";
    private final Pattern pattern = Pattern.compile(regex);

    Scanner scan = new Scanner(System.in);

    public String getName_() {
        return Name_;
    }
    public void setName_(String name) {
        this.Name_ = Name_;
    }
    
    public String getSurname_() {
        return Surname_;
    }
    public void setSurname_(String surname) {
        this.Surname_ = Surname_;
    }

    public String getUsername_Registration() {
        return Username_Registration;
    }
    public void setUsername_Registration(String Username_Registration) {
        this.Username_Registration = Username_Registration;
    }
    public String getPassword_Registration() {
        return Password_Registration;
    }
    public void setPassword_Registration(String Password_Registration) {
        this.Password_Registration = Password_Registration;
    }
    public String getUsername_Login() {
        return Username_Login;
    }
    public void setUsername_Login(String Username_Login) {
        this.Password_Registration = Password_Registration;
    }
    public String getPassword_Login() {
        return Password_Login;
    }
    public void setPassword_Login(String Password_Login) {
        this.Password_Login = Password_Login;
    }

//method #1
    public boolean checkUserName(String Username_Registration) {
        
        flag = (Username_Registration.contains("_")) && (Username_Registration.length() < 6);

        return flag;
    }
//end of checkUserName()

//method #2
    public boolean checkPasswordComplexity(String Password_Registration) {
    
        Matcher matcher = pattern.matcher(Password_Registration);
        
        flag1 = matcher.matches();

        return flag1;
    }
//end of checkPasswordComplexity()

//method3
    public void registerUser() {
        label_1: {
            while (Password_Registration != null) {
                break label_1;
            }

            if (Username_Registration != null) {
                //Username portion
                while (!checkUserName("Username is notl correctly formatted, " + "please ensure that your username contains an underscore abd is no more than 5 characters in length."));
                System.out.println("Please enter a username that meets these condition >> ");
                Username_Registration = scan.next();
            }
            //endwhile

            if (checkUserName(Username_Registration)) {
                System.out.println("Username successfully captured.");
            }
        }
    

    if (Password_Registration == null) {
        return;
    }

    //Password Portion
    Matcher matcher = pattern.matcher(Password_Registration);

    while (!checkPasswordComplexity(Password_Registration)) {
        System.out.println("Psssword us not correctly formatted, " + "please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        System.out.print("Please enter a password thats meets these conditions >> ");
        Password_Registration = scan.next();
        matcher = pattern.matcher(Password_Registration);
    }//endwhile 

    if (checkPasswordComplexity(Password_Registration)) {
        System.out.println("Password successfully captured.");
        System.out.println("\nCongradualtions! You have successfully registered your account.");
    }
}//end of registerUser()

//method 4
    public boolean loginUser{
        flag2 = Password_Login.equals(Password_Registration) && Username_Login.equals(Username_Registration);

        return flag2;
    }
//end of loginUser()

//method 5
public void returnLoginStatus() {
    while (!loginUser()) {
        System.out.println("\nUsername or password incorrext, please try again.");
        System.out.print("Please re-enter your username >> ");
        Username_Login = scan.next();
        System.out.print("Please re-enter your password >> ");
        Password_Login = scan.next();
    }

    if (LoginUser()) {

        System.out.println("\nWelcome " + Name_ + " " + Surname_ + "!It is great to you you again.");
    }
}
    //beginning of part 2 
    private int Size_;
    private String Task_Desc[] = new String[Size_];
    private String Task_Name[] = new String[Size_];
    private String Developer_Name[] = new String[Size_];
    private String Task_Duration[] = new String[Size_];
    private int[] Status_ = new int[Size_];
    private int Total_;
    private int Count_;
    private String[] options = ("To do", "Done", "Doing");
    private String Choice;

    public int getSize() {
        return Size_;
    }

    public void setSize() {
        this.Size_ = Size_;
    }

    public String[] getTask_Name() {
        return Task_Name;
    }

    public void setTask_Name(String[] Task_Name) {
        this.Task_Name = Task_Name;
    }

    public String getChoice_() {
        return Choice;
    }

    public void setChoice_(String Choice_) {
        this.Task_Name = Task_Name;
    }
    
    public String[] getOptions_() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getTotal() {
        return Total_;
    }

    public void setTotal (int Total_) {
        this.Total_ = Total_;
    }

    public int[] getStatus_() {
        return Status_;
    }

    public void setStstus_(int[] setStstus_) {
        this.Status_ = Status_;
    }
    
    public String[] getTask_Duration() {
        return Task_Duration;
    }

    public void setTask_Duration (String[]Task_Duration) {
        this.Task_Duration = Task_Duration;
    }

    public String[] getDeveloper_Name() {
        return Developer_Name;
    }

    public void setDeveloper_Name(int Total_) {
        this.Developer_Name = Developer_Name;
    }

    public int getCount_() {
        return Count_;
    }

    public void setCount_(int Count_) {
        this.Count_ = Count_;
    }

    public String[] getTask_Desc() {
        return Task_Desc;
    }

    public void setTask_Desc(String[] Task_Desc){
        this.Task_Desc = Task_Desc;
    }

    public boolean checkTaskDescrpition(String desc) {

        boolean flag3 = desc.length() < 51 && desc.length() > 0;

        return flag3;
    }

    public String createTaskID() {

        String a = Character.toString(Task_Name[getCount_()].charAt(0));
        String b = Character.toString(Task_Name[getCount_()].charAt(1));
        String c = Character.toString(Developer_Name[getCount_()].charAt(Developer_Name[getCount_()].length()-3));
        String d = Character.toString(Developer_Name[getCount_()].charAt(Developer_Name[getCount_()].length()-2));
        String e = Character.toString(Developer_Name[getCount_()].charAt(Developer_Name[getCount_()].length()-1));
        
        String taskID = a.toUpperCase() + b.toUpperCase() + ":" + Count_ + ":" + c.toUpperCase() + d.toUpperCase() + e.toUpperCase();

        return taskID;

    }

    public String printTaskDetails() {

        String taskDet = "Status: " + options[Status_[getCount_()]]
                        + "\nDeveloper: " + Developer_Name[getCount_()]
                        + "\nTask Number: " + getCount_()
                        + "\nTask Name: " + Task_Name[getCount_()]
                        + "\nDescrpition: " + Task_Desc[getCount_()]
                        + "\nTask ID: " + createTaskID()
                        + "\nDuration: " + Task_Duration[getCount_()] + "hours";

        return taskDet;
    }

    public int returnTotalHours() {

        return Total_;
    }

    public String verifyChoice() {}    

    public String verifyTaskName() {
        while (Task_Name[getCount_()].equals("") || Task_Name[getCount_()].length() < 2) {
            Task_Name[getCount_()] = JOptionPane.showInputDialog(null, "Please ensure that your task name is at least 2 characters long",
            "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }
        
        return Task_Name[getCount_()];
    }

    public String verifyDeveloperName() {
        while (Developer_Name[getCount_()].equals("") || Developer_Name[getCount_()].length() < 3) {
            Task_Name[getCount_()] = JOptionPane.showInputDialog(null, "Please ensure that developer's name is at least 3 letters",
            "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
        }   
    }

    public String verifyTaskDuration() {

        while(true) {
            try {
                Integer.parseInt(Task_Duration[getCount_()]);
                break;
            }

            catch (NumberFormatException e) {
                Task_Duration[getCount_()] = JOptionPane.showInputDialog(null, "Enter the estimated task duration in hours"
                    + "\n*Ensure that it is a numeric value",
                    "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);
            }
        }

        return Task_Duration[getCount_()];
    }
}
    
