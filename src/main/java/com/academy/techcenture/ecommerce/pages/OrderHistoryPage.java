package com.academy.techcenture.ecommerce.pages;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class OrderHistoryPage extends HomePage{

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//h1[contains(@class,'page-heading')]")
    private WebElement pageHeading;

    @FindBy(xpath = "//table[@id='order-list']//tbody/tr/td[contains(@class,'history_link')]")
    private List<WebElement> orderReferences;


    public void verifyOrderHistory(Map<String, String> data) throws IOException {

        boolean foundReference = false;
        for (int i = 0; i < orderReferences.size(); i++) {
            if (orderReferences.get(i).getText().equals( data.get("orderReference"))){
                foundReference = true;
                break;
            }
        }
        assertTrue(foundReference, "Order Reference was not found in the order history table");

        String xpathInoice = "//table[@id='order-list']//tbody/tr/td/a[contains(text(),'"+data.get("orderReference")+"')]/../following-sibling::td[@class='history_invoice']/a";

        WebElement pdfInvoiceLink = driver.findElement(By.xpath(xpathInoice));
        String pdfUrl = pdfInvoiceLink.getAttribute("href");
        pdfUrl = pdfUrl + ".pdf";

        System.out.println(verifyPdfInvoice(pdfUrl));


    }


    private String verifyPdfInvoice(String urlTxt) throws IOException {

        URL pdfUrl = new URL(urlTxt);
        InputStream in = pdfUrl.openStream();
        BufferedInputStream bf = new BufferedInputStream(in);

        byte[] arrayFromInputStream = getArrayFromInputStream(bf);
        writeContent(arrayFromInputStream,  "src/main/resources/invoices/sample.pdf");


        String content  = "";
//        PDDocument document = PDDocument.load(new File("src/main/resources/invoices/IN220027.pdf"));
//        if (!document.isEncrypted()) {
//            PDFTextStripper stripper = new PDFTextStripper();
//            content = stripper.getText(document);
//            System.out.println("Text:" + content);
//        }
//        document.close();
//

        return content;
    }

    private static byte[] getArrayFromInputStream(BufferedInputStream inputStream) throws IOException {
        byte[] bytes;
        byte[] buffer = new byte[1024];
        try(BufferedInputStream is = new BufferedInputStream(inputStream)){
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int length;
            while ((length = is.read(buffer)) > -1 ) {
                bos.write(buffer, 0, length);
            }
            bos.flush();
            bytes = bos.toByteArray();
        }
        return bytes;
    }

    private static void writeContent(byte[] content, String fileToWriteTo) throws IOException {
        File file = new File(fileToWriteTo);
        try(BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(file))){
            salida.write(content);
            salida.flush();
        }
    }
}
