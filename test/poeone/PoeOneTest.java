/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package poeone;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class PoeOneTest {
    
    public PoeOneTest() {
    }

    /**
     * Test of main method, of class PoeOne.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        PoeOne.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of population of arrays, of class PoeOne.
     */
    @Test
    public void testPopulateArrays()
    {
       System.out.println("populateArrays");
       String[] dName = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
       String result = "";
       for(int i=0; i<dName.length;i++)
       {
           result=result+dName[i]+", ";
       }
       String expResult="Mike Smith, Edward Harrison, Samantha Paulson, Glenda Oberholzer, ";
       assertEquals(expResult, result);
       System.out.println(result);
       
    }
    /**
     * Test of displayLongestDuration method, of class PoeOne.
     */
    @Test
    public void testDisplayLongestDuration() {
        System.out.println("displayLongestDuration");
        String[] devArr = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        int[] durArr = {5, 8, 2, 11};
        String expResult = "Glenda Oberholzer, 11";
        String result = PoeOne.displayLongestDuration(devArr, durArr);
        assertEquals(expResult, result);
        System.out.println(result);
    }

    /**
     * Test of findTaskName method, of class PoeOne.
     */
    @Test
    public void testFindTaskName() {
        System.out.println("findTaskName");
        String searchWord = "Create Login";
        String[] tName = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        String[] dev = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] status = {"To Do", "Doing", "Done", "To Do"};
        String result =PoeOne.findTaskName(searchWord, tName, dev, status);
        String expResult = "Create Login, Mike Smith, To Do\n";
        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findDevTasks method, of class PoeOne.
     */
    @Test
    public void testFindDevTasks() {
        System.out.println("findDevTasks");
        String dev = "Samantha Paulson";
        String[] dName = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] tName = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        String[] tStatus = {"To Do", "Doing", "Done", "To Do"};
        String result =PoeOne.findDevTasks(dev, dName, tName, tStatus);
        String expResult = "Create Reports - Done\n";
        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of deleteTask, of class PoeOne.
     */
    @Test
    public void testDeleteTask()
    {
        System.out.println("Deleting task");
        String task = "Create Reports";
        String result="Entry \""+task+"\" successfully deleted";
        String expResult="Entry \"Create Reports\" successfully deleted";
        assertEquals(expResult, result);
        System.out.println(result);
    }
    
    
    /**
     * Test of displayReport method, of class PoeOne.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        String[] dName = {"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        String[] tName = {"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        String[] tStatus = {"To Do", "Doing", "Done", "To Do"};
        int[] duration = {5, 8, 2, 11};
        String[] taskID ={"CR:1:ITH", "CR:2:SON", "CR:3:SON", "AD:4:ZER"};
        String result =PoeOne.displayReport(dName, tName, tStatus, duration, taskID);
        String expResult = "Create Login, Mike Smith, To Do, 5, CR:1:ITH\n" +
"Create Add Features, Edward Harrison, Doing, 8, CR:2:SON\n" +
"Create Reports, Samantha Paulson, Done, 2, CR:3:SON\n" +
"Add Arrays, Glenda Oberholzer, To Do, 11, AD:4:ZER\n";
        assertEquals(expResult, result);
        System.out.println(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

   
}
