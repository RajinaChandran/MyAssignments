package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args) {
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

		 String text = driver.findElement(By.xpath("(//div[@class='roleMenu-item_text'])[1]")).getText();
		 System.out.println("This Page is:" +text);
		List<WebElement> certificates = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement webElement : certificates) {
			System.out.println(webElement.getText());
		}


	}
}
