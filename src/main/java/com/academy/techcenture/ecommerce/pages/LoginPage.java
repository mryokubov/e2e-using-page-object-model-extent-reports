package com.academy.techcenture.ecommerce.pages;

import com.academy.techcenture.ecommerce.config.ConfigReader;
import com.academy.techcenture.ecommerce.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage {
    //1. web elements
    //2. methods (user actions)
    //3. assertions

    private WebDriver driver;
    private CommonUtils commonUtils;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver)  {
        this.driver = driver;
        this.commonUtils = new CommonUtils();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    //web elements
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "passwd")
    private WebElement passwdInput;

    @FindBy(id = "SubmitLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[contains(text(),'Already registered?')]")
    private WebElement loginHeaderTxt;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='passwd']")
    private WebElement passwdLabel;

    @FindBy(xpath = "//a[contains(@title, 'Recover your forgotten')]")
    private WebElement forgotPswdLink;

    @FindBy(xpath = "//h3[contains(text(),'Create an account')]")
    private WebElement createAccountHeaderTxt;

    @FindBy(xpath = "//p[contains(text(),'Please enter your email address')]")
    private WebElement enterEmailTxt;

    @FindBy(xpath = "//label[@for='email_create']")
    private WebElement createAccountEmailLabel;

    @FindBy(id = "email_create")
    private WebElement createEmailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//div[contains(@class,'alert-danger')]//li")
    private WebElement authFailerErrorMsg;

    @FindBy(id = "create_account_error")
    private WebElement invalidEmailErrorMsg;

    private String[] invalidEmailAddress = {"kevin.lee@gmail","kevin.leegmail.com","kevin.lee", "12345", "4875494@yahoo"};

    //actions
    public void login(){
        assertTrue(loginHeaderTxt.isDisplayed(), "Login Header was not displayed");
        assertTrue(emailLabel.isDisplayed(), "Email label was not dipslayed");
        assertTrue(passwdLabel.isDisplayed(), "Password label was not dipslayed");
        emailInput.clear();

        emailInput.sendKeys(ConfigReader.getProperty("username"));
        passwdInput.clear();
        passwdInput.sendKeys(ConfigReader.getProperty("password"));

        assertTrue(forgotPswdLink.isDisplayed(),"Forgot passwd is not displayed");
        assertTrue(loginBtn.isEnabled(), "Login Btn is not enabled");
        assertEquals("sign in", loginBtn.getText().toLowerCase().trim());
        loginBtn.click();
        System.out.println("Clicking login btn");
    }

    /**
     * This method reads user credentials from excel sheet
     * @param users
     */
    public void login(Map<String,String> users){
        assertTrue(loginHeaderTxt.isDisplayed(), "Login Header was not displayed");
        assertTrue(emailLabel.isDisplayed(), "Email label was not dipslayed");
        assertTrue(passwdLabel.isDisplayed(), "Password label was not dipslayed");
        emailInput.clear();

        emailInput.sendKeys(users.get("email"));
        passwdInput.clear();
        passwdInput.sendKeys(users.get("password"));

        assertTrue(forgotPswdLink.isDisplayed(),"Forgot passwd is not displayed");
        assertTrue(loginBtn.isEnabled(), "Login Btn is not enabled");
        assertEquals("sign in", loginBtn.getText().toLowerCase().trim());
        loginBtn.click();
        System.out.println("Clicking login btn");
    }


    public void verifyLoginErrors(Map<String,String> users) throws InterruptedException {
        //provide incorrect user creds
        emailInput.sendKeys(users.get("email"));
        passwdInput.sendKeys(users.get("password"));
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]//li"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        assertTrue(errorMsg.getText().equals(users.get("errorMessages")),"Error Message is not cocrect");
    }

    public void enterNewEmailAddress(Map<String,String> users) throws IOException {
        assertTrue(createAccountHeaderTxt.isDisplayed());
        assertTrue(enterEmailTxt.isDisplayed());
        assertTrue(createAccountEmailLabel.isDisplayed());

        String email = users.get("email");
        ConfigReader.setProperty("newEmail", email);
        createEmailInput.sendKeys(email);

        assertTrue(createAccountBtn.isEnabled());
        createAccountBtn.click();
    }

    public void enterRandomEmail(){
        createEmailInput.sendKeys(commonUtils.randomEmail());
        assertTrue(createAccountBtn.isEnabled());
        createAccountBtn.click();
    }

    public void verifyInvalidEmailAddresses(Map<String,String> users) throws InterruptedException {

            createEmailInput.sendKeys(users.get("email")); //kein@gmail
            assertTrue(createAccountBtn.isEnabled());
            createAccountBtn.click();

            wait.until(ExpectedConditions.visibilityOf(invalidEmailErrorMsg));

            assertEquals(invalidEmailErrorMsg.getText().trim(), users.get("errorMessages"), "Error message is not correct");
            Thread.sleep(1000);
    }














}
