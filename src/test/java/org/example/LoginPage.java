package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "email")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(css = ".ZYq7T > .vq1BT")
    private WebElement loginBtn;

    public void login(String username, String password) {
        emailField.click();
        emailField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginBtn.click();
    }

}
