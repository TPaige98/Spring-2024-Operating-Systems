import java.util.Scanner;

public class Assignment6
{
    //I tried to get it to run, but I think I have some of my setup wrong. I know I'm missing something, because all this code does that I setup is run the initial nap() function which just includes nap(NAP_TIME).
    public static void main(String[] args)
    {
        nap();
    }

    //I'm assuming this allows for the process to nap from zero to the NAP_TIME seconds which is set to 5 down below. 
	/** 	 * Nap between zero and NAP_TIME seconds. 	 */
	public static void nap() 
    {
		nap(NAP_TIME);

	}

    //This one I'm assuming allows the process to nap from zero to the duration that is given. I am just not entirely sure on how to set it up properly
	/** 	 * Nap between zero and duration seconds. 	 */
	public static void nap(int duration) 
    {
        int toMultiply;
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a number to multiply by sleeptime: ");
        toMultiply = in.nextInt();

        int sleeptime = (int) (NAP_TIME * Math.random());

        try 
        { 
            //I set it up like the instructions stated, I'm just not sure how to print or show this above. When I use System.out.println(Thread.sleep(sleeptime * toMultiply)); it runs into errors that I'm not sure how to handle. 
            Thread.sleep(sleeptime * toMultiply);
        }

        //I'm not really sure we needed to change much here for the exception. I may be wrong.
        catch (InterruptedException e) 
        {
            System.out.println("Error Occurred: " + e);
        }

        in.close();
	}

	private static final int NAP_TIME = 5;
}
