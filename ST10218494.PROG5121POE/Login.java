import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;

public class Login {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Task taskObj = new Task();

        String name; 
        String surname;
        String usernameRegistartion;
        String passowrdRegistration;
        String usernameLogin;
        String passwordLogin;

        System.out.println("Hello there!" + "\nTo register an account with us, please follow the prompts below.");
        
        System.out.print("\nStep 1: Enter your first name >>");
        name = scan.next();
        taskObj.setName_(name);

        System.out.print("\nStep 2: Enter your surname >>");
        surname = scan.next();
        taskObj.setSurname(surname);

        System.out.print("\nStep 3: Create a username"
                + "\n*Please note that your username:"
                + "\n- must not exceed 5 characters in length"
                + "\n- must contain an underscore (_)."
                + "\nEnter a username >> ");
        usernameRegistartion = scan.next();
        taskObj.setusernameRegistration_(usernameRegistartion);

    
        taskObj.registerUser();

        System.out.print("\n" + "Step 4: Create a password"
                + "\n*Please note that your passowrd must:"
                + "\n- contain at least 8 characters,"
                + "\n- contain a capital letter,"
                + "\n- contain a digit and"
                + "\n- contain a special character."
                + "\nEnter a password >> ");
        passowrdRegistration = scan.next();
        taskObj.setPasswordRegistration_(passowrdRegistration);

        taskObj.registerUser();

        System.out.print("\nTo login, please enter your username and password below:"
                + "\nPlease enter your username >> ");
                usernameLogin = scan.next();
                taskObj.setUsername_Login(usernameLogin);

        System.out.print("\nPlease enter your password >> ");
                passwordLogin = scan.next();
                taskObj.setPassword_Login(passwordLogin);
        
        taskObj.returnLoginStatus();


        //Parts 2 and 3
        window.setAlwaysOnTop(true);

        String choice;
        String taskName[] = null;
        String taskDesc[] = null;
        String developerName[] = null;
        String taskDuration[] = null;
        int status[] = null;
        String taskID[] = null;
        int size = 0;
        int count[];
        int total[] = 0;
        String[] del = ("Delete", "Cancel");
        String[] options = ("To Do", "Done", "Doing");

//prompting th euser to choos ean option
        choice = JOptionPane.showInputDialog(null,
            "Please select an action to proceed with:"
            + "\n1. Add tasks"
            + "\n2. Show report"
            + "\n3. View all completed tasks"
            + "\n4. Display task with longest duration"
            + "\n5. Search for task"
            + "\n6. Delete a task"
            + "\n\n0. Quit",
            "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);
  
        taskObj.setChoice_(choice);
        choice = taskObj.verifyChoice();

        while (choice.equals("1") || (choice.equals("2") || (choice.equals("3") || (choice.equals("4") || (choice.equals("5") || (choice.equals("6") || (choice.equals("7") || (choice.equals("0") ){
            if (choice.equals("1")) {
                //prompting for a task amount
                size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the amount of tasks you want to create:",
                null, JOptionPane.PLAIN_MESSAGE));
                taskObj.setSize_(size);

                //declaring the size of the arrays 
                taskName = new String[size];
                developerName = new String[size];
                taskDuration = new String[size];
                status = new int[size];
                taskID = new String[size];
                taskDesc = new String[size];

                for (count = 0; count< size; count++) {
                    taskObj.setCount_(count);

                    taskName[count] = JOptionPane.showInputDialog(null, "Enter a name for Task " + count,
                    "Task Name", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setTask_Name(taskName);
                    taskName[count] = taskObj.verifyTaskName();

                    taskDesc[count] = JOptionPane.showInputDialog(null, "The description should not exceed 50 characters in length.",
                    "Provide a descrpition for the task", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setTask_Desc(taskDesc);
                    
                    while (!taskObj.checkTaskDescrpition(taskDesc[count])) {
                        taskDesc[count] = JOptionPane.showInputDialog(null, "Please enter a task descrpition of 50 characters or less.",
                        "INVALID ENTRY", JOptionPane.ERROR_MESSAGE);

                        taskObj.setTask_Desc(taskDesc);
                    }

                    if (taskObj.checkTaskDescrpition(taskDesc[count])) {
                        JOptionPane.showMessageDialog(null, "Task successfully captured.");
                    }

                    developerName[count] = JOptionPane.showInputDialog(null, "Enter the first and last name of the developer assigned to ",
                    "Developer Details", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setDeveloper_Name(developerName);
                    developerName[count] = taskObj.verifyDeveloperName();

                    taskDuration[count] = JOptionPane.showInputDialog(null, "Enter the estimated task duration in hours",
                    "Task Duration", JOptionPane.PLAIN_MESSAGE);
                    taskObj.setTaskDuration_Name(taskDuration);
                    taskDuration[count] = taskObj.verifyTaskDuration();

                    total = total + Interger.parseInt(taskDuration[count]);
                    taskObj.setTotal_(total);

                    status[count] = JOptionPane.showOptionDialog(null, "Please specify the status of this task:", "Task Stauts", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, taskObj.getOptions(), null);
                    taskObj.setStatus_(status);

                    JOptionPane.showMessageDialog(null, taskObj.printTaskDetails(), "Title Details", JOptionPane.PLAIN_MESSAGE);

                    taskID[count] = taskObj.createTaskID();
                }
            }

            if (choice.equals("2")) {

                StringBuilder report = new StringBuilder();

                    for (int i = 0; i < size; i++) {
                        if (taskName[i] != null) {
                            report.append("Task name: ").append(taskName[i])
                                    .append("\nDeveloper: ").append(developerName[i])
                                    .append("\nDuration: ").append(taskDuration[i] +  "hours")
                                    .append("\nTask ID: ").append(taskID[i])
                                    .append("\nStatus: ").append(options[status[i]] + "\n\n");
                        }
                    }
                
                if (size == 0) {
                    JOptionPane.showMessageDialog(null, "Please add tasksto view a report", "No tasks to display", JOptionPane.PLAIN_MESSAGE);
                }

                else {
                    JOptionPane.showMessageDialog(null, report.toString(), "Task Report", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("3")) {
                StringBuilder completedTasks = new StringBuilder();

                int found = 0;

                if (status != null && developerName != null && taskName != null && taskDuration !=null) {

                    for (int i = 0; i < size; i++) {
                        if (status[i] == 1) {
                            completedTasks.append("Task name: ").append(taskName[i])
                                    .append("\nDeveloper: ").append(developerName[i])
                                    .append("\nTask Duration: ").append(taskDuration[i] +  "hours\n\n");
                        
                            found++;
                        }
                    }
                }
                if (found > 0) {
                    JOptionPane.showMessageDialog(null, completedTasks.toString(), "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                }

                else {
                    JOptionPane.showMessageDialog(null, "No tasks have been completed yet.", "Completed tasks", JOptionPane.PLAIN_MESSAGE);
                }
            }

            if (choice.equals("4")) {

                if (size == 0) {
                    JOptionPane.showMessageDialog(null, "Please add tasks to preceed with this action.",
                    "No task to display.", JOptionPane.PLAIN_MESSAGE);
                }
                else {

                    int longestDuration = 0;
                    String longestDurationDevrloper = null;

                    for (int i = 0; i < size; i++) {

                        if (Integer.parseInt(taskDuration[i]) > longestDuration) {
                            longestDuration = Integer.parseInt(taskDuration[i]);
                            longestDurationDevrloper = developerName[i];
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Developer: " + longestDurationDevrloper +"\nDuration: " + longestDuration + "hours", "Task with longest duration", JOptionPane.PLAIN_MESSAGE);
                }

            }

            if (choice.equals("5")) {

                String search = "";
                boolean matchFound = false;

                search = JOptionPane.showInputDialog(null, "Enter a task name", "Search by name", JOptionPane.PLAIN_MESSAGE );

                for (int i = 0; i < size; i++) {

                    if (search.equalsIgnoreCase(taskName[i])) {
                        JOptionPane.showMessageDialog(null, "Task Name: " + taskName[i]
                            + "\nDeveloper: "+ developerName[i]
                            + "\nStatus: " + options[status[i]], "Task found", JOptionPane.PLAIN_MESSAGE);
                    matchFound = true;}

                }

            }
            if (choice.equals("6")) {

                String search = "";
                boolean matchFound = false;
                StringBuilder searchFound = new  StringBuilder();

                search = JOptionPane.showInputDialog(null, "Enter a developer's name", "Search by developer", JOptionPane.PLAIN_MESSAGE);
                for (int i = 0; i < size; i++) {

                    if (search.equalsIgnoreCase(developerName[i])) {
                        searchFound.append("Name: "). append(taskName[i])
                        .append("\nStatus: ").append(options[stsus[i]]).append("\n\n");

                        matchFound = true;
                    }

                }

                if (matchFound) {

                    JOptionPane.showMessageDialog(null, searchFound.toString(), "Tasks assigned to " + search, JOptionPane.PLAIN_MESSAGE);

                }

                else {

                    JOptionPane.showMessageDialog(null, "That developer is not assigned to any tasks.", "No match found", JOptionPane.PLAIN_MESSAGE);

                }
            } 
          
            if (choice.equals("7")) {

                String delete = "";
                boolean taskDeleted = false;
                int confirm;

                delete = JOptionPane.showInputDialog(null, "Enter a task name. \n*All tasks with this name will be deleted",
                "Delete tasks", JOptionPane.PLAIN_MESSAGE);

                for (int i = 0; i < size: i++) {

                    if (delete.equalsIgnoreCase(taskName[i])) {

                        confirm = JOptionPane.showOptionDialog(null, "Are you sure you want to delete tasks of the name " + delete + " ?", 
                        "Confirm task deletion", JOptionPane.PLAIN_MESSAGE, JOptionPane.WARNING_MESSAGE,
                        null, del, null);
                        
                        if (confirm == 0) {
                            total = total - Integer.parseInt(taskDuration[i]);
                            taskObj.setTotal_(total);
                            developerName[i] = null;
                            taskDesc[i] = null;
                            taskDuration[i] = null;
                            status[i] = -1;
                            taskID[i] = null;

                            taskDeleted = true;
                        }

                    }
                }
                if (taskDeleted) {
                    JOptionPane.showMessageDialog(null, "The task was successfully deleted", "Task deleted", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "No tasks were found", "Task not found", JOptionPane.PLAIN_MESSAGE);
                }

            }

        choice = JOptionPane.showInputDialog(null,
                "Please select an action to proceed with:"
                + "\n1. Add tasks"
                + "\n2. Show report"
                + "\n3. View all completed tasks"
                + "\n4. Display task with longest duration"
                + "\n5. Search for task"
                + "\n6. Search tasks by developer")
                + "\n7. Delete a task"
                +  "\n\n0. Quit",
                "Welcome to EasyKanban", JOptionPane.PLAIN_MESSAGE);
        
        taskObj.setChoice_(choice);
        choice = taskObj.verifyChoice();

        }
        
        if (choice.equals("0")) {

            JOptionPane.showMessageDialog(null, "Your tasks wull take a total of " + taskObj.returnTotalHours() +" hours.", "Total duration: ", JOptionPane.PLAIN_MESSAGE);
            JOptionPane.showMessageDialog(null, "Goodbye for now :)", "See you soon.", JOptionPane.PLAIN_MESSAGE);
        }

    }
}


