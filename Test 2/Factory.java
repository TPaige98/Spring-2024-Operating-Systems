import java.util.ArrayList;

/**
 * Factory.java
 *
 * This class creates the reader and writer threads and
 * the database they will be using to coordinate access. */
  

public class Factory
{
   public static void main(String args[])
   {
      //Semaphore [] chopsticks;
      ArrayList<Semaphore> chopsticks = new ArrayList<Semaphore>();
      //Philosopher [] philos;
      ArrayList<Philosopher> philos = new ArrayList<Philosopher>();
      
      //chopsticks = new Semaphore[5];
      chopsticks = new ArrayList<Semaphore>(10);
      
      //philos = new Philosopher[5];
      philos = new ArrayList<Philosopher>(5);

      for(int i = 0;i < 10;i++)
         //chopsticks[i] = new Semaphore(1);
      	chopsticks.add(new Semaphore(1));
      for(int i = 0;i < 5;i++)
      	//philos[i] = new Philosopher(chopsticks[i],chopsticks[(i+1)%5],Integer.toString(i));
         philos.add(new Philosopher(chopsticks.get(i), chopsticks.get((i + 1) % 5), Integer.toString(i)));
      for(int i =0;i < 5;i++)
         //philos[i].start();
         philos.get(i).start();
   }
}
