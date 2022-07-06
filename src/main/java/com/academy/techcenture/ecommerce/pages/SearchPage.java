package com.academy.techcenture.ecommerce.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Map;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchPage extends HomePage{

    public SearchPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement resultCount;

    @FindBy(xpath = "//span[@class='lighter']")
    private WebElement searchKeywordHeader;

    @FindBy(xpath = "//p[contains(@class,'alert-warning')]")
    private WebElement noResultAlertDiv;


    public void verifySearch(Map<String, String> data) {

        searchInputBox.sendKeys( data.get("searchKeyword") + Keys.ENTER);

        String count = resultCount.getText().trim().split(" ")[0];

        if (!count.equals("0")){
            assertTrue(searchKeywordHeader.isDisplayed(), "Keyword header was not displayed");
            assertEquals(searchKeywordHeader.getText().trim(),  "\"" + data.get("searchKeyword").toUpperCase() + "\"");
        }else{
            assertTrue( noResultAlertDiv.isDisplayed(), "");
            assertEquals( noResultAlertDiv.getText().trim(), data.get("expectedMessage") + " \""+ data.get("searchKeyword") + "\"" , "Mismatch between search keywords");
        }
    }

}
