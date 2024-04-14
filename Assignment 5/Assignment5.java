public class Assignment5
{
    public static void main(String[] args)
    {
        Thread thread = new Thread(new Assignment5Thread());

        thread.start();

    }
}

class Assignment5Thread implements Runnable
{
     public void run()
     {
        //I changed the thread priority from NORM to MAX
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

         System.out.println("-- New Thread Created --\n" + "Priority: " + Thread.currentThread().getPriority());
     }
}

//I found a good article from GeeksForGeeks that helped out with this assignment.

//LINK: https://www.geeksforgeeks.org/runnable-interface-in-java/?ref=lbp
