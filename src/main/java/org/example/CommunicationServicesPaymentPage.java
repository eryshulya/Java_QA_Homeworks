package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы, нажать кнопку «Продолжить» и
// в появившемся окне проверить корректность отображения
// суммы (в том числе на кнопке) DONE, номера телефона DONE, а также надписей в незаполненных полях для ввода реквизитов карты DONE, наличие иконок платёжных систем.
public class CommunicationServicesPaymentPage {
    private By paymentAmount = By.cssSelector(".pay-description__cost span");//сумма сверху
    private By paymentInfo = By.cssSelector(".pay-description__text span");//номер телефона
    private By paymentButton = By.cssSelector("button[type='submit'] span");//сумма на кнопке модального окна
    private By cardNumber = By.cssSelector("#cc-number + label");//номер карты
    private By expirationDate = By.cssSelector("input[formcontrolname='expirationDate'] + label");;//срок действия
    private By expirationDatePlaceholder = By.cssSelector("input[formcontrolname='expirationDate']");
    private By cvc = By.cssSelector("input[formcontrolname='cvc'] + label");//cvc
    private By cardHolderName = By.cssSelector("input[formcontrolname='holder'] + label");// имя и фамилия
    private By visaIcon = By.cssSelector("img[src*='visa-system.svg']");
    private By masterCardIcon = By.cssSelector("img[src*='mastercard-system.svg']");
    private By belkartIcon = By.cssSelector("img[src*='belkart-system.svg']");
    private By mirIcon = By.cssSelector("img[src*='mir-system-ru.svg']");
    private By paymentFrame = By.cssSelector("iframe.payment-widget-iframe");
    private WebDriverWait wait;
  private WebDriver driver;
  public CommunicationServicesPaymentPage(WebDriver driver){
      this.driver = driver;
      this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }
    public void switchToPaymentFrame() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
    }
    public String getPhoneNumber() {
        String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(paymentInfo)
        ).getText();

        return text.split("Номер:")[1].trim();
    }
    public String getPaymentAmount(){
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAmount)).getText(); //получаем суммы вверху модального окна
    }
   public String getPaymentAmountButton(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentButton)).getText().replace("Оплатить","").trim(); // сумма на кнопке без слова оплатить
   }
   public String getNumberOfCard(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber)).getText();
   }
   public String getExpirationDate(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDate)).getText();
   }
    public String getExpirationDatePlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(expirationDatePlaceholder))
                .getAttribute("placeholder");
    }
  public String getCVCOfCard(){
      return  wait.until(ExpectedConditions.visibilityOfElementLocated(cvc)).getText();
  }
  public String getCardHolderName(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(cardHolderName)).getText();
  }
  public boolean isDisplayedVisa(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(visaIcon)).isDisplayed();
  }
  public boolean isDisplayedMastercard(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(masterCardIcon)).isDisplayed();
  }
  public boolean isDisplayedBelkartIcon(){
      return wait.until(ExpectedConditions.visibilityOfElementLocated(belkartIcon)).isDisplayed();
  }
    public boolean isDisplayedMir() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mirIcon))
                .isDisplayed();
    }

}
