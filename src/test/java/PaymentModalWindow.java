import org.example.Authorization;
import org.example.CommunicationServicesTest;
import org.example.PaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentModalWindow extends BaseTest {
    Authorization authorization;
    CommunicationServicesTest communication;
    PaymentPage paymentPage;
    @BeforeEach
    void open(){
        authorization = new Authorization(driver);
        communication = new CommunicationServicesTest(driver);
        paymentPage = new PaymentPage(driver);
        communication.open();
        communication.setAcceptCookies();
    }
    @Test
    void clickServiceTypeTest() {
        //1. были проблемы с поиском ifram, оказалось дело было в wait - ожидание
        //2. после смены стратегии загрузки полетел, исправила метод isCardNumberVisible() - заработал
        authorization.enterNumber("297777777");
        authorization.enterSum("32");
        authorization.enterEmail("ysh@gmail.com");
        authorization.clickContinue();
        assertTrue(paymentPage.isCardNumberVisible());
    }
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "32", "150", "498", "499"})
 void validSumTest(String sum){
        authorization.enterNumber("297777777");
        authorization.enterSum(sum);
        authorization.enterEmail("ysh@gmail.com");
        authorization.clickContinue();
       assertEquals(String.format(Locale.US,"%.2f BYN",Double.parseDouble(sum)),paymentPage.valueSum());
    }

}

