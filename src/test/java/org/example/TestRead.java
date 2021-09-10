package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestRead {
    private static final String PAGE_URL = "https://www.tumblr.com/login";
    public static LoginPage loginPage;

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        //profilePage = new ProfilePage(driver);
        driver.manage().window().setSize(new Dimension(1248, 883));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
    }

    @Test
    public void readUserTest() {
        loginPage.login("petrenko.nad1n@gmail.com", "K31a33ru");

        //read User
        {
            WebElement element = driver.findElement(By.cssSelector(".bUZAr:nth-child(1) .M4qlf .vq1BT"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.cssSelector(".bUZAr:nth-child(1) .M4qlf .vq1BT")).click();
        driver.findElement(By.cssSelector(".kIuBF:nth-child(6) path")).click();
        driver.findElement(By.cssSelector(".\\_8eYy:nth-child(2) .ud3ie")).click();
        driver.findElement(By.cssSelector(".M4qlf:nth-child(1) > .f8EId .lmRkK")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".S07PS"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".\\_Km36 > .xBRdB path")).click();
    }

    @AfterClass
    public static void tearDown() {

        //driver.quit();
    }
}
