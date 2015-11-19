package thread;
/**
 * This program finds the maximum prime integer 
 * @author v774137
 *
 */
public class MaxPrimeInt {
	static int findprime(int _num,int maxPrime){
		int maxInt = 2000000;
		boolean divisible=false;
		if(_num <= maxInt){
			for(int val = (_num-1);val>1;val--){
				if(_num%val==0){
					divisible = true;
				}
			}
			if(!divisible)
				maxPrime = _num;
		}else{
			return maxPrime;
		}
		return findprime(_num+1,maxPrime);
	}
	public static void main(String[] args) {
		System.out.println(findprime(1,1));
	}
}
