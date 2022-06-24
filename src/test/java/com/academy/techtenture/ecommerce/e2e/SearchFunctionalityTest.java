package com.academy.techtenture.ecommerce.e2e;

import com.academy.techcenture.ecommerce.pages.SearchPage;
import com.academy.techcenture.ecommerce.utils.ExcelReader;
import com.academy.techtenture.ecommerce.base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.Map;

public class SearchFunctionalityTest extends BaseTest {


    @Test(dataProvider = "searchKeyword")
    public void searchKeyWordTest(Map<String,String> data){
        extentTest = extentReports.startTest("search keyword test");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.verifySearch(data);
        extentTest.log(LogStatus.PASS, "verified search keyword functionality");
    }

    @DataProvider(name = "searchKeyword")
    public Object[][] getSearchKeyword(){
        return new ExcelReader("src/main/resources/testData/ecommerce.xlsx","searchKeywords").getData();

    }

}
