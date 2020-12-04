package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\soft\\chromedriver_win32\\bin\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://vk.com/");
        driver.manage().window().setSize(new Dimension(1188, 640));
        driver.findElement(By.id("index_email")).click();
        driver.findElement(By.id("index_email")).sendKeys("User");
        driver.findElement(By.id("index_pass")).sendKeys("Password");
        driver.findElement(By.id("index_pass")).sendKeys(Keys.ENTER);
        {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[2]")));
        }
        driver.findElement(By.xpath("//span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[2]/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[3]/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[4]/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[5]/a/span[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"top_profile_link\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"top_logout_link\"]")).click();

    }
}
