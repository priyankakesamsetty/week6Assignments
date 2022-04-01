package Week6Day2Tags.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Week6Day2Tags/Featurefiles", glue ="Steps",monochrome= true,tags="@functional")
public class RunStep  extends  AbstractTestNGCucumberTests{

}


