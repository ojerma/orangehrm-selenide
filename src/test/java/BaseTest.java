import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); // esli test svalitsa dolzhen prikrepitsa screenshot
        open(BASE_URL);
    }

    @After
    public void tearDown(){
        closeWebDriver();
    }

    public void switchToTab(int tabNum){ //metod dlja perekluchenija mezhdu vkladkami
        switchTo().window(tabNum);
    }

    LoginPage loginPage = new LoginPage();
    ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
    DashboardPage dashboardPage = new DashboardPage();
    LinkedInPage linkedInPage = new LinkedInPage();
    SideBar sideBar = new SideBar();


}
