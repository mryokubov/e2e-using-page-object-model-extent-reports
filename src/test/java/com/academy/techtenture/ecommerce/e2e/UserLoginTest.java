package com.academy.techtenture.ecommerce.e2e;
import com.academy.techcenture.ecommerce.pages.HomePage;
import com.academy.techcenture.ecommerce.pages.LoginPage;
import com.academy.techcenture.ecommerce.pages.UserAccountPage;
import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class UserLoginTest extends BaseTest {


    @Test(priority = 0, dataProvider = "userLoginData")
    public void userLoginPositive(Map<String,String> users) {
        extentTest = extentReports.startTest("user login positive test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        homePage.clickSingInLink();
        extentTest.log(LogStatus.INFO, "clicked on sign in link");
        loginPage.login(users);
        extentTest.log(LogStatus.INFO, "logged in with " + users.get("email"));
        userAccountPage.verifyAccountOptions();
        extentTest.log(LogStatus.PASS, "verified account options");
        userAccountPage.navigateHome();
        extentTest.log(LogStatus.INFO, "navigated back to home page");
        homePage.signOut();
        extentTest.log(LogStatus.INFO, "signed out successfully");
    }

    @Test(priority = 1, dataProvider = "invalidUserLoginData")
    public void userLoginNegative(Map<String,String> users) throws InterruptedException {
        extentTest = extentReports.startTest("user login negative test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickSingInLink();
        extentTest.log(LogStatus.INFO, "clicked on sign in link");
        loginPage.verifyLoginErrors(users);
        extentTest.log(LogStatus.PASS, "verified login errors successfully");
    }


    @DataProvider(name = "userLoginData")
    public Object[][] getNewUsersData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "userLogin");
        return excelReader.getData();
    }

    @DataProvider(name = "invalidUserLoginData")
    public Object[][] getInvalidUserLoginData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "negativeLogin");
        return excelReader.getData();
    }
}
