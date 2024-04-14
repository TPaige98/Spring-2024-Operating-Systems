public class Test2Num1 extends Thread 
{
    public void run()
    {
        System.out.println("Test2 - 1. This program starts a thread in Java");
        System.out.println("Thread Started");
    }

    public static void main(String[] args)
    {
        Test2Num1 thread = new Test2Num1();

        thread.start();
    }
}
