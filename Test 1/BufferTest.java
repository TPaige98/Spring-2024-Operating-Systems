public class BufferTest 
{
    public static void main(String[] args)
    {
        BufferImpl Test = new BufferImpl(5, 3, 8, 10);

        Test.insert(80);

        System.out.println("The current bufferSize is " + Test.remove());
    }
}
