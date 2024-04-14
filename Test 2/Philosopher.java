  /**
 *  
 * This thread is used to demonstrate the operation of a semaphore.
 *
 * Figure 6.8
 *
 * @author Gagne, Galvin, Silberschatz
 * Operating System Concepts with Java - Eighth Edition
 * Copyright John Wiley & Sons - 2010.
 */

public class Philosopher extends Thread
{

	private Semaphore LStick,RStick;

	private String name;

	public Philosopher(Semaphore sem1,Semaphore sem2, String name)
	{
		this.name = name;
		LStick = sem1;
		RStick = sem2;
	}

	public void run()
	{
		while (true)
		{
			hungry();
			LStick.acquire();
			RStick.acquire();
			eating();
			LStick.release();
			RStick.release();
			thinking();
		}
	}
	private void eating()
	{
		System.out.println("Philosopher " + name + " is EATING.");
		SleepUtilities.nap(2);
	}
	private void thinking()
	{
		System.out.println("Philosopher " + name + " is THINKING.");
		SleepUtilities.nap(2);
	}
	private void hungry()
	{
		System.out.println("Philosopher " + name + " is HUNGRY.");
		SleepUtilities.nap(2);
	}
}
