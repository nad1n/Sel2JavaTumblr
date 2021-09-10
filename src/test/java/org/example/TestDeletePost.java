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

public class TestDeletePost {
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
    public void deletePostTest() {
        loginPage.login("petrenko.nad1n@gmail.com", "K31a33ru");

        //delete Post
        driver.findElement(By.cssSelector(".kIuBF:nth-child(6) svg")).click();
        driver.findElement(By.cssSelector("li:nth-child(1) > a > span:nth-child(1)")).click();

        String postName = driver.findElement(By.xpath("//*[@id=\"base-container\"]/div[2]/div[2]/div[1]/main/div[2]/div[2]/div[1]/div/div/article/div[2]/div[1]/h1")).getText();
        Assert.assertEquals("Test post", postName);

        driver.findElement(By.cssSelector(".IGdYk:nth-child(1) .\\_PKfi:nth-child(5) svg:nth-child(1)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".IGdYk:nth-child(1) .\\_PKfi:nth-child(5) svg:nth-child(1)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".ZYq7T:nth-child(2) > .vq1BT")).click();
        driver.findElement(By.cssSelector(".TeEAG path")).click();
        {
            WebElement element = driver.findElement(By.cssSelector(".TeEAG path"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".oXYe5:nth-child(1)")).click();
        driver.findElement(By.cssSelector(".ZYq7T:nth-child(2) > .vq1BT")).click();

    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }
}
