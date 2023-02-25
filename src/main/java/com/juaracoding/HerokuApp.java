package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class HerokuApp {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","C:\\juaracoding\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://formy-project.herokuapp.com/form");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        
        String radioButton1 = "High School";
        String radioButton2 = "College";
        String radioButton3 = "Grad School";

        String checkBox1 = "Male";
        String checkBox2 = "Female";
        String checkBox3 = "Prefer not to say";

        String titleHeader = driver.getTitle();
        System.out.println("Title Header :"+titleHeader);

        //Locator
        String title = driver.findElement(By.name("csrf-param")).getText();
        System.out.println("Title Page : "+title);

        driver.findElement(By.id("first-name")).sendKeys("Topan");
        driver.findElement(By.id("last-name")).sendKeys("Sanjaya");
        driver.findElement(By.id("job-title")).sendKeys("QA");

        driver.findElement(By.id("radio-button-1")).sendKeys(radioButton1);

        driver.findElement(By.id("checkbox-1")).sendKeys(checkBox1);

        WebElement selectYearOfExperience = driver.findElement(By.id("select-menu"));
        Select experience = new Select(selectYearOfExperience);

        experience.selectByVisibleText("0-1");
        System.out.println("Test Select 0-1 Year of Experience");

        String pattern = "02/25/2023";
        LocalDateTime now = LocalDateTime.now();
        String dateNow = new SimpleDateFormat(pattern).format(now);
        driver.findElement(By.id("datepicker")).sendKeys(pattern);

        js.executeScript("window.scrollBy(0, 500)"); //scroll by pixel vertical
        driver.findElement(By.xpath("/thanks")).click();
        System.out.println("Data Berhasil Disimpan");

        System.out.print("Test Case Result : ");
        if(title.equals("Formy")){
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}
