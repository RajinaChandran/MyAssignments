package week1.day1;

public class Mobile1 {
	public void makeCall() {
		String mobileModel = "POCOX3";
		float mobileWeight = 5.56f;
		System.out.println("Mobile Model=" + mobileModel);
		System.out.println("Mobile Weight=" + mobileWeight);
	}

	public void sendMsg() {
		boolean fullCharged = true;
		int mobileCost = 16000;
		System.out.println("Mobile Cost=" + mobileCost);
		System.out.println("FullCharged=" + fullCharged);
	}

	public static void main(String[] args) {
		System.out.println("This is my mobile");
		Mobile1 mobile1 = new Mobile1();
		mobile1.makeCall();
		mobile1.sendMsg();
		
	}

}
