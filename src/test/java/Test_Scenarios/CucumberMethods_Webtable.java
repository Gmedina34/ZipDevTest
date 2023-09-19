package Test_Scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test_Pages.DataTableSelection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberMethods_Webtable {
	
	WebDriver driver;

	DataTableSelection obj;

	@Given("I navigate to the URL {string}")
	public void i_navigate_to_the_url(String string) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(string);
		
		 obj = new DataTableSelection(driver);

	}

	@Given("I locate the table with checkbox section")
	public void i_locate_the_table_with_checkbox_section() {

		obj.targetTable();

	}

	@When("I select the checkbox for the row with the {string} {string}")
	public void i_select_the_checkbox_for_the_row_with_the(String string1, String string2) {

		obj.Actions(string1, string2);
	}

	@Then("I close the web browser")
	public void i_close_the_web_browser() throws InterruptedException {
		
		// Wait briefly for demonstration purposes
				Thread.sleep(3000);

		driver.quit();
	}


}
