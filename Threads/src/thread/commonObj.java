package thread;

public class commonObj {
	private int sum = 0;
	public void sum(int n){
		try {
			sum = sum + n;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print(){
		System.out.println(sum);
	}
}
