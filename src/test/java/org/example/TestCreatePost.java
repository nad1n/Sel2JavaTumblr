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
    public void loginTest(){
        loginPage.login("petrenko.nad1n@gmail.com", "K31a33ru");
        String loginName = driver.findElement(By.xpath("//*[@id=\"base-container\"]/div[2]/div[2]/div[1]/main/div[4]/div[2]/div[1]/div/div/article/header/div/div[1]/div[1]/div/div/span/span/a")).getText();
        Assert.assertEquals("lazytalecupcake", loginName);
    }

    @Test
    public void createPostTest() {
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

        driver.findElement(By.cssSelector(".public-DraftStyleDefault-block")).sendKeys("Test post");
        driver.findElement(By.cssSelector(".shgTR"));
        driver.findElement(By.xpath("//*[@id=\"row-1\"]/div/div/div/div[1]/div[1]/div/div/div/div/div/span/p/div/span")).sendKeys("Yjdfgfgfgkjf");

        driver.findElement(By.cssSelector(".XEpuX")).click();
    }

    @Test
    public void likePostTest() {
        driver.findElement(By.cssSelector(".kIuBF:nth-child(1) svg")).click();
        //like post
        String postName = driver.findElement(By.xpath("//*[@id=\"base-container\"]/div[2]/div[2]/div[1]/main/div[4]/div[2]/div[1]/div/div/article/div[2]/div[1]/h1")).getText();
        Assert.assertEquals("Test post", postName);

        driver.findElement(By.xpath("//*[@id=\"base-container\"]/div[2]/div[2]/div[1]/main/div[4]/div[2]/div[1]/div/div/article/div[3]/footer/div[2]/div[4]/button")).click();
    }

    @Test
    public void readUserTest() {
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

    //здесь не работает, а в отдельном классе работает!!!
    @Test
    public void deletePostTest() {
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
