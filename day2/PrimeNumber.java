package week1.day2;


public class PrimeNumber {
	
	public static void main(String[] args) {
		
		int input = 1;
		boolean flag = false;
		
		if(input == 1) {
			System.out.println(" Not Prime");
		return;
		}
		
		
		for (int i = 2; i < input/2; i++) {
			int remainder = input % i;
			if(remainder == 0) {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println(" Not prime ");
			
		} else {
			System.out.println(" prime ");
		}
	}

}


