package com.sparta.eng82.tests.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/testReport.html"},
        glue = "com/sparta/eng82/tests/stepdefs",
        tags = "@TraineeTests"
)


public class TraineeTestRunner {
}