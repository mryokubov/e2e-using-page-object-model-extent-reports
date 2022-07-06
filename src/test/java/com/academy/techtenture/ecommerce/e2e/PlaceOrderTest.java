package com.academy.techtenture.ecommerce.e2e;
import com.academy.techcenture.ecommerce.pages.*;

import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Map;

public class PlaceOrderTest extends BaseTest {

    @Test(priority = 0,  dataProvider = "ProductPage")
    public void placeOrderRegisteredUserTest( Map<String,String> data ) throws IOException, InterruptedException {

        extentTest = extentReports.startTest("place order positive test");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        SummaryTabPage summaryTabPage = new SummaryTabPage(driver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);

        homePage.clickSingInLink();
        extentTest.log(LogStatus.INFO, "clicked on sign in link");
        loginPage.login();
        extentTest.log(LogStatus.INFO, "Logged in successfully");
        homePage.searchProduct(data);
        extentTest.log(LogStatus.INFO, "Search product successfully");
        productPage.verifyingTheProductPage(data);
        extentTest.log(LogStatus.INFO, "Product was successfully added");

        summaryTabPage.verifyShoppingCartSummary(data);

        extentTest.log(LogStatus.INFO, "Navigated to order history page");
        orderHistoryPage.verifyOrderHistory(data);
        homePage.signOut();

        extentTest.log(LogStatus.INFO, "Place order finished successfully");
    }

    @DataProvider(name = "ProductPage")
    public Object[][] getNewUsersData(){
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "ProductPage");
        return excelReader.getData();
    }
}
