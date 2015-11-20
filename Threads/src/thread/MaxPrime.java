package thread;

public class MaxPrime {
	
	public static int findprime(int _startVal,int _endVal,int maxPrime){
		boolean divisible=false;
		if(_startVal <= _endVal){
			for(int val = (_startVal-1);val>1;val--){
				if(_startVal%val==0){
					divisible = true;
				}
			}
			if(!divisible)
				maxPrime = _startVal;
		}else{
			return maxPrime;
		}
		return findprime(_startVal+1,_endVal,maxPrime);
	}

	public static void main(String[] args) {
		System.out.println(findprime(1,99999,1));
	}
}
