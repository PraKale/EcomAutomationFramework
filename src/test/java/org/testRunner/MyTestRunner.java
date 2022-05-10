package org.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features="./src/test/resources/FeatureFiles",
		glue={"org.stepDefinitions","appliHooks"},
		dryRun=false,
		monochrome=true,
		plugin={"pretty", "html:target/HTMLRepo.html"}
		)
public class MyTestRunner {

}
