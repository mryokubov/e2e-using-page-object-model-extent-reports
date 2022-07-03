package com.academy.techtenture.ecommerce.e2e;

import com.academy.techcenture.ecommerce.pages.HomePage;
import com.academy.techcenture.ecommerce.pages.LoginPage;
import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.academy.techcenture.ecommerce.pages.ContactUsPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;

public class ContactUsTest extends BaseTest {


    @Test(priority = 0,  dataProvider = "contactUs")
    public void contactUsPositiveTest( Map<String,String> data ) throws InterruptedException {

        extentTest = extentReports.startTest("contact us functionality positive test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        if (data.get("guest").equals("no")){
            extentTest.log(LogStatus.INFO, "Logged in as a valid customer");
            homePage.clickSingInLink();
            extentTest.log(LogStatus.INFO, "Clicked on sign in link");
            loginPage.login();
            extentTest.log(LogStatus.INFO, "Logged in successfully");
        }

        homePage.clickContactUsLink();
        extentTest.log(LogStatus.INFO, "Clicked on contact us link");
        contactUsPage.contactUs(data);
        extentTest.log(LogStatus.INFO, "Contact us finished successfully");

    }

    @DataProvider(name = "contactUs")
    public Object[][] getNewUsersData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "contactUs");
        return excelReader.getData();
    }


}
