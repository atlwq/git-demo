
public class Customer implements Runnable{
	Buffer buffer;
	public Customer(Buffer buffer) {
		this.buffer=buffer;
	}
	
	@Override
	public void run() {
		
		for(int i=0;i<20;i++)
		{
			try {
				buffer.get();
				Thread.sleep(200);
			} catch (Exception e) {
				
			}
		}
		
	}
}
