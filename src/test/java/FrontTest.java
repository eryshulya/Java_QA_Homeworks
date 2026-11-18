import org.example.Authorization;
import org.example.CommunicationServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class FrontTest extends BaseTest {
    CommunicationServices page;
    Authorization authorization;
    @BeforeEach
    void open() {
        page = new CommunicationServices(driver);
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
                () -> assertTrue(page.isDisplayedBelkartLogo()),
                () -> assertTrue(page.isDisplayedKrokLogo())
        );
    }
    @Test
    void moreAboutServiceTest() {
        String url =
                "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
       assertEquals(url, page.moreAboutService());
    }
    }






