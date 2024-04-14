import java.util.Scanner;
import java.io.File;

public class Assignment2
{
    public static void main(String[] args)
    {
        //Assignment 2 - Part 2 - Question 1
        try
        {
            //Process Builder
            System.out.println("Assignment 2 - Part 2 - Question 1");
            System.out.println();

            //I emailed you on this issue, but I played around with the Process Builder and it's command/arguments.
            //I couldn't quite figure out how to tackle the ProcessBuilder, but I did update the directories as specified in the assignment.
            ProcessBuilder pb = new ProcessBuilder("Assignment2.java");

            //The oracle docs show that directory() returns the current working directory and that it may be NULL. In my case it is. 
            System.out.println(pb.directory());

            pb.directory(new File("C:/Users/XzXCo/OneDrive/NSU College/Computer Science Work/Spring 2024/Operating Systems"));

            //To validate that the directory has indeed changed, I again called directory() and it shows the directory has changed. 
            System.out.println(pb.directory());

            System.out.println();
            pb.start();
        } 
        catch(Exception e) 
        {
            System.out.println("Error Ocurred: " + e);
        }

        //--------------------------------------------------------------------------------------------------------------------------------------------//

        //Assignment 2 - Part 2 - Question 2
        try
        {
            //Scanner Input
            System.out.println();
            System.out.println("------------------------------------");
            System.out.println("Assignment 2 - Part 2 - Question 2");
            System.out.println();

            Scanner in = new Scanner(System.in);

            System.out.println("Please enter a sentence from the keyboard.");
            System.out.println();
            System.out.print("Enter: " );
            String sentence = in.nextLine();

            System.out.println();
            System.out.println("The sentence you entered was: " + sentence);

            in.close();
        } 
        catch(Exception e) 
        {
            System.out.println("Error Ocurred: " + e);
        }
    }
}
