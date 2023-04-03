package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertification {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get(" https://login.salesforce.com/ ");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listname = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listname.get(1));
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		driver.findElement(By.xpath("(//button[text()='Accept All Cookies'])[2]")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(2);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		shadow.setImplicitWait(2);
		WebElement learningElement = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions actions = new Actions(driver);
		actions.moveToElement(learningElement).perform();
		shadow.setImplicitWait(3);

		WebElement findElementByXPath = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		actions.moveToElement(findElementByXPath).click().perform();

		driver.findElement(By.xpath("(//button[text()='Accept All Cookies'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).click();
		String text2 = driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[2]")).getText();
		System.out.println("Role As:" + text2);
		String text = driver.findElement(By.xpath("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']")).getText();
		System.out.println("Summary of Salesforce Arctitect:"  +text);
		List<WebElement> Certification = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement webElement : Certification) {
			System.out.println(webElement.getText());
			
		}
		driver.findElement(By.xpath("(//div[@class='credentials-card_title'])[1]")).click();
		List<WebElement> Applicationartictest = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement webElement :Applicationartictest) {		
			
			System.out.println(webElement.getText());
		}
		

	}

}
