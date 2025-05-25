//ST10339603
//Tashil Koseelan
//POE part 1, 2
package poeone;

//import java.util.Scanner;
import javax.swing.JOptionPane;

public class PoeOne {

    private static int itemsDeleted=0;
    public static void main(String[] args) {
        String username="", password="", firstName, lastName, enteredUsername, enteredPassword;
        Login myLogin=new Login();
        boolean successReg=false, successLog=false;//these are for while loops
        boolean uShown=false, pShown=false;
        
        firstName=JOptionPane.showInputDialog("Please enter first name");  
        lastName=JOptionPane.showInputDialog("Please enter last name");
        while(!successReg)
        {
            //only asks user to re-enter the thing the got wrong, could be username, password, both or neither
            if(!myLogin.checkUserName(username))
            {
                username=JOptionPane.showInputDialog("Please create a username");
            }
            if(!myLogin.checkPasswordComplexity(password))
            {
                password=JOptionPane.showInputDialog("Please create a password");
            }
            
            if(myLogin.checkUserName(username))
            {
                //I used ushown to ensure that "Username succesfully captured is only displayed once as to not annoy the user"
                if(!uShown)
                {
                    JOptionPane.showMessageDialog(null, "Username successfully captured");
                    //System.out.println("Username successfully captured");  
                    uShown=true;
                }
                
            }
            
            if(myLogin.checkPasswordComplexity(password))
            {
                //I used pshown to ensure that "Password succesfully captured is only displayed once as to not annoy the user"
                if(!pShown)
                {
                    //System.out.println("Password successfully captured");  
                    JOptionPane.showMessageDialog(null, "Password successfully captured");
                    pShown=true;
                }
                    
            }
            //System.out.println(myLogin.registerUser(username, password));
            JOptionPane.showMessageDialog(null, myLogin.registerUser(username, password));
            //if passwor and username meet requirments then successReg is set to true so loop can stop
            if("The two above conditions have been met and the user has been registered successfully. ".equals(myLogin.registerUser(username,password)))
            {
                successReg=true;
            }
        }
        //login section
        //System.out.println("\nPlease login");
        JOptionPane.showMessageDialog(null,"Please login");
        
        while(!successLog)
        {
            enteredUsername=JOptionPane.showInputDialog("Enter username");
            enteredPassword=JOptionPane.showInputDialog("Enter password");
            JOptionPane.showMessageDialog(null,myLogin.returnLoginStatus(username, password, enteredUsername, enteredPassword, firstName, lastName) );
            
            //if the login details are correct it sets successLog to true to end loop
            if(myLogin.loginUser(username, password, enteredUsername, enteredPassword))
            {
                successLog=true;
            }
        }
    
        //part 2 task related stuff
        
        int option =1, numberTasks;
        //boolean askedForNumTasks=false;
        int status;
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanBan");
        while(option!=3)
        {
            option=Integer.parseInt(JOptionPane.showInputDialog("Please select one of the options by enetering a numeric value:\n"
                    + "\toption 1) Add tasks\n"
                    + "\toption 2) Show report\n"
                    + "\toption 3) Quit\n"));
            if(option==2)
            {
                JOptionPane.showMessageDialog(null,"Coming soon");
            }else if(option==1)
            {
                
                numberTasks=Integer.parseInt(JOptionPane.showInputDialog("Please enter the number of tasks"));
                //if statement to avoid errors
                
                if(numberTasks>0)
                {
                
                Task[] myTasks=new Task[numberTasks];
                //part 3 arrays
                String[] developers=new String[numberTasks];
                String[] taskNames=new String[numberTasks];
                String[] taskID=new String[numberTasks];
                int[] duration=new int[numberTasks];
                String[] taskStatus=new String[numberTasks];
                
                for (int i=0;i<myTasks.length;i++)
                {
                    myTasks[i]=new Task();
                    myTasks[i].tName=JOptionPane.showInputDialog("Please enter task name");
                    taskNames[i]=myTasks[i].tName;//part3
                    do
                    {
                        myTasks[i].tDesc=JOptionPane.showInputDialog("Please enter task description");
                        if(!myTasks[i].checkTaskDescription())
                        {
                            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Task successfully captured");
                        }
                    }while(!myTasks[i].checkTaskDescription());
                    
                    myTasks[i].dev=JOptionPane.showInputDialog("Please enter developer name");
                    developers[i]=myTasks[i].dev;//part3
                    myTasks[i].tDuration=Integer.parseInt(JOptionPane.showInputDialog("Please enter estimated task duration"));
                    duration[i]=myTasks[i].tDuration;//part3
                    //myTasks[i].totHours+=myTasks[i].tDuration;
                    myTasks[i].increaseHours();
                    status=Integer.parseInt(JOptionPane.showInputDialog("What is the status of this task?\nPlease select one of the options by enetering a numeric value:\n"
                    + "\toption 1) To Do\n"
                    + "\toption 2) Done\n"
                    + "\toption 3) Doing\n"));
                    switch (status) {
                        case 1:
                            myTasks[i].tStatus="To Do";
                            taskStatus[i]="To Do";//part3
                            break;
                        case 2:
                            myTasks[i].tStatus="Done";
                            taskStatus[i]="Done";//part3
                            break;
                        case 3:
                            myTasks[i].tStatus="Doing";
                            taskStatus[i]="Doing";//part3
                            break;
                        default:
                            //assumes user enters a valid input
                            break;
                    }
                    
                    myTasks[i].taskID=myTasks[i].createTaskID();
                    taskID[i]=myTasks[i].taskID;//part3
                    
                    JOptionPane.showMessageDialog(null,myTasks[i].printTaskDetails());
                    
                }
                JOptionPane.showMessageDialog(null,"Total hours:"+myTasks[0].returnTotalHours());
                myTasks[0].resetVals();
                
                //part3
                //JOptionPane.showInputDialog()
                int arrFunc;
                String stName, sDev, sDelete;
                boolean funcExit=false, dFound=false;
                while(!funcExit)
                {
                    arrFunc=Integer.parseInt(JOptionPane.showInputDialog("What would you like to do?\nPlease select one of the options by enetering a numeric value:\n"
                    + "\toption 1) Display complete tasks\n"
                    + "\toption 2) Display task with longest duration\n"
                    + "\toption 3) Search for task\n"
                    + "\toption 4) Search for developer\n"
                    + "\toption 5) Delete task\n"
                    + "\toption 6) Display full report\n"
                    + "\toption 7) Exit\n"));
                    switch(arrFunc)
                    {
                        case 1:
                            JOptionPane.showMessageDialog(null, displayCompleteTasks(developers, taskNames, duration, taskStatus));
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,displayLongestDuration(developers, duration));
                            break;
                        case 3:
                            stName=JOptionPane.showInputDialog("Enter task name");
                            JOptionPane.showMessageDialog(null,findTaskName(stName, taskNames, developers, taskStatus));
                            break;
                        case 4:
                            sDev=JOptionPane.showInputDialog("Enter Developer");
                            JOptionPane.showMessageDialog(null,findDevTasks(sDev, developers, taskNames, taskStatus));
                            break;
                        case 5:
                            sDelete=JOptionPane.showInputDialog("Enter task name");
                            System.out.println("number of tasks is"+numberTasks);
                            for(int i =0; i<developers.length-itemsDeleted;i++) 
                            {
                                if(sDelete.equals(taskNames[i]))
                                {
                                    dFound=true;
                                    System.out.println("number of tasks is"+numberTasks);
                                    numberTasks--;
                                    System.out.println("number of tasks is now"+numberTasks);
                                    for(int j=i;j<developers.length-itemsDeleted-1;j++)
                                    {
                                        developers[j]=developers[j+1];
                                        taskNames[j]=taskNames[j+1];
                                        taskID[j]=taskID[j+1];
                                        duration[j]=duration[j+1];
                                        taskStatus[j]=taskStatus[j+1];
                                        
                                        
                                    }
                                    itemsDeleted++;
                                    JOptionPane.showMessageDialog(null, "Entry \""+sDelete+"\" succesfully deleted");
                                    //displayReport(developers, taskNames, taskStatus, duration, taskID);
                                }
                                
                            }
                            if(!dFound)
                            {
                                JOptionPane.showMessageDialog(null, "Task not found");
                            }
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null,displayReport(developers, taskNames, taskStatus, duration, taskID));
                            break;
                        case 7:
                            funcExit=true;
                            break;
                        default:
                            break;
                    }
                }
                
                }
            }
        }
        
        
    }
    public static String displayCompleteTasks(String devArr[],String tNameArr[] ,int durArr[], String statusArr[])
    {
        String message="";
        for (int i=0;i<devArr.length-itemsDeleted;i++)
        {
            if(statusArr[i].equals("Done"))
            {
                message=message+devArr[i]+", "+tNameArr[i]+", "+durArr[i]+"\n";
            }
        }
        //JOptionPane.showMessageDialog(null, message);
        return message;
    }
    
    public static String displayLongestDuration(String devArr[], int durArr[])
    {
        if(devArr.length-itemsDeleted<1)
        {
            //JOptionPane.showMessageDialog(null, "No tasks");
            return "No tasks";
        }
        else
        {
            String longest =devArr[0];
            int longestDur=durArr[0];
            for(int i =0; i<devArr.length-itemsDeleted;i++)
            {
                if(durArr[i]>longestDur)
                {
                    longestDur=durArr[i];
                    longest=devArr[i];
                }
            }
            //JOptionPane.showMessageDialog(null, longest+", "+longestDur);
            return longest+", "+longestDur;
        }
    }
    
    public static String findTaskName(String searchWord,String tName[],String dev[], String status[])
    {
        //boolean found=false;
        String message="";
        for(int i=0;i<tName.length-itemsDeleted;i++)
        {
            if(tName[i].equals(searchWord))
            {
                message= message+ tName[i]+", "+dev[i]+", "+status[i]+"\n";
                //found=true;
            }
        }
        if(message.equals(""))
        {
            message = "Task not found";
        }
        return message;
    }
    
    public static String findDevTasks(String dev, String dName[],String tName[], String tStatus[])
    {
        boolean found =false;
        String message="";
        for(int i =0;i<tName.length-itemsDeleted;i++)
        {
            if(dev.equals(dName[i]))
            {
                message=message+tName[i]+" - "+tStatus[i]+"\n";
                found=true;
            }
        }
        if(found)
        {
            return message;
        }
        else
        {
            return "No tasks found";
        }
    }
    
    public static String displayReport(String dName[],String tName[], String tStatus[], int duration[], String taskID[])
    {
        String message = "";
        for(int i =0;i<dName.length-itemsDeleted;i++)
        {
            message=message+tName[i]+", "+dName[i]+", "+tStatus[i]+", "+duration[i]+", "+taskID[i]+"\n";
        }
        return message;
    }
    
    //void DeleteTask(tName, )
    
    
}
