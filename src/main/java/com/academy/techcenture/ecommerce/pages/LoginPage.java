package com.academy.techcenture.ecommerce.pages;

import com.academy.techcenture.ecommerce.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.io.IOException;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends HomePage{

    public LoginPage(WebDriver driver)  {
        super(driver);
    }


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

        log.info("verifying login header");
        assertTrue(loginHeaderTxt.isDisplayed(), "Login Header was not displayed");
        log.info("verifying email label is displayed");
        assertTrue(emailLabel.isDisplayed(), "Email label was not dipslayed");
        log.info("verifying login header");
        assertTrue(passwdLabel.isDisplayed(), "Password label was not dipslayed");
        log.info("clearing email input");
        emailInput.clear();

        log.info("sending username " + ConfigReader.getProperty("username"));
        emailInput.sendKeys(ConfigReader.getProperty("username"));
        passwdInput.clear();
        log.info("entering password");
        passwdInput.sendKeys(ConfigReader.getProperty("password"));

        log.info("verifying forgot passwrod link is dislayed");
        assertTrue(forgotPswdLink.isDisplayed(),"Forgot passwd is not displayed");
        log.info("verifying login button is enabled");
        assertTrue(loginBtn.isEnabled(), "Login Btn is not enabled");
        assertEquals("sign in", loginBtn.getText().toLowerCase().trim());
        log.info("clicking login button");
        loginBtn.click();
    }

    /**
     * This method reads user credentials from excel sheet
     * @param users
     */
    public void login(Map<String,String> users){
        log.info("verifying login headers and labels");
        assertTrue(loginHeaderTxt.isDisplayed(), "Login Header was not displayed");
        assertTrue(emailLabel.isDisplayed(), "Email label was not dipslayed");
        assertTrue(passwdLabel.isDisplayed(), "Password label was not dipslayed");
        log.info("clearing email input field");
        emailInput.clear();

        log.info("sending " + users.get("email") + " to the input field");
        emailInput.sendKeys(users.get("email"));
        passwdInput.clear();
        log.info("sending the password to the password field");
        passwdInput.sendKeys(users.get("password"));

        assertTrue(forgotPswdLink.isDisplayed(),"Forgot passwd is not displayed");
        assertTrue(loginBtn.isEnabled(), "Login Btn is not enabled");
        assertEquals("sign in", loginBtn.getText().toLowerCase().trim());
        log.info("clickin login button");
        loginBtn.click();

    }


    public void verifyLoginErrors(Map<String,String> users) throws InterruptedException {
        //provide incorrect user creds
        log.info("entering " + users.get("email") + " in the email input ");
        emailInput.sendKeys(users.get("email"));
        log.info("entering passwrod to the passwrod field");
        passwdInput.sendKeys(users.get("password"));
        log.info("clicking login button");
        loginBtn.click();
        WebElement errorMsg = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]//li"));
        log.info("waiting for visibility of error msg");
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        assertTrue(errorMsg.getText().equals(users.get("errorMessages")),"Error Message is not cocrect");
    }

    public void enterNewEmailAddress(Map<String,String> users) throws IOException {
        log.info("veryfying labels and headers on new email address");
        assertTrue(createAccountHeaderTxt.isDisplayed());
        assertTrue(enterEmailTxt.isDisplayed());
        assertTrue(createAccountEmailLabel.isDisplayed());

        String email = users.get("email");
        ConfigReader.setProperty("newEmail", email);
        log.info("entering " + email + " to the email input");
        createEmailInput.sendKeys(email);

        assertTrue(createAccountBtn.isEnabled());
        if (createAccountBtn.isDisplayed()){
            log.info("login btn is di");
        }else{
            log.error("login btn is not displayed");
        }
        log.info("clicking on create account button");
        createAccountBtn.click();
    }

    public void enterRandomEmail(){

        String randomEmail = commonUtils.randomEmail();
        log.info("entering a random email addresss: " + randomEmail);
        createEmailInput.sendKeys(randomEmail);
        log.info("assertging and clickign on create new account button");
        assertTrue(createAccountBtn.isEnabled());
        createAccountBtn.click();
    }

    public void verifyInvalidEmailAddresses(Map<String,String> users) throws InterruptedException {

        log.info("entering an incorrect email address " + users.get("email"));
        createEmailInput.sendKeys(users.get("email")); //kein@gmail
        assertTrue(createAccountBtn.isEnabled());
        log.info("clicking on create account button");
        createAccountBtn.click();

        log.info("waiting for errro message");
        wait.until(ExpectedConditions.visibilityOf(invalidEmailErrorMsg));

        assertEquals(invalidEmailErrorMsg.getText().trim(), users.get("errorMessages"), "Error message is not correct");
        Thread.sleep(1000);
    }














}
