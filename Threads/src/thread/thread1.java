package thread;

public class thread1 {

	public static void main(String[] args) {
		try{
			commonObj c1 = new commonObj();
			Runnable r1 = new Runnable() {
				
				@Override
				public void run() {
					c1.sum(10);
				}
			};
			
			Runnable r2 = new Runnable() {
				
				@Override
				public void run() {
					c1.sum(100);
				}
			};
			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);
			t1.start();
			t2.start();
			t2.join();
			c1.print();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
