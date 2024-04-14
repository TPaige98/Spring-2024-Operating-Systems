import java.util.Scanner;
public class MultiThreadedAddition
{
	public static void main(String[] args)
	{

		Summation[] worker;
		Sum[] sumValue;
		Scanner sc = new Scanner(System.in);
		Integer total = 0;
		Integer maximum;
		int number;  //number of threads
		int lower,upper;
		System.out.print("Enter an integer value: ");
		maximum = sc.nextInt();
		System.out.print("Enter the number threads: ");
		number = sc.nextInt();
		System.out.println();
		sc.close();

		if(number < maximum && number > 0)
		{

			worker = new Summation[number]; //create threads
			sumValue = new Sum[number];
			lower = 1;
			int increment = maximum/number;

			for(int i = 0;i < number;i++)
			{
			   upper = lower + increment;
			   if(upper > maximum)
			      upper = maximum;
			   sumValue[i] = new Sum();
			   worker[i] = new Summation(lower, upper,sumValue[i]);
			   Integer name = i+1;
			   worker[i].setName(name.toString());
			   worker[i].start();
			   lower = upper + 1;
			}

			for(int i = 0; i < number; i++)
			{	
			   	try
				{
					worker[i].join();
				}
				catch(InterruptedException e){System.out.println(e.toString());}

				//FROM FOR LOOP 3
				//I took away the 3rd for loop because I deemed it unnessecary.
				total += sumValue[i].get();
			}
	
			System.out.println("SUM OF NUMBERS BETWEEN 1 AND " + maximum.toString() + " = " + total.toString());
			Integer checkSum;
			checkSum = maximum*(maximum+1)/2;
			System.out.println("CHECK SUM = " + checkSum.toString());
		}
		else
		{
			System.out.println("Number of threads must be less than maximum integer value and greater than zero.");
		}
	}
}

//I moved the classes down here, because I prefer the main to be up top and easily visible
class Sum
{
	private int value;

	public int get() 
	{
		return value;
	}
	public void set(int sum) 
	{
		this.value = sum;
	}
}

class Summation extends Thread
{
	private int lower,upper;
	private int sum;
	private Sum sumValue;

	//I changed the variables here in the Summation class.
	//I got rid of all instances of "this" that you mentioned in class on Wednesday
    public Summation(int lowerNum,int upperNum,Sum sumValueNum)
    {
		lower = lowerNum;
		upper = upperNum;
		sumValue = sumValueNum;
	}

    public int getSum()
    {
		return sum;
	}

	public void run()
	{
		int sum = 0;
		for (int i = lower; i <= upper; i++)
			sum += i;
		sumValue.set(sum);

		//This is the data I pulled from the TPExample java file. 
		//I modified it a bit to flow and read better in the console.
		Thread me;
		me = Thread.currentThread();
		System.out.println("-- I am working on a task--" + "\n[Thread] = " + me.getName() + "\t[Sum] = " + sum + "\n");
	}
}