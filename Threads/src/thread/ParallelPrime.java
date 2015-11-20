package thread;

import java.util.ArrayList;
import java.util.List;

public class ParallelPrime {
	static final int MAX_LIMIT = 10000;

	public static void main(String[] args) {
		try{
			Long bigNum = new Long(Math.abs(10001));
			int startVal = 0;
			int remainder = 0;
			int numberOfThreads = 0;
			int maxPrime = 0;
			List<Long> numList = new ArrayList<>();
			if(bigNum > MAX_LIMIT){
				while(startVal < bigNum){
					remainder = Math.abs(startVal - bigNum.intValue());
					if(remainder > MAX_LIMIT){
						startVal = (startVal + MAX_LIMIT);
						numList.add((long)startVal);
					}else{
						startVal = (startVal + Math.abs(remainder));
						numList.add((long)startVal);
					}
				}
			}else{
				numList.add(bigNum);
			}
			numberOfThreads = numList.size();
			
			Runnable r = new Runnable() {
				@Override
				public void run() {
					maxPrime = MaxPrime.findprime(1, 10000, 1);
				}
			};

		}catch(NumberFormatException nem){
			System.out.println("Please a positive number less than " + Long.MAX_VALUE);
		}
	}

}
