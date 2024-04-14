import java.util.ArrayList;

public class BufferImpl
{
	private int bufferSize;
	private int in, out, count;

	//Array List for the buffer size
	//Setting the bufferSize as a variable allows for later entry of bufferSize at runtime
	ArrayList<Integer> elements = new ArrayList<Integer>(bufferSize);

	public BufferImpl() {
		count = 0;
		in = 0;
		out = 0;
		bufferSize = 0;
	}

	//Value-Pass Constructor. I took code from my Object Oriented Programming course to set this up.
	public BufferImpl(int countVal, int inVal, int outVal, int bufferSizeVal)
	{
		count = countVal;
		in = inVal;
		out = outVal;
		bufferSize = bufferSizeVal;
	}

	// producers call this method
	public void insert(Integer item) {
		while (count == bufferSize)
			; // do nothing -- no free space

		// add an element to the buffer
		elements.add(item);
		in = (in + 1) % bufferSize;
		++count;
	}

	// consumers call this method
	public Integer remove() {
		Integer item = 0;
		while (count == 0)
			; // do nothing - nothing to consume

		elements.remove(item);
		out = (out + 1) % bufferSize;
		--count;

		return item;
	}
}

/*I'm not entirely sure if I got the right answer here or not. However, I changed as little as possible, while also keeping the integrity of the program intact. 

I have a feeling my "insert and remove" functions are messed up now, but this is what I settled on. I tried to run it in a main function I threw together really quick, and I am able to enter values. However, I can't quite seem to tackle the functions. Somewhere along the line my modifications need feedback.

I do feel like I completed the ArrayList and the removal of the generics and interface properly though. I also added the value pass constructor.

Lastly, the instructions at the top of this exam say to show all code running and give screenshots of output. However, the instructions for the question said there was no main needed. So, I just modified the code like instructed.


Sources Used: 
Oracle Docs for ArrayLists: https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
Oracle Docs for Passing Values: https://docs.oracle.com/javase/tutorial/java/javaOO/arguments.html
Objected Oriented Programming in-class program: Book.java
*/