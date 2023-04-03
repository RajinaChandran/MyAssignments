package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class NewCaller {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://dev57553.service-now.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.id("sysverb_login")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.setImplicitWait(10);

		shadow.findElementByXPath("//input[@id='filter']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers");
		shadow.setImplicitWait(5);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//mark[text()='Callers']").click();
		Thread.sleep(2000);

		WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		// driver.findElement(By.xpath("//input[@id='sys_user.user_name']")).sendKeys("Wily123");
		driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Rajina");
		driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("Chandran");
		driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("Junior Developer");
		driver.findElement(By.xpath("//input[@id='sys_display.sys_user.department']")).sendKeys("Development");

		driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("rajinaocas@gmail.com");

		Thread.sleep(2000);
		WebElement language = driver.findElement(By.id("sys_user.preferred_language"));
		Select drop1 = new Select(language);
		drop1.selectByVisibleText("English");

		WebElement timezone = driver.findElement(By.xpath("//select[@id='sys_user.time_zone']"));
		Select drop2 = new Select(timezone);
		drop2.selectByVisibleText("Europe/Amsterdam");

		WebElement dateformat = driver.findElement(By.xpath("//select[@id='sys_user.date_format']"));
		Select drop3 = new Select(dateformat);
		drop3.selectByIndex(2);

		driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("644000000");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		shadow.setImplicitWait(10);
		String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("(//input[@placeholder='Search'])[3]")).sendKeys("Rajina Chandran", Keys.ENTER);
		String text2 = driver.findElement(By.xpath("//td[text()='rajinaocas@gmail.com']")).getText();

		if (text2.equals("rajinaocas@gmail.com")) {
			System.out.println("Verified");

		} else {
			System.out.println("Not Verified");
		}

	}
}
