package com.company;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Main {

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }

    public static void waitForElement(WebDriver driver, String element) throws Exception{
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
            wait.until(ExpectedConditions.elementToBeClickable(By.id(element)));
    }

    public static void waitForElementByXPath(WebDriver driver, String element) throws Exception{
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vlar0816\\Documents\\soft\\chromedriver_win32\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String PATH_TO_SCR = "C:\\Users\\vlar0816\\Desktop\\at\\";

        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        driver.get("https://vk.com/");
        driver.findElement(By.id("index_email")).click();
        driver.findElement(By.id("index_email")).sendKeys("Username");
        driver.findElement(By.id("index_pass")).sendKeys("Password");
        driver.findElement(By.id("index_pass")).sendKeys(Keys.ENTER);
        
        waitForElement(driver,"l_pr");
        driver.findElement(By.id("l_pr")).click();
        takeSnapShot(driver, PATH_TO_SCR + "1.png") ;
        
        waitForElement(driver,"l_nwsf");
        driver.findElement(By.id("l_nwsf")).click();
        takeSnapShot(driver, PATH_TO_SCR + "2.png");
        
        waitForElement(driver,"l_msg");
        driver.findElement(By.id("l_msg")).click();
        takeSnapShot(driver, PATH_TO_SCR + "3.png");
        
        waitForElement(driver,"l_fr");
        driver.findElement(By.id("l_fr")).click();
        takeSnapShot(driver, PATH_TO_SCR + "4.png");
        
        waitForElement(driver,"l_gr");
        driver.findElement(By.id("l_gr")).click();
        takeSnapShot(driver, PATH_TO_SCR + "5.png");

        waitForElement(driver,"l_pr");
        driver.findElement(By.id("l_pr")).click();

        waitForElement(driver,"post_field");
        driver.findElement(By.id("post_field")).click();
        driver.findElement(By.id("post_field")).sendKeys("ONE MORE TIME!111!1!!!");
        driver.findElement(By.id("send_post")).click();
        takeSnapShot(driver, PATH_TO_SCR + "6.png");
        
        waitForElementByXPath(driver,"//*[@id=\"top_profile_link\"]");
        driver.findElement(By.xpath("//*[@id=\"top_profile_link\"]")).click();
        takeSnapShot(driver, PATH_TO_SCR + "7.png");

        waitForElement(driver,"top_logout_link");
        driver.findElement(By.id("top_logout_link")).click();
        takeSnapShot(driver, PATH_TO_SCR + "8.png");

    }
}
