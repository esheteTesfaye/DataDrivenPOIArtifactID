package DataDrivenTest;

import org.testng.annotations.Test;

import ReadingFromFile.ReadDataFromExcelFile;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class loginLogOutDataDrivenTest {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	@Test(dataProvider = "dp")
	public void f(String n, String s) {

		driver.findElement(By.name("userName")).sendKeys(n);
		driver.findElement(By.name("password")).sendKeys(s);
		driver.findElement(By.name("login")).click();
		Assert.assertTrue(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
		driver.findElement(By.partialLinkText("SIGN-OFF")).click();
		System.out.println(n + "....." + s);
	}

	@DataProvider
	public Object[][] dp() throws IOException {
		// call a method to read from excel file
		// store the record to two dimensional array
		// return the array
		ReadDataFromExcelFile readExcelObject = new ReadDataFromExcelFile();
		String filePath = "C:\\Users\\eshet\\eclipse-workspace\\DataDrivenPOIArtifactID\\src\\test\\java\\TestData\\Data.xlsx";
		String[][] data = readExcelObject.readEcel(filePath, "Sheet1");

		return data;

		/*
		 * return new Object[][] { new Object[] { "1", "a" }, new Object[] { "2", "b" },
		 * new Object[] { "c", "c" }, };
		 */
		// this comment is added for pushing to github
	}

}
