import java.util.Date;

public class Test
{
	public static void main(String[] args) {
		Channel<String> mailBox = new MessageQueue<String>();
		mailBox.send(new String("Hello World!"));

		String rightNow = mailBox.receive();
		System.out.println(rightNow);
	}
}
