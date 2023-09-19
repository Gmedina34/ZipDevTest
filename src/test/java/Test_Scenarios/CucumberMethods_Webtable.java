package Test_Scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Test_Pages.DataTableSelection;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CucumberMethods_Webtable {

	private WebDriver driver;
	private DataTableSelection dataTableSelection;

	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		dataTableSelection = new DataTableSelection(driver);

	}

	@Given("I navigate to the URL {string}")
	public void i_navigate_to_the_url(String url) {
		driver.get(url);
	}

	@Given("I locate the table with checkbox section")
	public void i_locate_the_table_with_checkbox_section() {
		dataTableSelection.targetTable();
	}

	@When("I select the checkbox for the row with the {string} {string}")
	public void i_select_the_checkbox_for_the_row_with_the(String column, String value) {
		dataTableSelection.Actions(column, value);
	}

	@Then("I close the web browser")
	public void i_close_the_web_browser() throws InterruptedException {
		
		// Wait briefly for demonstration purposes
				Thread.sleep(3000);

		driver.quit();
	}

}
