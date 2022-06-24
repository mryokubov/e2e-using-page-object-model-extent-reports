package com.academy.techtenture.ecommerce.e2e;

import com.academy.techcenture.ecommerce.pages.HomePage;
import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

//high level name for the functionality that you are testing
public class ProductVerificationTest extends BaseTest {


    @Test(dataProvider = "dresses")
    public void verifyProductTabsTest(Map<String,String> data) throws InterruptedException {
        extentTest = extentReports.startTest("verify product tabs test");
        HomePage homePage = new HomePage(driver);
        homePage.verifyProductTabs(data);
        extentTest.log(LogStatus.PASS, "verified all product tabs successfully");
    }


    @DataProvider (name = "dresses")
    public Object[][] getDresses(){
        return new ExcelReader("src/main/resources/testData/ecommerce.xlsx","dresses").getData();
    }




}
