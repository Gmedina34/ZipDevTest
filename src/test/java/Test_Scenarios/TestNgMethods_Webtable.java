package Test_Scenarios;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Test_Pages.DataTableSelection;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgMethods_Webtable {

	WebDriver driver;

	@BeforeTest
	public void beforeTest()  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.primefaces.org/primereact-v5/#/datatable/selection");

	}

	@Test
	public void SelectName() {
//

		DataTableSelection page2 = new DataTableSelection(driver);

		page2.targetTable();
		page2.Actions("Name", "Blue Band");

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		
		
		// Wait briefly for demonstration purposes
		Thread.sleep(3000);

		driver.quit();
	}

}
