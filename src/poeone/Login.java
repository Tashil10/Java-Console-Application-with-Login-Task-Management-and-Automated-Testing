
package poeone;

//import java.util.Scanner;


public class Login {
    
    //simply checks if username meets requirments and return true or false
    public boolean checkUserName(String userName)
    {
        return (userName.contains("_"))&&(userName.length()<=5);
    }
    
    //following code is adapted from baeldung website
    //website URL: https://www.baeldung.com/java-lowercase-uppercase-special-character-digit-regex
    //author: baeldung
    public boolean checkPasswordComplexity(String password)
    {
        char letter;
        //list of special characters used to compare if a letter contains one of these special characters
        String specials ="~`!@#$%^&*()-_=+\\\\|[{]};:'\\\",<.>/?";
        boolean containsUpper=false, containsNum=false, containsSpecial=false;
        //iterates through password like an array checking off whether this string contains uppercase, numbers, and capital letters
        for(int i=0;i<password.length();i++)
        {
            letter=password.charAt(i);
            if (Character.isDigit(letter)) 
            {
                containsNum = true;
            }else if(Character.isUpperCase(letter))
            {
                containsUpper = true;
            }else if(specials.contains(String.valueOf(letter)))
            {
                containsSpecial = true;
            }
        }
        
        return (password.length()>7) && (containsUpper &&containsNum && containsSpecial);
    }
    
    public String registerUser(String userName, String password)
    {
        if(checkUserName(userName) && checkPasswordComplexity(password))
        {
            return "The two above conditions have been met and the user has been registered successfully. ";
        }else if(checkUserName(userName))
        {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }else if(checkPasswordComplexity(password))
        {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        return "Username and password is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length and that the password contains at least 8 characters, a capital letter, a number and a special character.";
        
    }
    
    //could use global variables instead of inputing 4 parameters but apperently it makes unit tests complicated and this way works so I did it like this
    public boolean loginUser(String username, String password, String enteredUserName, String enteredPassword)
    {
        return (username.equals(enteredUserName) && password.equals(enteredPassword));
    }
    
    //similar to login user but returns a string used for outputing to user
    public String returnLoginStatus(String username, String password, String eUsername,String ePassword, String fName, String lName)
    {
        if (loginUser(username, password, eUsername, ePassword))
        {
            return "Welcome "+fName+" ,"+lName+" it is great to see you again.";
        }
        return "Username or password incorrect, please try again";
    }
}
