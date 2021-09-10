package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestCreatePost {

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
    public void createPostTest() {
        loginPage.login("petrenko.nad1n@gmail.com", "K31a33ru");

        //create Post
        {
            WebElement element = driver.findElement(By.cssSelector(".kIuBF:nth-child(6) svg"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        {
            WebElement element = driver.findElement(By.tagName("body"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element, 0, 0).perform();
        }
        driver.findElement(By.cssSelector(".BPAd0 > svg")).click();
        driver.findElement(By.cssSelector(".ZkWu_")).click();

        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("Название поста 6");
        driver.findElement(By.cssSelector(".shgTR"));
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div/div/div/div[1]/div[1]/div/div/div/div/div/span/p/div/span")).sendKeys("Yjdfgfgfgkjf");

        driver.findElement(By.cssSelector(".XEpuX")).click();
    }

    @AfterClass
    public static void tearDown() {

        driver.quit();
    }
}
