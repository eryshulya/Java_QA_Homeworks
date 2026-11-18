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
    void open() {
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
        authorization.clickBankCardButton();
        servicesPaymentPage.switchToPaymentFrame();
    }

    @Test
    void checkPaymentInformation() {
        preparePaymentWindow();
        assertAll(
                () -> assertEquals("55.00 BYN", servicesPaymentPage.getPaymentAmount()),
                () -> assertEquals("55.00 BYN", servicesPaymentPage.getPaymentAmountButton()),
                () -> assertEquals("375297777777", servicesPaymentPage.getPhoneNumber())
        );
    }

    @Test
    void checkCardFields() {
        preparePaymentWindow();
        assertAll(
                () -> assertEquals("Номер карты", servicesPaymentPage.getNumberOfCard()),
                () -> assertEquals("Срок действия", servicesPaymentPage.getExpirationDate()),
                () -> assertEquals("ММ / ГГ", servicesPaymentPage.getExpirationDatePlaceholder()),
                () -> assertEquals("CVC", servicesPaymentPage.getCVCOfCard()),
                () -> assertEquals("Имя и фамилия на карте", servicesPaymentPage.getCardHolderName())
        );
    }

    @Test
    void checkPaymentSystemsIcons() {
        preparePaymentWindow();

        assertAll(
                () -> assertTrue(servicesPaymentPage.isDisplayedVisa()),
                () -> assertTrue(servicesPaymentPage.isDisplayedMastercard()),
                () -> assertTrue(servicesPaymentPage.isDisplayedBelkartIcon()),
                () -> assertTrue(servicesPaymentPage.isDisplayedMir())
        );
    }
}