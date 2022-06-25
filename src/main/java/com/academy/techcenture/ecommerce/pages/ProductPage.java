package com.academy.techcenture.ecommerce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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










}
