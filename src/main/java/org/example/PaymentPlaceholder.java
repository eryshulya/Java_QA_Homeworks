package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPlaceholder {
  private WebDriverWait wait;
  private  By paymentDropdownButton = By.cssSelector("button.select__header");
  private  By paymentDropdownValue = By.cssSelector("span.select__now");
  private WebDriver driver;
  private By phonePlaceholder = By.id("connection-phone");
    private By homeInternetOption = By.xpath(
            "//p[contains(@class,'select__option') and normalize-space()='Домашний интернет']"
    );

    private By installmentOption = By.xpath(
            "//p[contains(@class,'select__option') and normalize-space()='Рассрочка']"
    );

    private By debtOption = By.xpath(
            "//p[contains(@class,'select__option') and normalize-space()='Задолженность']"
    );
  private By installmentAccount = By.id("score-instalment");
  private By debtAccount = By.id("score-arrears");
  private By paymentDropdownList = By.cssSelector("ul.select__list");
    private By internetPhone = By.id("internet-phone");
   public PaymentPlaceholder(WebDriver driver){
       this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   }
    public String getSelectedPaymentName() {
        return driver.findElement(paymentDropdownValue).getText();
    }
    public String getPhonePlaceholder(){
        return driver.findElement(phonePlaceholder).getAttribute("placeholder");
    }

    public String getSubscriberNumber() {
        return wait.until(driver -> {
            String placeholder = driver.findElement(internetPhone)
                    .getAttribute("placeholder");

            return "Номер абонента".equals(placeholder) ? placeholder : null;
        });
    }
    public String getInstallAccountNumber() {
        return driver.findElement(installmentAccount).getAttribute("placeholder");
    }
    public String getDebtAccountPlaceholder(){
        return driver.findElement(debtAccount).getAttribute("placeholder");
    }

    public void selectHomeInternet() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentDropdownButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDropdownList));
        wait.until(ExpectedConditions.attributeToBe(paymentDropdownList, "style",
                "opacity: 1; visibility: inherit; height: auto;"));
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                paymentDropdownValue, "Домашний интернет"
        ));
    }

    public void selectInstallment() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentDropdownButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDropdownList));
        wait.until(ExpectedConditions.attributeToBe(paymentDropdownList, "style",
                "opacity: 1; visibility: inherit; height: auto;"));

        wait.until(ExpectedConditions.elementToBeClickable(installmentOption)).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                paymentDropdownValue, "Рассрочка"
        ));
    }

    public void selectDebt() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentDropdownButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(paymentDropdownList));
        wait.until(ExpectedConditions.attributeToBe(paymentDropdownList, "style",
                "opacity: 1; visibility: inherit; height: auto;"));

        wait.until(ExpectedConditions.elementToBeClickable(debtOption)).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                paymentDropdownValue, "Задолженность"
        ));
    }

}
