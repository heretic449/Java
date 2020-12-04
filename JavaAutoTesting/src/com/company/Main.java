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

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver_win32\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        driver.get("https://vk.com/");
        driver.manage().window().setSize(new Dimension(1188, 640));
        driver.findElement(By.id("index_email")).click();
        driver.findElement(By.id("index_email")).sendKeys("taro.vladimir@gmail.com");
        driver.findElement(By.id("index_pass")).sendKeys("mem5xDFf");
        driver.findElement(By.id("index_pass")).sendKeys(Keys.ENTER);
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[2]")));
        }

        takeSnapShot(driver, "D://1.png") ;
        driver.findElement(By.xpath("//span[2]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "D://2.png");
        driver.findElement(By.xpath("//li[2]/a/span[2]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "D://3.png");
        driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "D://4.png");
        driver.findElement(By.xpath("//li[4]/a/span[2]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "D://5.png");
        driver.findElement(By.xpath("//li[5]/a/span[2]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "D://6.png");
        driver.findElement(By.xpath("//*[@id=\"top_profile_link\"]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, "D://7.png");
        driver.findElement(By.xpath("//*[@id=\"top_logout_link\"]")).click();

    }
}
