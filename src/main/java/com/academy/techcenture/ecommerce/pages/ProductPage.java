package com.academy.techcenture.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

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


    public void verfiyingTheProductPage(Map<String, String> data){
        Assert.assertTrue(breadcrumb.isDisplayed(), "Bread crumb is not displayed");
        Assert.assertEquals(productHeader.getText().trim(), "\"" + data.get(""));



    }

























}
