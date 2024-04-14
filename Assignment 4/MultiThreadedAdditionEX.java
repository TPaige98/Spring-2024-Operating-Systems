 import java.util.Scanner;

class Sum
{
	private int value;

	public int get() {
		return value;
	}

	public void set(int sum) {
		this.value = sum;
	}
}
class Summation extends Thread
{
	private int lower,upper;
	private int sum;
	private Sum sumValue;

    public Summation(int lower,int upper,Sum sumValue)
    {
		this.lower = lower;
		this.upper = upper;
		this.sumValue = sumValue;
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
		System.out.println(this.getName() + "  " + sum);
	}
}

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
		System.out.println("Enter an integer value: ");
		maximum = sc.nextInt();
		System.out.println("Enter the number threads: ");
		number = sc.nextInt();
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
			for(int i = 0;i < number;i++)
			{
				try
				{
					worker[i].join();
				}
				catch(InterruptedException e){System.out.println(e.toString());}
			}
			for(int i=0;i < number;i++)
			{
				total += sumValue[i].get();
				Integer value = sumValue[i].get();
				System.out.println("Thread " + worker[i].getName() + " sum is " + value.toString());

			}
			System.out.println("The sum of the number between 1 and " + maximum.toString() + " is " + total.toString());
			Integer checkSum;
			checkSum = maximum*(maximum+1)/2;
			System.out.println("The Check Sum is " + checkSum.toString());
		}
		else
			System.out.println("Number of threads must be less than maximum integer value and greater than zero.");
	}
}
