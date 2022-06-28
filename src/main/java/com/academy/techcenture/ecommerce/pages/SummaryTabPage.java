package com.academy.techcenture.ecommerce.pages;

import com.academy.techcenture.ecommerce.pages.HomePage;
import com.academy.techcenture.ecommerce.utils.CommonUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.*;

public class SummaryTabPage extends HomePage {

        protected Actions actions;

        public SummaryTabPage(WebDriver driver) {
            super(driver);
            this.actions =  new Actions(driver);

        }

    @FindBy(xpath = "//h1[contains(.,'Shopping-cart summary')][1]")
    private WebElement cartHeader;

    @FindBy(xpath = "//ul[@id='order_step']/li")
    private List<WebElement> shoppingToDo;

    @FindBy(xpath = "//li[contains(@class,'first')]//span[1]")
    private WebElement summaryTab;

    @FindBy(xpath = "//table[@id='cart_summary']//tr//th")
    private List<WebElement> summaryOptions;

    @FindBy(css = "td[class='cart_description'] p[class='product-name'] a")
    private WebElement descriptionProductName;

    @FindBy(css = "td[class='cart_description'] small a")
    private WebElement sizeColor;

    @FindBy(xpath = "//span[@class='label label-success']")
    private WebElement availableInStock;

    @FindBy(xpath = "//span[contains(@class,'price special-price')]")
    private WebElement unitPrice;

    @FindBy(xpath = "//span[@class='price-percent-reduction small']")
    private WebElement discount;

    @FindBy(xpath = "//span[@class='old-price']")
    private WebElement oldPrice;

    @FindBy(xpath = "//td[@class='cart_quantity text-center']")
    private WebElement quantityInput;

    @FindBy(xpath = "//td[@class='cart_total']")
    private WebElement totalInput;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private WebElement deleteIcon;

    @FindBy (xpath = "//td[@id='total_product']")
    protected WebElement totalProduct;

    @FindBy (xpath = "//td[@id='total_shipping']")
    protected WebElement totalShipping;

    @FindBy (xpath = "//td[@id='total_price_without_tax']")
    protected WebElement totalWithShipping;

    @FindBy (xpath = "//span[@id='total_price']")
    protected WebElement totalTotal;


        //summary, sigIn and address elements .

        @FindBy(xpath = "//title[contains(.,'My Store')]")
        protected WebElement titleSummary;

        @FindBy(xpath = "//h1[@class='page-heading']")
        protected WebElement addressHeader;

        @FindBy(xpath = "//label[@for='id_address_delivery']")
        protected WebElement addressLabel;

        @FindBy(id = "addressesAreEquals")
        protected WebElement checkBoxUseAddressDel;

        @FindBy(xpath = "//p[contains(@class,'addressesAreEquals')]")
        protected WebElement checkUseAddressDelTxt;

        @FindBy(xpath = "//ul[@id='address_delivery']//li")
        private List<WebElement> deliveryAddress;

        @FindBy(xpath = "//div[@id='ordermsg']//following-sibling::label")
        protected WebElement commentLabel;

        @FindBy(xpath = "//textarea[@class='form-control']")
        protected WebElement commentTextArea;

        @FindBy(xpath = "(//span[contains(.,'Proceed to checkout')])[last()]")
        protected WebElement proceedCheckOutBtn;

        //shipping elements.

        @FindBy(xpath = "//h1[@class='page-heading']")
        protected WebElement shippingHeader;

        @FindBy(className = "delivery_options_address")
        protected WebElement optionLabel;

        @FindBy(xpath = "//table[contains(@class,'table-bordered')]//td")
        private List<WebElement> tableData;

        @FindBy(className = "carrier_title")
        protected WebElement serviceTermLabel;

        @FindBy(id = "cgv")
        protected WebElement checkServiceBoxInput;

        @FindBy(xpath = "//label[@for='cgv']")
        private WebElement checkServiceLabel;

        @FindBy(className = "fancybox-error")
        private WebElement mustAgreeMsg;

        @FindBy(xpath = "//a[@title='Close']")
        private WebElement closeMustAgreeBtns;

        @FindBy(xpath = "//div[contains(@class,'content_only')]/h3")
        protected List<WebElement> threeRules;

        @FindBy(xpath = "//a[@class='iframe']")
        protected WebElement readTermLink;

        //payment elements.

        @FindBy(xpath = "//h1[@class='page-heading']")
        protected WebElement paymentHeader;

        @FindBy(xpath = "//td[text()='Total products']/following-sibling::td")
        protected WebElement totalProducts;

        @FindBy(xpath = "//td[text()='Total shipping']/following-sibling::td")
        protected WebElement totalofShipping;

        @FindBy(xpath = "//td[text()='Total shipping']/following-sibling::td")
        protected WebElement total;

        @FindBy(xpath = "//span[@id='total_price']")
        protected WebElement total1;

        @FindBy(xpath = "//table[@id='cart_summary']/thead/tr[1]/th")
        protected List<WebElement> colsTable;


        @FindBy(xpath = "//table[@id='cart_summary']/tbody/tr")
        protected List<WebElement> rowsData;


        @FindBy(xpath = "//table[@id='cart_summary']//tr//td//a")
        protected List<WebElement> firstAndSecondCells;

        @FindBy(xpath = "//table[@id='cart_summary']//tr//td//small[1]")
        protected WebElement secondCell;

        @FindBy(xpath = "//tr[contains(@class,'cart_item')]//td//span//span")
        protected List<WebElement> priceTableCell;

        @FindBy(xpath = "//a[@class='bankwire']")
        protected WebElement payBankWireLink;

        @FindBy(xpath = "//a[@class='cheque']")
        protected WebElement payByCheck;



//bank wire elements.

        @FindBy(xpath = "//h1[@class='page-heading']")
        private WebElement orderSummaryHeader;

        @FindBy(className = "page-subheading")
        private WebElement payBankHeader;

        @FindBy(xpath = "//strong[contains(text(),'You have chosen')]")
        protected WebElement chosenPaymentLabel;

        @FindBy(xpath = "//p[contains(.,'- The total amount')]/span")
        protected WebElement totalAmountPayTable;

        @FindBy(xpath = "//p[contains(.,'We allow the following')]/b")
        protected WebElement allowCone;

        @FindBy(xpath = "//button[contains(@class,'button-medium')]")
        protected WebElement conformOrderBtn;


        @FindBy(xpath = "//div[@class='box']//strong")
        protected List<WebElement> orderPoints;

        @FindBy(xpath = "//div[@class='box']/br[6]")
        protected WebElement referenceNumber;

        @FindBy(xpath = "//a[contains(@class,'button-exclusive')]")
        private WebElement backToOrderBtn;


        @FindBy(xpath = "//table[@id='order-list']/thead/tr")
        protected List<WebElement> colsOrderHistory;

        @FindBy(xpath = "//table[@id='order-list']/tbody/tr[1]")
        protected List<WebElement> rowsOrderHistory;

        @FindBy(xpath = "//span[contains(.,'Back to your')]")
        protected WebElement backToYourAccountConfBtn;

        @FindBy(xpath = "//span[contains(.,'Home')]")
        protected WebElement homeConfBtn;

        private String[] toDoOptions = {"summary","sign in", "address","shipping","payment" };

    private String[] summaryOptionsExpected ={"product","description","avail.","unit price","qty","total", null};
    public void shoppingCartSummary(Map<String, String> data){

        verifyingProductSummaryTabs(data);
}
    public void verifyingProductSummaryTabs(Map<String, String> data) {
        assertEquals(cartHeader.getText().trim().toUpperCase(),"SHOPPING-CART SUMMARY"+"\n"+"YOUR SHOPPING CART CONTAINS: "+ data.get("Quantity")+" PRODUCTS", "Header is not correct");
        for (int i = 0; i < shoppingToDo.size(); i++) {
            assertEquals(shoppingToDo.get(i).getText().toLowerCase().substring(4),toDoOptions[i],toDoOptions[i]+"isnt match");
        }

        String rgbFormat = summaryTab.getCssValue("color");
        String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
        assertEquals(hexcolor,"#ffffff", "Summary button is selected");
        for (int i = 0; i < summaryOptions.size()-1; i++) {
            assertEquals(summaryOptions.get(i).getText().toLowerCase(),summaryOptionsExpected[i],summaryOptionsExpected[i]+"isnt match");
        }
        assertEquals(descriptionProductName.getText().trim(), data.get("Name"),"Product name isn't correct");
        String[] colorAndSize = sizeColor.getText().split(",");
        String[] uiColor = colorAndSize[0].split(":");
        String[] uiSize  = colorAndSize[1].split(":");
        assertEquals(uiColor[1].trim(), data.get("PickColor"),"Color isn't correct");
        assertEquals(uiSize[1].trim(), data.get("Size"),"Size isn't correct");
        assertTrue( availableInStock.isDisplayed(),"In Stoke isn't displayed");
        assertEquals(unitPrice.getText().replace("$",""),data.get("PriceAfterDiscount"), "Price isn't correct");
        assertEquals(discount.getText().replaceAll("[-%]","").trim(),data.get("Discount"), "Discount isn't correct");
        assertEquals(oldPrice.getText().replace("$",""),data.get("PriceBeforeDiscount"), "Price before discount isn't correct");
        assertTrue(quantityInput.isDisplayed(), "Quantity isn't displayed");
        double total = Double.parseDouble(data.get("Quantity"))*Double.parseDouble(data.get("PriceAfterDiscount"));
        assertEquals(totalInput.getText().replace("$",""),Double.toString(total), "Total Input isn't correct");
        assertTrue(deleteIcon.isEnabled(),"Delete Icon isn't enabled");
        assertEquals(totalProduct.getText().replace("$",""),Double.toString(total), "Total Input isn't correct");
        assertEquals(totalofShipping.getText().replace("$","").substring(0,3),data.get("ShippingCost"), "Shipping Cost isn't correct");
        double totalPlusShipping = Double.parseDouble(data.get("ShippingCost"))+total;
        assertEquals(totalWithShipping.getText().replace("$",""),Double.toString(totalPlusShipping), "Total plus Shipping isn't correct");
        assertEquals(totalTotal.getText().replace("$",""),Double.toString(totalPlusShipping), "Finished Total isn't correct");







    }
//        public void verifyingAddressAndSummaryTabs(Map<String, String> users){
//
//            assertEquals(driver.getTitle().trim(), "Order - My Store", "title didn't match");
//            assertEquals(addressHeader.getText().trim(), "Addresses", "Addresses header didn't match");
//            assertEquals(addressLabel.getText().trim(), users.get("labelDeliveryAddress").trim(), "label delivery address didn't match");
//            assertEquals(checkUseAddressDelTxt.getText().trim(), users.get("useTheDeliveryAddressText"), "use delivery text didn't match");
//            if (!checkBoxUseAddressDel.isSelected()){
//                actions.click(checkBoxUseAddressDel);
//            }
//
//            assertEquals(deliveryAddress.size(), 8, "size didn't match");
//
//            for (int i = 0; i < deliveryAddress.size(); i++) {
//                assertEquals(deliveryAddress.get(i).getText().trim(), users.get("addressDeliveryBoxInfo").split("/")[i].trim(), "delivery address info didn't match");
//            }
//
//            assertEquals(commentLabel.getText().trim(), users.get("commentRandomLabel").trim(), "comment Random label didn't match");
//
//            commentTextArea.sendKeys(users.get("randomMessage").trim());
//
//
//            actions.click(proceedCheckOutBtn);
//
//
//        }
//
//        public void verfiyingShippingTab(Map <String,String> users){
//
//            assertEquals(driver.getTitle().trim(), "Shipping", "page title didn't match");
//            assertEquals(shippingHeader.getText().trim(), "Shipping", "shipping header didn't match");
//            assertEquals(optionLabel.getText().trim(), users.get("chooseShippingOption").trim(), "Choose option label didn't match");
//            assertEquals(tableData.size(),4 ,"table data didn't match");
//            for (int i = 0; i < tableData.size(); i++) {
//                assertTrue(tableData.get(tableData.size()-1).isDisplayed(), "table data items are are not displayed");
//                assertEquals(tableData.get(3).getText().trim(),users.get("totalShipping").replace("$","").split("\\.")[0].trim(), "shipping price didn't match" );
//            }
//
//
//
//            assertEquals(serviceTermLabel.getText().trim(), users.get("serviceTermLabel").trim(), "service term label didn't match");
//
//            assertTrue(checkServiceLabel.isDisplayed(), "check service label is not displayed");
//
//            proceedCheckOutBtn.click();
//
//            assertTrue(mustAgreeMsg.isDisplayed(), "must agree message is not displayed");
//            assertTrue(closeMustAgreeBtns.isDisplayed(), "close must agree btn is not displayed");
//            actions.click(closeMustAgreeBtns);
//
//
//            assertTrue(readTermLink.isDisplayed(), "read term link is not displayed");
//            readTermLink.click();
//
//            for (int i = 0; i < threeRules.size(); i++) {
//                assertTrue(threeRules.get(i).isDisplayed(), "the three rules in the link are not displayed");
//            }
//            assertTrue(closeMustAgreeBtns.isDisplayed(), "close must agree btn is not displayed");
//            actions.click(closeMustAgreeBtns);
//
//
//            if(!checkServiceBoxInput.isSelected()){
//                checkServiceBoxInput.click();
//            }
//
//
//            actions.moveToElement(proceedCheckOutBtn).perform();
//            actions.click(proceedCheckOutBtn);
//
//
//
//        }
//    public void verfiyingPayment(Map<String,String> users){
//
//
//        assertEquals(paymentHeader.getText().trim(), "Please choose your payment method", "payment header is not match");
//
//        for (int i = 2; i < rowsData.size(); i++) {
//
//            for (int j = 1; j <= colsTable.size(); j++) {
//
//                WebElement elementCells = driver.findElement(By.xpath("//table[@id='cart_summary']/tbody/tr[" + i + "]/td[" + j + "]/spa"));
//
//                System.out.println(elementCells.getText());
//
//            }
//
//        }
//        assertEquals(totalProducts.getText().replace("$","").trim(), users.get("totalWithoutShipping").trim(), "totalProducts didn't match");
//        assertEquals(totalShipping.getText().replace("$","").trim(), users.get("totalShipping").trim(), "total shipping didn't match");
//        assertEquals(total1.getText().replace("$","").trim(), users.get("totalPrice").trim(), "total price didn't match");
//
//
//        assertTrue(payBankWireLink.isDisplayed(),"pay bank wire link is not displayed");
//        assertTrue(payByCheck.isDisplayed(), "pay By check is not displayed");
//
//        actions.click(payBankWireLink);
//
//
//        assertEquals(orderSummaryHeader.getText().trim(), "Order summary", "Order summary header didn't match");
//        assertEquals(payBankHeader.getText().trim(), "Bank-wire payment", "pay bank wire header didn't match");
//        assertTrue(chosenPaymentLabel.isDisplayed(), "chosen payment label didn't match");
//        assertEquals(totalAmountPayTable.getText().trim(), users.get("totalPrice").trim(), "total price in table payment didn't match");
//        assertEquals(allowCone.getText().trim(), users.get("cons").trim(), "allow cones didn't match");
//
//        actions.click(conformOrderBtn);
//
//
//        assertEquals(driver.findElement(By.xpath("//h1[@class='page-heading']")).getText().trim(), "Order confirmation", "order confirmation header didn't match");
//
//        assertEquals(orderPoints.get(0).getText().trim(), users.get("completeLabel").trim(), "complete order information Label ");
//        assertEquals(orderPoints.get(1).getText().replace("$","").trim(), users.get("totalPrice").trim(), "total price in order conformation didn't match");
//        assertEquals(orderPoints.get(2).getText().trim(), users.get("nameOfAccountOwner").trim(), "account name owner didn't match");
//        assertEquals(orderPoints.get(3).getText().trim(), users.get("nameOfAccountOwner").trim(), "these details info didn't match");
//        assertEquals(orderPoints.get(4).getText().trim(), users.get("bankName").trim(), "bank name didn't match");
//        assertEquals(orderPoints.get(5).getText().trim(), users.get("asSoonAsReceiveLabel").trim(), "as soon as receiving label didn't match");
//
//        String referenceNumberSaved = referenceNumber.getText().split(" ")[8].trim();
//
//        users.put("referenceNumber", referenceNumberSaved );
//
//
//        assertTrue(backToOrderBtn.isDisplayed(), "back to order btn is not displayed");
//        actions.click(backToOrderBtn);
//
//
//    }
//
////        public void verfiyingOrderReferenceAndPdf(Map<String, String> users){
////
////            String orderReference = users.get("referenceNumber");
////            for (int i = 2; i <= rowsOrderHistory.size(); i++) {
////                for (int j = 1; j < colsTable.size()-2; j++) {
////
////                    WebElement firstRowCell = driver.findElement(By.xpath("//table[@id='order-list']/tbody/tr[" + 2 + "]/td[" + j + "]"));
////                    assertEquals(firstRowCell.getText().replace("$", "").trim(), "\"" + orderReference + users.get("Date").trim() + users.get("totalPrice").trim()
////                            + users.get("payment").trim() + users.get("status").trim(), "first row info didn't match" );
////                }

            }





