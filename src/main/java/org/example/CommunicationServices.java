package org.example;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommunicationServices {
   private By blockTitle = By.xpath("//h2[contains(., 'Онлайн пополнение')]");
    private By acceptCookiesButton = By.id("cookie-agree");
    private WebDriver driver;
    private By visaLogo = By.cssSelector("img[alt='Visa']");
    private By verifiedVisaLogo = By.cssSelector("img[alt='Verified By Visa']");
    private By masterCardLogo = By.cssSelector("img[alt='MasterCard']");
    private By masterCardSecureLogo = By.cssSelector("img[alt='MasterCard Secure Code']");
    private By belkartLogo = By.cssSelector("img[alt='Белкарт']");
    private By moreAboutServiceLink = By.linkText("Подробнее о сервисе");
    public CommunicationServices(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get("https://www.mts.by/");
    }
    public void setAcceptCookies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton)).click();
    }
    public boolean comparingBlockTitle() {
        //"ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ" - тест не работает без символа переноса строки
        String header = driver.findElement(blockTitle).getText();
        String expectedTitle = "ОНЛАЙН ПОПОЛНЕНИЕ\n" +
                "БЕЗ КОМИССИИ";
        return header.equalsIgnoreCase(expectedTitle);
    }
    public boolean isDisplayedVisaLogo(){
        return driver.findElement(visaLogo).isDisplayed();
    }
    public boolean isDisplayedVerifiedVisaLogo(){
        return driver.findElement(verifiedVisaLogo).isDisplayed();
    }
    public boolean isDisplayedMasterCardLogo(){
        return driver.findElement(masterCardLogo).isDisplayed();
    }
    public boolean isDisplayedMasterCardSecureLogo(){
        return driver.findElement(masterCardSecureLogo).isDisplayed();
    }
    public boolean isDisplayedBelkartLogo(){
        return driver.findElement(belkartLogo).isDisplayed();
    }
    public String moreAboutService() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(moreAboutServiceLink)).click();
        wait.until(ExpectedConditions.urlContains(
                "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"
        ));
        return driver.getCurrentUrl();
    }
    }

