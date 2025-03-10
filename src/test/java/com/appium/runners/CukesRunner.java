package com.appium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "pretty"
        },
        glue = "com/appium/step_def",
        dryRun = true,
        features = "src/test/resources/features",
        tags = ""
)

public class CukesRunner {

}
