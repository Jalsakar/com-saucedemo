package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Com_SauceDemo {
    //1. Setup Multi browser
    static String browser = "Chrome";
    // static String browser = "FireFox";
    // static String browser = "Edge";
    //Base Url
    static String baseurl = "https://www.saucedemo.com/";
    //Launch the browser
    static WebDriver driver;

    public static void multiBrowserTest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid Browser name");
        }
    }

    public static void main(String[] args) {
        //static method calling
        multiBrowserTest();
        //2. Open Url
        driver.get(baseurl);
        //Maximise the Browser
        driver.manage().window().maximize();
        // Give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //3. Print the title of the page
        System.out.println("Title of the page : " + driver.getTitle());
        //4. Print the current Url
        System.out.println("Current Url : " + driver.getCurrentUrl());
        //5. Print the page source
        System.out.println("Page source : " + driver.getPageSource());
        //6.Enter the email to email field
        WebElement emailField = driver.findElement(By.id("user-name"));
        emailField.sendKeys("Welcome");
        //7.Enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("abc@2023");
        //8.Click on Login Button
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
        //9.Print the current Url
        System.out.println("Current Url : " + driver.getCurrentUrl());
        //10.Navigate to baseUrl
        driver.navigate().to(baseurl);
        System.out.println("Base Url : " + driver.getCurrentUrl());
        //11.Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page : " + driver.getCurrentUrl());
        //Close the browser
        driver.quit();
    }
}//Run the program