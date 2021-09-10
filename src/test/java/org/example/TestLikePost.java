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

public class TestLikePost {
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
    public void likePostTest() {
        loginPage.login("petrenko.nad1n@gmail.com", "K31a33ru");

        //like post
        String postName = driver.findElement(By.xpath("//*[@id=\"base-container\"]/div[2]/div[2]/div[1]/main/div[4]/div[2]/div[1]/div/div/article/div[2]/div[1]/h1")).getText();
        Assert.assertEquals("Test post", postName);

        driver.findElement(By.xpath("//*[@id=\"base-container\"]/div[2]/div[2]/div[1]/main/div[4]/div[2]/div[1]/div/div/article/div[3]/footer/div[2]/div[4]/button")).click();
    }

    @AfterClass
    public static void tearDown() {

        //driver.quit();
    }
}
