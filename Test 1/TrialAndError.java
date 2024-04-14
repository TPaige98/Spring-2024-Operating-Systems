import java.util.ArrayList;
import java.util.Scanner;

public class TrialAndError 
{
    public static void main(String[] args)
    {
        int bufferSize = 0;
        int count = 0;

        ArrayList<Integer> buffer = new ArrayList<Integer>(bufferSize);

        Scanner in = new Scanner(System.in);

        bufferSize = in.nextInt();

        System.out.println("size of ArrayList = " + bufferSize);


        while (count == bufferSize)
        
        buffer.add(5);
        buffer.add(2);
        buffer.add(2);
        buffer.add(6);
        buffer.add(8);

        System.out.println(buffer);

        System.out.println(bufferSize);


        in.close();
    }





}
