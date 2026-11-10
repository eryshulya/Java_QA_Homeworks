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
            "//li[contains(@class,'select__item')][.//p[text()='Домашний интернет']]"
    );
  private By internetPhone = By.id("internet-phone");
    private By installmentOption = By.xpath(
            "//li[contains(@class,'select__item')][.//p[text()='Рассрочка']]"
    );
  private By installmentAccount = By.id("score-instalment");
    private By debtOption = By.xpath(
            "//li[contains(@class,'select__item')][.//p[text()='Задолженность']]"
    );
  private By debtAccount = By.id("score-arrears");
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

    public String getSubscriberNumber(){
        return driver.findElement(internetPhone).getAttribute("placeholder");
    }
    public String getInstallAccountNumber() {
        return driver.findElement(installmentAccount).getAttribute("placeholder");
    }
    public String getDebtAccountPlaceholder(){
        return driver.findElement(debtAccount).getAttribute("placeholder");
    }
    public void selectHomeInternet() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentDropdownButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(homeInternetOption)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                paymentDropdownValue, "Домашний интернет"
        ));
    }

    public void selectInstallment() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentDropdownButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(installmentOption));
        wait.until(ExpectedConditions.elementToBeClickable(installmentOption)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                paymentDropdownValue, "Рассрочка"
        ));
    }

    public void selectDebt() {
        wait.until(ExpectedConditions.elementToBeClickable(paymentDropdownButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(debtOption));
        wait.until(ExpectedConditions.elementToBeClickable(debtOption)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                paymentDropdownValue, "Задолженность"
        ));
    }
}
