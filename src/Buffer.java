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
		System.out.println("生产了编号为"+product+"的商品,此时有"+count+"件商品");
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
		System.out.println("消费了编号为"+pp.id+"的商品,此时有"+count+"件商品");
		return pp;
	}
	
}
