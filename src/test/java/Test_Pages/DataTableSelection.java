package Test_Pages;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class DataTableSelection {

	WebDriver driver;
	
	
	public DataTableSelection(WebDriver driver) {

		this.driver = driver;
	}

	By targetTable = By.cssSelector("div:nth-child(6) > div:nth-child(2)");

	By RowTable = By.cssSelector("div:nth-child(6) > div:nth-child(2) > div > table > tbody tr");

	By ColumnTable = By.cssSelector("div:nth-child(6) > div:nth-child(2) > div >table > thead>tr>th");
	
	

	public void targetTable() {

		Actions actions = new Actions(driver);
		WebElement target = driver.findElement(targetTable);
		actions.moveToElement(target).perform();

	}

	public int TableRows() {

		List<WebElement> rowElements = driver.findElements(RowTable);

		int Rowsize = rowElements.size();

		return Rowsize;

	}

	public int TableColumns() {

		List<WebElement> columnList = driver.findElements(ColumnTable);

		int columnsize = columnList.size();

		return columnsize;
	}

	public List<LinkedHashMap<String, String>> storeTableData() {

		List<LinkedHashMap<String, String>> rowDataList = new ArrayList<>();

		for (int row = 1; row <= TableRows(); row++) {

			LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();

			for (int column = 2; column <= TableColumns(); column++) {
				
				

				String columnName = driver.findElement(
						By.cssSelector("div:nth-child(6) > div:nth-child(2) > div > table > thead > tr > th:nth-child("
								+ column + ")"))
						.getText();

				String columnValue = driver.findElement(
						By.cssSelector("div:nth-child(6) > div:nth-child(2) > div > table > tbody tr:nth-child(" + row
								+ ") > td:nth-child(" + column + ")"))
						.getText();

			

				rowMap.put(columnName, columnValue);

			}

			rowDataList.add(rowMap);

		}

		return rowDataList;

	}

	public void Actions(String String1, String String2) {

		for (int i = 0; i < storeTableData().size(); i++) {

			LinkedHashMap<String, String> row = storeTableData().get(i);
			int targetIndex;
			if (row.get(String1).equals(String2)) {

				targetIndex = i + 1;

				WebElement checkbox = driver.findElement(
						By.cssSelector("div:nth-child(6) > div:nth-child(2) > div > table >tbody tr:nth-child("
								+ targetIndex + ")>td:nth-child(1)"));
				checkbox.click();

			
				break;

			}

		}

	}

}
