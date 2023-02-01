
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer=new Buffer();
		Producer p=new Producer(buffer);
		Customer c=new Customer(buffer);
		Thread pThread=new Thread(p);
		Thread cThread=new Thread(c);
		pThread.start();
		cThread.start();
	}

}
