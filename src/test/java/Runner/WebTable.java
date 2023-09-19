package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Features/WebTable.feature", 
                 glue = "Test_Scenarios", 
                 tags = "@Test1")

public class WebTable {

}
