package thread;

public class ParallelPrime implements Runnable{
	int _startVal;
	int _endVal;
	int maxPrime;
	int returnedPrime;
	
	ParallelPrime(int _startVal,int _endVal,int maxPrime){
		this._startVal = _startVal;
		this._endVal = _endVal;
		this.maxPrime = maxPrime;
	}
	
	@Override
	public void run() {
		returnedPrime = MaxPrime.findprime(_startVal, _endVal, maxPrime);
	}

	public int getReturnedPrime() {
		return returnedPrime;
	}

}
