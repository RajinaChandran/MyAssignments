package week1.day2;

public class Palindrome {

	public static void main(String[] args) {
		int num = 34343;
		int temp = num;
		int reverseNum = 0;
		while(temp > 0) {
		  int remainder = temp % 10;
		  reverseNum  = reverseNum  * 10 + remainder;
		  temp = temp / 10;
		}
		if(num == reverseNum ) {
			System.out.println(num+" is Palindrome ");
		} else {
			System.out.println(num+" is not a Palindrome ");
		}
	}

}
