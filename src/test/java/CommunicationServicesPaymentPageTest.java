import org.example.Authorization;
import org.example.CommunicationServices;
import org.example.CommunicationServicesPaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
    //Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
    @Test
    void checkIsWorkingContinue (){
        preparePaymentWindow();
        assertEquals("Номер карты", servicesPaymentPage.getNumberOfCard());
    }
    //сравниваем номер телефона
    @Test
    void checkPhoneNumber(){
        preparePaymentWindow();
        assertEquals("375297777777",servicesPaymentPage.getPhoneNumber());
    }
    //сраниваем сумму1
    @Test
    void checkPaymentAmount(){
        preparePaymentWindow();
        assertEquals("55.00 BYN",servicesPaymentPage.getPaymentAmount());
    }
    //сравниваем сумму с кнопки
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
    //имя и фамилия
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
