package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" https://dev57553.service-now.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.id("sysverb_login")).click();

		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.setImplicitWait(10);
		// shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service
		// Catalog");
		// shadow.setImplicitWait(10);
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();

		shadow.setImplicitWait(10);
		WebElement frameelement = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameelement);
		driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles') ]  ")).click();

		driver.findElement(By.xpath("//a[@id='item_link_bd6fa75a4f334200086eeed18110c79e']")).click();
		driver.findElement(By.xpath("//select[@id='IO:8350086e4f334200086eeed18110c7cd']")).click();
		driver.findElement(By.xpath("//option[text()='Gold']")).click();
		driver.findElement(By.xpath("//select[@id='IO:32e0886e4f334200086eeed18110c738']")).click();
		driver.findElement(By.xpath("//option[text()='128']")).click();
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		System.out.println(text2);
		String text = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number is:" + text);
	}
}
