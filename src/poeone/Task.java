
package poeone;


public class Task {
    private static int tNum=0, totHours=0;
    String taskID, dev, tName, tDesc, tStatus;
    int tDuration;
    //private static int totHours=0;
    
    public Task()
    {
        tNum++;        
    }
    boolean checkTaskDescription()
    {
        return tDesc.length()<=50;
    }
    
    String createTaskID()
    {
        return (Character.toString(tName.charAt(0))+ Character.toString(tName.charAt(1))+":"+tNum+":"+dev.substring(dev.length() - 3)).toUpperCase();
    }
    int returnTotalHours()
    {
        return totHours;
    }
    void increaseHours()
    {
        totHours+=tDuration;
    }
    
    //this makes the total hours and task number equal 0 so when the loop is run multiple times the hours and task number does not continue counting
    //from the beginning
    //you could actually want these values not to be reseted, and get total hours from tasks added before, other values like task decriction and
    //status go out of scope, so this information is useless by itself, so i felt it was best to reset it
    void resetVals()
    {
        totHours=0;
        tNum=0;
    }
    
   String  printTaskDetails()
   {
        //Task Status, Developer Details, Task Number, Task Name, Task Description, Task ID and Duration;
       return "Task Status:     "+tStatus+
               "\nTask Number:     "+tNum+
               "\nTask Name:     "+tName+
               "\nTask Description:     "+tDesc+
               "\nTask ID:     "+taskID+
               "\nDuration:     "+tDuration;
                       
   }
}
