class Product{
	int id;
	public Product(int id) {
		this.id=id;
	}
	public String toString() {
		return "" +id;
	}
}
public class Buffer {
	Product[] p=new Product[10];
	int count=0;
	boolean mutex=false;
	
	public synchronized void put(Product product) throws InterruptedException {
		if(count==10) {
			this.wait();
		}else if(mutex){
			this.wait();
		}
		mutex=true;
		p[count]=product;
		count++;
		mutex=false;
		this.notify();
		System.out.println("�����˱��Ϊ"+product+"����Ʒ,��ʱ��"+count+"����Ʒ");
	}
	public synchronized Product get() throws InterruptedException {
		if(count==0) {
			this.wait();
		}else if(mutex){
			this.wait();
		}
		mutex=true;
		count--;
		Product pp=p[count];
		mutex=false;
		this.notify();
		System.out.println("�����˱��Ϊ"+pp.id+"����Ʒ,��ʱ��"+count+"����Ʒ");
		return pp;
	}
	
}
