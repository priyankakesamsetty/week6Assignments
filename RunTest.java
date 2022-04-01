package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "Week6Assignments/Featurefiles/MergeLead.feature", glue ="Steps",monochrome= true)
public class RunTest  extends  AbstractTestNGCucumberTests{

}
