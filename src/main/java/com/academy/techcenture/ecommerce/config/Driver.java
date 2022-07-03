package com.academy.techcenture.ecommerce.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Driver {

    private static WebDriver driver;

    //hide the constructor so no one can instantiate it
    private Driver(){}

    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");

        switch (browser){
            case "chrome":

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                String formatter = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss"));
                File downloadDirectory = new File(System.getProperty("user.dir") + "/src/main/resources/invoices/" + formatter);
                HashMap<String, Object> chromeOptionsMap = new HashMap<>();
                chromeOptionsMap.put("download.default_directory", downloadDirectory.getAbsolutePath());
                options.setExperimentalOption("prefs", chromeOptionsMap);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        if (driver != null){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds( Long.parseLong(ConfigReader.getProperty("pageLoadTime"))));
            return driver;
        }
        throw  new RuntimeException("No Driver was found");
    }
}

