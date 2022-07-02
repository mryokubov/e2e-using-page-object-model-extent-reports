package com.academy.techtenture.ecommerce.base;

import com.academy.techcenture.ecommerce.config.ConfigReader;
import com.academy.techcenture.ecommerce.config.Driver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseTest {

    protected WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;
    protected String browserName;
    protected String browserVersion;


    @BeforeTest
    public void beforeTest(){
        extentReports = new ExtentReports(  System.getProperty("user.dir") + "/test-output/ExtentReports.html", true);
        extentReports.addSystemInfo( "OS NAME" , System.getProperty("os.name"));
        extentReports.addSystemInfo("ENGINEER", System.getProperty("user.name"));
        extentReports.addSystemInfo("ENVIRONMENT", "QA");
        extentReports.addSystemInfo("JAVA VERSION", System.getProperty("java.version"));
    }

    @AfterTest
    public void afterTest(){
        extentReports.flush();
        extentReports.close();
    }


    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("URL"));
        Capabilities browserCap = ((RemoteWebDriver) driver).getCapabilities();
        browserName = browserCap.getBrowserName();
        browserVersion = browserCap.getBrowserVersion();
        extentReports.addSystemInfo("BROWSER NAME", browserName);
        extentReports.addSystemInfo("BROWSER VERSION", browserVersion);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {

        if(result.getStatus()==ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName());
            extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable());

            String screenshotPath = getScreenshot(driver, result.getName());
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath));

        }
        else if(result.getStatus()==ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
        }
        else if(result.getStatus()==ITestResult.SUCCESS){
            extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

        }

        extentReports.endTest(extentTest);

        if (driver != null){
            driver.quit();
        }
    }


    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String filename = screenshotName + dateName + ".png";
        String destination =  System.getProperty("user.dir") + "/test-output/" + filename;
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return filename;
    }

}
