package week1.day2;

public class OddNumber {
public static void main(String[] args) {
	int i=35;
	if (i%2==0) {
		System.out.println("Even number");
	} else {
System.out.println(" Odd Number");
	}
	//Number is odd from 1 to 20
	for (int j = 1; j <= 20; j++) {
		if (j%2==1) {
			System.out.println(j);
		} 
	}
}
}
