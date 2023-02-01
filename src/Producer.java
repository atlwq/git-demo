
public class Producer implements Runnable{
	Buffer buffer;
	public Producer(Buffer buffer) {
		this.buffer=buffer;
	}
	
	@Override
	public void run() {
		for(int i=0;i<20;i++) {
			try {
				Product product=new Product(i+1);
				buffer.put(product);
				Thread.sleep(50);
			} catch (Exception e) {
				
			}
		}
	}

}
