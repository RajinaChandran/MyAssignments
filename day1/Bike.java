package week1.day1;

public class Bike {
	public void applyBreak() {
		System.out.println("Applied break in Bike");
	}

	public void soundHorn() {
		System.out.println("Sound Horn in Bike");
	}

	public static void main(String[] args) {
		Bike bike = new Bike();
		bike.applyBreak();
		bike.soundHorn();

		Car car = new Car();
		car.applyBreak();
		car.soundHorn();

	}

}
