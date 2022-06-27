package com.academy.techcenture.ecommerce.pages;

import com.academy.techcenture.ecommerce.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

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

    @FindBy(xpath = "(//span[@class='editable'])[last()]")
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

    @FindBy(xpath = "//div[contains(@class,'star')]/a")
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

    @FindBy( xpath = "//button[@value='true']")
    private WebElement okBtn;

    @FindBy(id = "send_friend_button")
    private WebElement sendFriends;

    @FindBy(xpath = "//h2[contains(.,'Send to a friend')]")
    private WebElement sendFriendHeader;

    @FindBy(id = "friend_email")
    private WebElement friendsEmailInput;

    @FindBy(id = "friend_name")
    private WebElement friendNameInput;

    @FindBy(id = "sendEmail")
    private WebElement sendEmailButton;

    @FindBy(xpath = "(//div[@class='product_desc']/p/strong)[last()]")
    private WebElement sendFriendProductName;

    @FindBy(xpath = "(//div[@class='product_desc']/p[2])[last()]")
    private WebElement sendFriendDescribe;

    @FindBy(xpath = "(//a[@class='closefb'])[2]")
    private WebElement sendFriendCloseBtn;

    @FindBy(xpath = "//h2[.='Send to a friend']")
    private WebElement sendFriendsToHeader;

    @FindBy(xpath = "//p[contains(.,'Your e-mail has been')]")
    private WebElement emailMsgSuccessfully;

    @FindBy(xpath = "//input[@class='button']")
    private WebElement sendFriendOkBtn;

    @FindBy(id = "our_price_display")
    private WebElement priceAfterDiscount;

    @FindBy(id = "reduction_percent_display")
    private WebElement reductionPrecent;

    @FindBy(id = "old_price_display")
    private WebElement priceBeforeDiscount;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement quantityInput;

    @FindBy(className = "icon-minus")
    private WebElement minusBtn;

    @FindBy(className = "icon-plus")
    private WebElement plusBtn;

    @FindBy(id = "group_1")
    private WebElement sizeOptions;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']/li/a")
    private List<WebElement> colors;

    @FindBy(xpath = "//button[@name='Submit']")
    private WebElement addToCartBtn;

    @FindBy(id = "wishlist_button")
    private WebElement wishListBtn;

    @FindBy(id = "product_payment_logos")
    private WebElement paymentLogos;

    @FindBy(xpath = "//section[@class='page-product-box'][1]/h3")
    private WebElement dataSheetHeader;

    @FindBy(xpath = "//table[@class='table-data-sheet']/tbody/tr")
    private List<WebElement> tableRows;

    @FindBy(xpath = "//table[@class='table-data-sheet']/tbody/tr[1]/td")
    private List<WebElement> tableCols;

    @FindBy(xpath = "//section[@class='page-product-box'][2]/h3")
    private WebElement moreInfoHeader;

    @FindBy(xpath = "//div[@class='rte']/p")
    private WebElement moreInfoText;

    @FindBy(xpath = "(//h3[contains(@class,'page-product-heading')])[3]")
    private WebElement reviews;

    @FindBy(xpath = "//div[@class='layer_cart_product_info']//span")
    private List<WebElement> addToCartLayersProductInfo;

    @FindBy(xpath = "//span[@id='layer_cart_product_title'])[1]")
    private WebElement addToCartNameProduct;

    @FindBy(id="layer_cart_product_attributes")
    private WebElement addToCartSizeColor;

    @FindBy(id="layer_cart_product_quantity")
    private WebElement addToCartQuantityProduct;

    @FindBy(xpath = "//div[@class='layer_cart_row']")
    private List<WebElement> addToCartPricesInfo;

    @FindBy(xpath = "//span[contains(@class,'btn btn-default')]")
    private WebElement continueBtn;

    @FindBy(xpath = "//a[contains(.,'Proceed to checkout')]")
    private WebElement proceedCheckOutBtn;

    private String[] socialNetworksLinksExpected = {"tweet",
            "share", "google+", "pinterest"};

    @FindBy(xpath = "//h2[contains(.,'Product successfully')]")
    private WebElement productFoundMessage;

    @FindBy(css = "//div[@class='layer_cart_cart col-xs-12 col-md-6']//div[3]/span")
    private WebElement totalPrice;

    public void verifyingTheProductPage(Map<String, String> data) {
        assertTrue(breadcrumb.isDisplayed(), "Bread crumb is not displayed");
        assertEquals(productHeader.getText().trim(), data.get("Name"), "Name isn't correct");
        assertEquals(productReference.getText().trim(), data.get("Reference"), "Reference isn't correct");
        assertEquals(productCondition.getText().trim(), data.get("Condition"));
        assertEquals(shortDescriptionContent.getText().trim(), data.get("Description"), "Description isn't correct");
        assertEquals(4, socialNetworksLinks.size(), "Number of Social links aren't 4");
        for (int i = 0; i < socialNetworksLinks.size(); i++) {
            assertEquals(socialNetworksLinks.get(i).getText().toLowerCase().trim(), socialNetworksLinksExpected[i],
                    "Network Link did not match " + socialNetworksLinksExpected[i]);
        }
//        verifyingReviewPopUp(data);
//        verifyFriendMessage(data);
        assertEquals(priceAfterDiscount.getText().trim().replace("$", ""), data.get("PriceAfterDiscount"), "Price after discount isn't correct");
        assertEquals(priceBeforeDiscount.getText().trim().replace("$", ""), data.get("PriceBeforeDiscount"), "Price before discount isn't correct");
        assertEquals(reductionPrecent.getText().trim().replaceAll("[-%]", ""), data.get("Discount"), "Discount isn't correct");
        assertTrue(minusBtn.isEnabled(), "Plus btn is not enabled");
        assertTrue(plusBtn.isEnabled(), "Minus btn is not enabled");
        assertTrue(quantityInput.getText().trim().isEmpty(), "Quantity Input is not empty");
        int quantity = Integer.parseInt(data.get("Quantity"));
        for (int i = 1; i <= quantity; i++) {
            plusBtn.click();
        }

        assertTrue(sizeOptions.isEnabled(), "Size field is not enabled");
        assertEquals(colors.size(), Integer.parseInt(data.get("AvailableColor")), "The number of colors does not match");

        //pick color based on excel column
        driver.findElement(By.xpath("//ul[@id='color_to_pick_list']/li/a[@name='"+data.get("PickColor")+"']")).click();

        new Select(sizeOptions).selectByVisibleText(data.get("Size"));

        assertTrue(wishListBtn.isEnabled(), "Wish button isn't enabled");
        assertTrue(paymentLogos.isDisplayed(), "Payment logos isn't displayed");
        assertTrue(dataSheetHeader.isDisplayed(), "Data Sheet Header isn't displayed");
        assertEquals(2, tableCols.size(), "Columns aren't 2");
        assertEquals(3, tableRows.size(), "Rows aren't 3");
        assertEquals(moreInfoHeader.getText().trim().toLowerCase(), "more info", "Info Header isn't correct");
        assertEquals(moreInfoText.getText().trim(), data.get("InfoText"), "Info text isn't correct");
        assertEquals(reviews.getText().trim().toLowerCase(), "reviews", "Review header isn't correct");
        assertTrue(addToCartBtn.isEnabled(), "The add button isn't enabled");
        addToCartBtn.click();
       // verifyAddToCardPopUp(data);
    }
    public void verifyAddToCardPopUp(Map<String, String> data){
        assertEquals(addToCartNameProduct.getText(),data.get("Name"), "The header for the dress does not match");
        String[] colorAndSize = addToCartSizeColor.getText().split(","); //Black, M
        System.out.println(addToCartSizeColor.getAttribute("innerText")+"1");
        String uiColor = colorAndSize[0].trim();
        String uiSize = colorAndSize[1].trim();
        assertEquals(uiColor, data.get("PickColor"));
        assertEquals(uiSize, data.get("Size"));

       //assertEquals(addToCartQuantityProduct.getText(), data.get("Quantity"));
        String totalPriceStr = totalPrice.getAttribute("span").replace("$", "");
        System.out.println(totalPriceStr);
        assertEquals(totalPriceStr, data.get("TotalCost"), "Total cost does not match with Excel expected data");
        proceedCheckOutBtn.click();


    }

    public void verifyingReviewPopUp(Map<String, String> data) {
        assertTrue(writeReview.isDisplayed(), "Review field is not displayed");
        writeReview.click();
        assertEquals(reviewHeader.getText().trim().toUpperCase(), "WRITE A REVIEW", "Header of review page isn't correct");
        assertEquals(reviewSubheading.getText().trim().toUpperCase(), "WRITE A REVIEW", "Sub-header of review page isn't correct");
        assertEquals(reviewProductName.getText().trim(), data.get("Name"), "Name of review page isn't correct");
        assertEquals(reviewDescription.getText().trim(), data.get("Description"), "Description of review page isn't correct");
        assertEquals(reviewStars.size(),5, "Number of stars isn't correct");
        reviewStars.get(CommonUtils.randomStar() - 1).click();
        assertTrue(reviewCancelBtn.isEnabled(), "Cancel button isn't displayed ");
        assertTrue(reviewCommentTitleInput.isEnabled(), "Comment title field of review page isn't displayed ");
        reviewCommentTitleInput.click();
        reviewCommentTitleInput.sendKeys("not satisfied with the order");
        assertTrue(reviewCommentInput.isEnabled(), "Input field of review page isn't displayed ");
        reviewCommentInput.click();
        reviewCommentInput.sendKeys("This seller is terrible. Don't think to buy this");
        assertTrue(submitNewMessage.isEnabled(), "Submit button of review page isn't displayed ");
        submitNewMessage.click();
        assertEquals(popUpCommentHeaderTxt.getText().trim(), "New comment", "Title of pop-up verifying message isn't correct ");
        assertEquals(popUpMessage.getText().trim(), "Your comment has been added and will be available once approved by a moderator", "Message of pop-up verifying message isn't correct ");
        assertTrue(okBtn.isEnabled(), "Ok button isn't displayed on verifying message");
        okBtn.click();
    }

    public void verifyFriendMessage(Map<String, String> data) {
        sendFriends.click();
        assertEquals(sendFriendHeader.getText().trim().toLowerCase(), "send to a friend", "Header from pop up, friend message, not matching ");
        assertEquals(sendFriendDescribe.getText().trim(), data.get("Description"), "Description from pop-up friend message is not correct");
        assertEquals(sendFriendProductName.getText().trim(), data.get("Name"), "Name of product  from pop-up friend message is not correct");
        assertTrue(friendNameInput.isEnabled(),"Friend name input is not enabled");
        friendNameInput.sendKeys(data.get("FriendName"));
        assertTrue(friendsEmailInput.isEnabled(),"Friend email input is not enabled");
        friendsEmailInput.sendKeys(data.get("FriendsEmail"));
        assertTrue(sendEmailButton.isEnabled(), "Send friend ok button is not enabled");
        assertTrue(sendFriendCloseBtn.isEnabled(), "Send friend close button is not enabled");
        sendEmailButton.click();
        assertEquals(sendFriendsToHeader.getText().trim(), "Send to a friend", "Send to a friend header of pop-up confirmation is not correct");
        assertEquals(emailMsgSuccessfully.getText().trim(), "Your e-mail has been sent successfully", "Send to a friend message of pop-up confirmation is not correct");
        assertTrue(sendFriendOkBtn.isEnabled(), "Send friend ok button is not enabled");
        sendFriendOkBtn.click();
    }


}
