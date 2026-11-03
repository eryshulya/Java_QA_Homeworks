import org.example.Authorization;
import org.example.CommunicationServicesTest;
import org.example.PaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import static org.junit.jupiter.api.Assertions.*;
public class FrontTest extends BaseTest {
    CommunicationServicesTest page;
    Authorization authorization;
    @BeforeEach
    void open() {
        page = new CommunicationServicesTest(driver);
        authorization = new Authorization(driver);
        page.open();
        page.setAcceptCookies();
    }
    @Test
    void blockTitleTest() {
        assertTrue(page.comparingBlockTitle());
    }
    @Test
    void paymentLogosTest() {
        assertAll(
                () -> assertTrue(page.isDisplayedVisaLogo()),
                () -> assertTrue(page.isDisplayedVerifiedVisaLogo()),
                () -> assertTrue(page.isDisplayedMasterCardLogo()),
                () -> assertTrue(page.isDisplayedMasterCardSecureLogo()),
                () -> assertTrue(page.isDisplayedBelkartLogo())
        );
    }
    @Test
    void moreAboutServiceTest() {
        //падал, оказалось дело в ожидании
        String url =
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
       assertEquals(url, page.moreAboutService());
    }
    @Test
    void clickServiceTypeTest() {
        //1. были проблемы с поиском ifram, оказалось дело было в wait - ожидание
        //2. после смены стратегии загрузки полетел, исправила метод isCardNumberVisible() - заработал
        authorization.enterNumber("297777777");
        authorization.enterSum("32");
        authorization.enterEmail("ysh@gmail.com");
        authorization.clickContinue();
        PaymentPage page = new PaymentPage(driver);
        assertTrue(page.isCardNumberVisible());
    }
    }






