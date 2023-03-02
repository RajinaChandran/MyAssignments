package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13 };
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			sum = arr[i] + arr[i + 1];
			System.out.println(sum);

		}

	}

}
