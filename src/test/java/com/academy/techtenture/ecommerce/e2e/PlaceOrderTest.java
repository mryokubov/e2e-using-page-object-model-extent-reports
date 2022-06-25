package com.academy.techtenture.ecommerce.e2e;

import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class PlaceOrderTest extends BaseTest {


    @Test(priority = 0,  dataProvider = "contactUs")
    public void placeOrderRegisteredUserTest( Map<String,String> data ) throws IOException {

        extentTest = extentReports.startTest("place order positive test");


    }


    @DataProvider(name = "")
    public Object[][] getNewUsersData(){
        //todo use the proper sheetname
        ExcelReader excelReader = new ExcelReader("src/main/resources/testData/ecommerce.xlsx", "");
        return excelReader.getData();
    }
}
