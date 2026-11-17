import org.example.Authorization;
import org.example.CommunicationServices;
import org.example.CommunicationServicesPaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CommunicationServicesPaymentPageTest extends BaseTest {
    CommunicationServicesPaymentPage servicesPaymentPage;
    Authorization authorization;
    CommunicationServices services;
    @BeforeEach
    void open(){
        servicesPaymentPage = new CommunicationServicesPaymentPage(driver);
        authorization = new Authorization(driver);
        services = new CommunicationServices(driver);
    }
    private void preparePaymentWindow() {
        services.open();
        services.setAcceptCookies();
        authorization.enterNumber("297777777");
        authorization.enterSum("55");
        authorization.enterEmail("ggg_gt@mail.ru");
        authorization.clickContinue();
        servicesPaymentPage.switchToPaymentFrame();
    }
     @Test
    void checkIsWorkingContinue() {
        preparePaymentWindow();
        assertAll(
                () -> assertEquals("Номер карты", servicesPaymentPage.getNumberOfCard()),
                () -> assertEquals("55.00 BYN", servicesPaymentPage.getPaymentAmount())
        );
    }
    @Test
    void checkPhoneNumber(){
        preparePaymentWindow();
        assertEquals("375297777777",servicesPaymentPage.getPhoneNumber());
    }
    @Test
    void checkPaymentAmount(){
        preparePaymentWindow();
        assertEquals("55.00 BYN",servicesPaymentPage.getPaymentAmount());
    }
    @Test
    void checkPaymentAmountButton(){
        preparePaymentWindow();
        assertEquals("55.00 BYN",servicesPaymentPage.getPaymentAmountButton());
    }
    @Test
    void checkNumberOfCard(){
        preparePaymentWindow();
        assertEquals("Номер карты",servicesPaymentPage.getNumberOfCard());
    }
    @Test
    void checkExpirationDate() {
        preparePaymentWindow();
        assertEquals("Срок действия",servicesPaymentPage.getExpirationDate());
    }
    @Test
    void checkExpirationDatePlaceholder(){
        preparePaymentWindow();
        assertEquals("ММ / ГГ",servicesPaymentPage.getExpirationDatePlaceholder());
    }
    @Test
    void checkCVCOfCard(){
        preparePaymentWindow();
        assertEquals("CVC",servicesPaymentPage.getCVCOfCard());
    }
    @Test
    void checkCardHolderName(){
        preparePaymentWindow();
        assertEquals("Имя и фамилия на карте",servicesPaymentPage.getCardHolderName());
    }
    @Test
   void isDisplayedCardVisa(){
        preparePaymentWindow();
        assertTrue(servicesPaymentPage.isDisplayedVisa());
    }
@Test
    void isDisplayedMasterCard(){
    preparePaymentWindow();
    assertTrue(servicesPaymentPage.isDisplayedMastercard());
}
@Test
    void isDisplayedCardBelkartIcon(){
    preparePaymentWindow();
    assertTrue(servicesPaymentPage.isDisplayedBelkartIcon());
}
@Test
    void isDisplayedCardMirIcon(){
    preparePaymentWindow();
        assertTrue(servicesPaymentPage.isDisplayedMir());
}
}
