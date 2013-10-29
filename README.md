cucumber-format-slf4j
=====================
[![Build Status](https://travis-ci.org/jhberges/cucumber-format-slf4j.png)](https://travis-ci.org/jhberges/cucumber-format-slf4j)

A Cucumber(-jvm) formatter that logs outcomes etc to your SLF4J setup.

How to use
==========
In your ```@CucumberOptions```:
    
    @RunWith(Cucumber.class)
    @CucumberOptions(format = {"cucumber.formatter.Slf4jFormatter"})
    public class MyRunnerIT {
    }

Then it's just a matter of configuring your SLF4J setup, for example with ```logback-test.xml```
   
