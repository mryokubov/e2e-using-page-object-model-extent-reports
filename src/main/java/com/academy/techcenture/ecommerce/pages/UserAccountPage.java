package com.academy.techcenture.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserAccountPage {

    private WebDriver driver;

    public UserAccountPage(WebDriver driver)  {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "logout")
    private WebElement signOutLink;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement accountLink;

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement myAccntHeader;

    @FindBy(xpath = "//div[contains(@class,'addresses-lists')]//ul/li//span")
    private List<WebElement> accountOptions;

    @FindBy(className = "info-account")
    private WebElement welcomeMsgTxt;

    @FindBy(xpath = "//a[@title='Home']")
    private WebElement homeBtn;


    private String[] accountOptionsExpected = {"order history and details",
    "my credit slips", "my addresses","my personal information","my wishlists"};


    public void signOut(){
        assertTrue(signOutLink.isDisplayed(), "Sign out is not displayed");
        signOutLink.click();
        System.out.println("Clicking sign out");
    }

    public void verifyAccountOptions(){
        assertEquals(5, accountOptions.size());
        for (int i = 0; i < accountOptions.size(); i++) {
            assertEquals(accountOptions.get(i).getText().toLowerCase(), accountOptionsExpected[i],
                    "account option did not match " + accountOptionsExpected[i]);
        }
    }

    public void navigateHome(){
        assertTrue(homeBtn.isDisplayed());
        homeBtn.click();
    }




}



