package week5.day1;

import org.openqa.selenium.By;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends ProjectSpecificMethod {

	@Test(dataProvider = "fetchData")
	public void runCreateLead(String cname, String fname, String lname, String pnum) {

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(pnum);
		driver.findElement(By.name("submitButton")).click();
	}

	@DataProvider(name = "fetchData")
	public String[][] getdata() {
		String[][] data = new String[2][4];

		data[0][0] = "Infosys";
		data[0][1] = "Yazhini";
		data[0][2] = "Raja";
		data[0][3] = "99";

		data[1][0] = "TCS";
		data[1][1] = "jyothi";
		data[1][2] = "M";
		data[1][3] = "98";

		return data;
	}
}
