package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class NewProposal {

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

		shadow.findElementByXPath("//input[@id='filter']").click();
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//input[@id='filter']").sendKeys("My Proposal");
		shadow.setImplicitWait(5);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//mark[@class='filter-match']").click();
		Thread.sleep(2000);
		WebElement iframe = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("//button[@id='sysverb_new']")).click();
		driver.findElement(By.id("std_change_proposal.short_description")).sendKeys("Request for Help");
		
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();

		String proposal = driver.findElement(By.xpath("(//a[@class='linked formlink'])[1]")).getText();
		System.out.println("Proposal Number is:" + proposal);

		driver.close();

	}

}
