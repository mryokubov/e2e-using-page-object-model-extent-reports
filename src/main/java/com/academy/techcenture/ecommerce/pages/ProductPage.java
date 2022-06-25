package com.academy.techcenture.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ProductPage extends HomePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadcrumb;

    @FindBy(xpath = "//h1")
    private WebElement productHeader;

    @FindBy(id = "product_reference")
    private WebElement productReference;

    @FindBy(id = "product_condition")
    private WebElement productCondition;

    @FindBy(xpath = "//div[@id='short_description_content']//p[contains(text(),'Long printed')]")
    private WebElement shortDescriptionContent;

    @FindBy(xpath = "//p[contains(@class,'socialsharing_product')]/button")
    private List<WebElement> socialNetworksLinks;

    @FindBy(xpath = "//a[@class='open-comment-form']")
    private WebElement writeReview;

    @FindBy(xpath = "(//h2[@class='page-subheading'][1])[2]")
    private WebElement reviewHeader;

    @FindBy(xpath = "//h2[.='Write a review']")
    private WebElement reviewSubheading;

    @FindBy(xpath = "(//p[contains(.,'Printed Summer Dress')])[2]")
    private WebElement reviewProductName;

    @FindBy(xpath = "(//p[contains(text(),'Long printed dress')])[3]")
    private WebElement reviewDescription;

    @FindBy(xpath = "//div[@class = 'star star_on']")
    private List<WebElement> reviewStars;

    @FindBy(xpath = "//a[@title='Cancel Rating']")
    private WebElement reviewCancelBtn;

    @FindBy(id = "comment_title")
    private WebElement reviewCommentTitleInput;

    @FindBy(id = "content")
    private WebElement reviewCommentInput;

    @FindBy(id = "submitNewMessage")
    private WebElement submitNewMessage;

    @FindBy(xpath = "(//a[@class='closefb'])[last()]")
    private WebElement reviewCloseBtn;

    @FindBy(xpath = "//h2[.='New comment']")
    private WebElement popUpCommentHeaderTxt;

    @FindBy(xpath = "//p[contains( .,'Your comment')]")
    private WebElement popUpMessage;

    @FindBy (className = "submit")
    private WebElement okBtn;

    @FindBy(id = "send_friend_button")
    private WebElement sendFriends;

    @FindBy(xpath = "//h2[contains(.,'Send to a friend')]")
    private WebElement sendFriendHeader;

    @FindBy(id="friend_email")
    private WebElement friendsEmailInput;

    @FindBy(id = "friend_name")
    private WebElement friendNameInput;

    @FindBy(id = "sendEmail")
    private WebElement sendEmailButton;

    @FindBy(xpath = "(//p[contains(text(),'Long printed')])[3]")
    private WebElement sendFriendDescribe;

    @FindBy(xpath = "(//a[@class='closefb'])[2]")
    private WebElement sendFriendCloseBtn;

    @FindBy(xpath = "//h2[.='Send to a friend']")
    private WebElement sendFriendsToHeader;

    @FindBy(xpath = "//p[contains(.,'Your e-mail has been')]")
    private WebElement emailMsgSuccessfully;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement sendFriendOkBtn;

    @FindBy(id="our_price_display")
    private WebElement priceAfterDiscount;

    @FindBy(id="reduction_percent_display")
    private WebElement reductionPrecent;

    @FindBy(id="old_price_display")
    private WebElement priceBeforeDiscount;

    @FindBy(id="quantity_wanted")
    private WebElement quantityInput;

    @FindBy(className="icon-minus")
    private WebElement minusBtn;

    @FindBy(className="icon-plus")
    private WebElement plusBtn;

    @FindBy(id="group_1")
    private WebElement sizeOptions;

    @FindBy(id="color_to_pick_list")
    private List<WebElement> colors;

    @FindBy(xpath="//button[@name='Submit']")
    private WebElement addToCartBtn;

    @FindBy(id="wishlist_button")
    private WebElement wishListBtn;

    @FindBy(id="product_payment_logos")
    private WebElement paymentLogos;

    @FindBy(xpath="//section[@class='page-product-box'][1]/h3")
    private WebElement dataSheetHeader;

    @FindBy(xpath="//table[@class='table-data-sheet']/tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath="//table[@class='table-data-sheet']/tbody/tr[1]/td")
    private List<WebElement> tableCols;

    @FindBy(xpath="//section[@class='page-product-box'][2]/h3")
    private WebElement moreInfoHeader;

    @FindBy(xpath="//div[@class='rte']/p")
    private WebElement moreInfoText;

    @FindBy(xpath = "(//h3[contains(@class,'page-product-heading')])[3]")
    private WebElement reviews;

    @FindBy(className = "align_center")
    private WebElement reviewsText;

    @FindBy(xpath = "//div[@class='layer_cart_product_info']//span")
    private List<WebElement> addToCartLayersProductInfo;

    @FindBy(xpath = "//div[@class='layer_cart_row']")
    private List<WebElement> addToCartPricesInfo;

    @FindBy(xpath = "//span[contains(@class,'btn btn-default')]")
    private WebElement continueBtn;

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    private WebElement proceedCheckOutBtn;

    private String[] socialNetworksLinksExpected = {"tweet",
            "share", "google+","pinterest"};


    public void verifyingTheProductPage(Map<String, String> data) {
        Assert.assertTrue(breadcrumb.isDisplayed(), "Bread crumb is not displayed");
        Assert.assertEquals(productHeader.getText().trim(), data.get("Name"), "Name isn't correct");
        Assert.assertEquals(productReference.getText().trim(), data.get("Reference"), "Reference isn't correct");
        Assert.assertEquals(productCondition.getText().trim(), data.get("Condition"));
        Assert.assertEquals(shortDescriptionContent.getText().trim(), data.get("Description"), "Description isn't correct");
        Assert.assertEquals(4, socialNetworksLinks.size(),"Number of Social links aren't 4");
        for (int i = 0; i < socialNetworksLinks.size(); i++) {
            assertEquals(socialNetworksLinks.get(i).getText().toLowerCase().trim(), socialNetworksLinksExpected[i],
                    "Network Link did not match " + socialNetworksLinksExpected[i]);
        }
        Assert.assertEquals(priceAfterDiscount.getText().trim().replace("$",""), data.get("Price After Discount"),"Price after discount isn't correct");
        Assert.assertEquals(priceBeforeDiscount.getText().trim().replace("$",""), data.get("Price Before Discount"),"Price before discount isn't correct");
        Assert.assertEquals(reductionPrecent.getText().trim().replace("-",""), data.get("Discount"),"Discount isn't correct");
        Assert.assertTrue(minusBtn.isEnabled(), "Plus btn is not enabled");
        Assert.assertTrue(plusBtn.isEnabled(), "Minus btn is not enabled");
        Assert.assertTrue(quantityInput.isEnabled(), "Quantity Input is not enabled");
        if(quantityInput.getText().trim().equals(1)){
            plusBtn.click();
        } else if (!quantityInput.getText().trim().equals(2)) {
            int quantity = Integer.parseInt(quantityInput.getText().trim());
            for (int i=1; i <= quantity; i ++) {
                minusBtn.click();
        }
    }
        Assert.assertTrue(sizeOptions.isEnabled(), "Size field is not enabled");
        Assert.assertEquals(colors.size(),data.get("Available Color"), "The number of colors does not match");
        Assert.assertTrue(wishListBtn.isEnabled(), "Wish button isn't enabled");
        Assert.assertTrue(paymentLogos.isDisplayed(), "Payment logos isn't displayed");
        Assert.assertTrue(dataSheetHeader.isDisplayed(), "Data Sheet Header isn't displayed");
        Assert.assertEquals(2, tableCols.size(),"Columns aren't 2");
        Assert.assertEquals(3, tableRows.size(),"Rows aren't 3");
        Assert.assertEquals(moreInfoHeader.getText().trim(),"More info", "Info Header isn't correct");
        Assert.assertEquals(moreInfoText.getText().trim(), data.get("Info Text"), "Info text isn't correct");
        Assert.assertEquals(reviews.getText().trim(),"Reviews" , "Review header isn't correct");
        Assert.assertEquals(reviewsText.isDisplayed() , "Review text isn't displayed");
        Assert.assertTrue(addToCartBtn.isEnabled(), "The add button isn't enabled");
        addToCartBtn.click();
    }
    public void verifyingReviewPopUp (Map<String, String> data) {
        Assert.assertTrue(writeReview.isDisplayed(), "Review field is not displayed");
        writeReview.click();
        Assert.assertEquals(reviewHeader.getText().trim().toUpperCase(),"WRITE A REVIEW", "Header of review page isn't correct");
        Assert.assertEquals(reviewSubheading.getText().trim().toUpperCase(),"WRITE A REVIEW", "Sub-header of review page isn't correct");
        Assert.assertEquals(reviewProductName.getText().trim(), data.get("Name"), "Name of review page isn't correct");
        Assert.assertEquals(reviewDescription.getText().trim(), data.get("Description"), "Description of review page isn't correct");
        Assert.assertEquals(5, reviewStars.size(), "Number of stars isn't 5");
        Assert.assertTrue(reviewCancelBtn.isEnabled(), "Cancel button isn't displayed ");
        Assert.assertTrue(reviewCommentTitleInput.isEnabled(), "Comment title field of review page isn't displayed ");
        reviewCommentTitleInput.click();
        reviewCommentTitleInput.sendKeys("not satisfied with the order");
        Assert.assertTrue(reviewCommentInput.isEnabled(), "Input field of review page isn't displayed ");
        reviewCommentInput.click();
        reviewCommentInput.sendKeys("This seller is terrible. Don't think to buy this");
        Assert.assertTrue(submitNewMessage.isEnabled(), "Submit button of review page isn't displayed ");
        submitNewMessage.click();
        Assert.assertEquals(popUpCommentHeaderTxt.getText().trim(),"New comment", "Title of pop-up verifying message isn't correct ");
        Assert.assertEquals(popUpMessage.getText().trim(),"Your comment has been added and will be available once approved by a moderator", "Message of pop-up verifying message isn't correct ");
        Assert.assertTrue(okBtn.isEnabled(), "Ok button isn't displayed on verifying message");
        okBtn.click();
    }




}
