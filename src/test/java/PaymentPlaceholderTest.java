import org.example.CommunicationServices;
import org.example.PaymentPlaceholder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentPlaceholderTest extends BaseTest{
    PaymentPlaceholder paymentPage;
    CommunicationServices communication;
    @BeforeEach
    void open(){
        paymentPage = new PaymentPlaceholder(driver);
        communication = new CommunicationServices(driver);
       communication.open();
       communication.setAcceptCookies();
    }
    @Test
    void checkCommunicationServicesPlaceholders() {
        assertAll(
                () -> assertEquals("Услуги связи", paymentPage.getSelectedPaymentName()),
                () -> assertEquals("Номер телефона", paymentPage.getPhonePlaceholder())
        );
    }
    @Test
    void checkHomeInternetPlaceholders() {
        paymentPage.selectHomeInternet();
        assertAll(
                () -> assertEquals("Домашний интернет", paymentPage.getSelectedPaymentName()),
                () -> assertEquals("Номер абонента", paymentPage.getSubscriberNumber())
        );
    }

    @Test
    void checkInstallmentPlaceholders() {
        paymentPage.selectInstallment();
        assertAll(
                () -> assertEquals("Рассрочка", paymentPage.getSelectedPaymentName()),
                () -> assertEquals("Номер счета на 44", paymentPage.getInstallAccountNumber())
        );
    }

    @Test
    void checkDebtPlaceholders() {
        paymentPage.selectDebt();
        assertAll(
                () -> assertEquals("Задолженность", paymentPage.getSelectedPaymentName()),
                () -> assertEquals("Номер счета на 2073", paymentPage.getDebtAccountPlaceholder())
        );
    }
}
