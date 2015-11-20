package thread;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PrimeMain {
	static final int MAX_LIMIT = 10000;

	public static void main(String[] args) {
		try{
			Long bigNum = new Long(Math.abs(99999));
			int startVal = 0;
			int remainder = 0;
			int numberOfSplits = 0;
			int _startVal = 1;
			int _endVal = 0;
			List<Integer> numList = new ArrayList<>();
			List<Integer> primesList = new ArrayList<>();
			if(bigNum > MAX_LIMIT){
				while(startVal < bigNum){
					remainder = Math.abs(startVal - bigNum.intValue());
					if(remainder > MAX_LIMIT){
						startVal = (startVal + MAX_LIMIT);
						numList.add(startVal);
					}else{
						startVal = (startVal + Math.abs(remainder));
						numList.add(startVal);
					}
				}
			}else{
				numList.add(bigNum.intValue());
			}
			numberOfSplits = numList.size();
			Thread t = null;
			ParallelPrime pp = null;
			long startTime = System.currentTimeMillis();
			for(int i=0;i<numberOfSplits;i++){
				if(i == 0){
					_startVal = 1;
				}else{
					_startVal = numList.get(i-1) + 1;
				}
				pp = new ParallelPrime(_startVal, numList.get(i), 1);
				t = new Thread(pp);
				t.start();
			}
			t.join();
			long endTime = System.currentTimeMillis();
			long totalTime = (endTime - startTime) / 1000;
			Runtime.getRuntime().gc();
			System.out.println("With Threads");
			System.out.println("Largest Prime  : " + pp.getReturnedPrime());
			System.out.println("Total number of threads spawned : " + numList.size());
			System.out.println("Time taken : " + totalTime + "secs");
		}catch(NumberFormatException nem){
			System.out.println("Please a positive number less than " + Long.MAX_VALUE);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
