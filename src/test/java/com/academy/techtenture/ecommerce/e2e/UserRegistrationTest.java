package com.academy.techtenture.ecommerce.e2e;

import com.academy.techcenture.ecommerce.pages.HomePage;
import com.academy.techcenture.ecommerce.pages.LoginPage;
import com.academy.techcenture.ecommerce.pages.UserAccountPage;
import com.academy.techcenture.ecommerce.pages.UserRegistrationPage;
import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class UserRegistrationTest extends BaseTest {


    @Test(priority = 0, dataProvider = "newUsersData")
    public void userRegistrationPositiveTest( Map<String,String> users ) throws IOException, InterruptedException {

        extentTest = extentReports.startTest("user registration positive test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserRegistrationPage registerPage = new UserRegistrationPage(driver);
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        homePage.clickSingInLink();
        extentTest.log(LogStatus.INFO, "clicked on sign in link");
        loginPage.enterNewEmailAddress(users);
        extentTest.log(LogStatus.INFO, "entered " + users.get("email") + " to email input");
        registerPage.registerUser(users);
        extentTest.log(LogStatus.PASS, "registered new user");
        userAccountPage.verifyAccountOptions();
        extentTest.log(LogStatus.PASS, "verified account options successfully");
        userAccountPage.navigateHome();
        extentTest.log(LogStatus.INFO, "navigated home");
        homePage.signOut();
        extentTest.log(LogStatus.INFO, "signed out successfully");

    }

    @Test(dataProvider = "invalidCreateAccountData")
    public void userRegisterInvalidEmail(Map<String,String> users) throws InterruptedException {
        extentTest = extentReports.startTest("user registration with invalid email test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.clickSingInLink();
        extentTest.log(LogStatus.INFO, "clicked on sign in link");
        loginPage.verifyInvalidEmailAddresses(users);
        extentTest.log(LogStatus.PASS, "verified all errors on login page when entering invalid emails");

    }

    @Test(dataProvider = "registerErrorMessages")
    public void verifyErrorsOnRegisterPage(Map<String,String> users) throws  InterruptedException {
        extentTest = extentReports.startTest("user registration negative test on registration page");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserRegistrationPage registerPage = new UserRegistrationPage(driver);

        homePage.clickSingInLink();
        extentTest.log(LogStatus.INFO, "clicked on sign in link");
       loginPage.enterRandomEmail();
        extentTest.log(LogStatus.INFO, "entered random email address");
        registerPage.verifyErrorsOnUserRegisterPage(users);
        extentTest.log(LogStatus.INFO, "verified all errors on registration page when clicked on register button");

    }


    @DataProvider(name = "newUsersData")
    public Object[][] getNewUsersData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "newUsers");
        return excelReader.getData();
    }

    @DataProvider(name = "invalidCreateAccountData")
    public Object[][] getInvalidCreateAccountData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "negativeAccountCreate");
        return excelReader.getData();
    }

    @DataProvider(name = "registerErrorMessages")
    public Object[][] getErrorMessagesOnRegister(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "registerErrorMessages");
        return excelReader.getData();
    }
}







