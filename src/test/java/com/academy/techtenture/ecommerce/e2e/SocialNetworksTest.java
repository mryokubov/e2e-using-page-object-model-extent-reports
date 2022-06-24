package com.academy.techtenture.ecommerce.e2e;

import com.academy.techcenture.ecommerce.pages.HomePage;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class SocialNetworksTest extends BaseTest {


    @Test
    public void verifyAutomationPracticeSocialNetworksTest() throws InterruptedException {
        extentTest = extentReports.startTest("verify social network apps test");
        HomePage homePage = new HomePage(driver);
        homePage.verifySocialNetworks();
        extentTest.log(LogStatus.PASS, "verified all social network apps successfully");
    }


}
