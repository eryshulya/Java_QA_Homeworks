package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class PaymentPage {
    private WebDriver driver;

    private By paymentFrame =
            By.cssSelector("iframe.payment-widget-iframe");
    private By sumValue = By.cssSelector(".pay-description__cost span");

    private By cardNumber = By.id("cc-number");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isCardNumberVisible() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cardNumber)
        );

        return driver.findElement(cardNumber).isDisplayed();
    }
    public String valueSum(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(sumValue)
        );
        return driver.findElement(sumValue).getText();
    }
    //при нажатии 000 не переходит на страницу модального окна так проверить все негативные
}
