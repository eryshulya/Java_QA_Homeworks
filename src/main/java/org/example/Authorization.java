package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Authorization {
    private WebDriver driver;
    public Authorization(WebDriver driver) {
        this.driver = driver;
    }
    private By phoneNumber = By.id("connection-phone");
    private By paymentSum = By.id("connection-sum");
    private By emailField = By.id("connection-email");
    private By continueButton = By.cssSelector("button.button__default");

    public void enterNumber(String number) {
        driver.findElement(phoneNumber).sendKeys(number);
    }

    public void enterSum(String sum) {
        driver.findElement(paymentSum).sendKeys(sum);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}
