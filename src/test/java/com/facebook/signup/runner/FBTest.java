package com.facebook.signup.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {
		"com.facebook.signup" }, monochrome = true, features = "src/test/resources/Features", format = { "pretty"},
				tags = {"@Positive"},
				dryRun=false)

public class FBTest {

}
