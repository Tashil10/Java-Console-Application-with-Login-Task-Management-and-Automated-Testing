/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poeone;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

//import static org.junit.Assert.*;

/**
 *
 * @author lab_services_student
 */
public class TaskTest {
    
    public TaskTest() {
    }

    @Test
    public void testCreateTaskID() {
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("createTaskID");
        Task instance = new Task();
        String expResult = "LO:1:SON";
        instance.tName="Login Feature";
        instance.dev="Robyn Harrison";
        String result = instance.createTaskID();assertEquals(expResult, result);
        System.out.println(result);
        
        
        
    }
    
    @Test
    public void testCheckTaskDescription()
    {
        System.out.println("checkTaskDescription");
        Task instance = new Task();
        instance.tDesc="Create Login to authenticate users";
        boolean result =instance.checkTaskDescription();
        boolean expResult=true;
        assertEquals(expResult, result);
        System.out.println("Task successfully captured");
    }
    
    @Test
    public void testReturnTotalHours()
    {
        System.out.println("returnTotalHours");
        System.out.println("First test data");
        Task t1=new Task();
        Task t2=new Task();
        t1.tDuration=8;
        t2.tDuration=10;
        
        t1.increaseHours();
        t2.increaseHours();
        
        int result1=t1.returnTotalHours();
        int expResult1=18;
        assertEquals(expResult1, result1);
        System.out.println(result1);
        t1.resetVals();
        
        System.out.println("Second Test Data");
        Task[] instances=new Task[5];
        int vals[] ={10,12,55,11,1};
        for(int i=0;i<5;i++)
        {
            instances[i] = new Task();
            instances[i].tDuration=vals[i];
            instances[i].increaseHours();
        }
        int result2 =instances[0].returnTotalHours();
        int expResult2=89;
        assertEquals(expResult2, result2);
        System.out.println(result2);
        
    }
    
}
