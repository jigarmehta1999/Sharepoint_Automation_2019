package com.sharepoint.qa.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(	features = {"src\\test\\resources\\com\\sharepoint\\qa\\features\\NewBid.feature"},
					glue = {"com.sharepoint.qa.steps"},
					dryRun = false,
					strict = true,
					monochrome = true,
					
					plugin = {"pretty", "summary", "html:target/cucumbertestngreports/cucumbertestng-html", "json:target/cucumbertestngreports/cucumbertestng.json" })
					
public class MyTestNgRunnerTest extends AbstractTestNGCucumberTests {

}