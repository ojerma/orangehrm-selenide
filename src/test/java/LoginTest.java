import org.junit.Test;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.*;


public class LoginTest extends BaseTest{

    private String userAdmin = PropertiesLoader.loadProperties("userAdmin");
    private String adminPassword = PropertiesLoader.loadProperties("adminPassword");



    @Test
    public void successLogin() {
        //open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(userAdmin); //loginPage.enterUsername("Admin");
        loginPage.enterPassword(adminPassword);//loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        //DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.correctHeaderText();
        dashboardPage.checkFirstWidgetTitle();
    }

    @Test
    public void invalidPassword(){
        //open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12");
        loginPage.pushLoginButton();
        loginPage.invalidCredText("Invalid credentials");
    }

    @Test
    public void emptyInputFields(){
        //open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("");
        loginPage.pushLoginButton();
        loginPage.emptyFieldsText("Required");
    }

    @Test
    public void forgotPassword(){
        //open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       // LoginPage loginPage = new LoginPage();
        loginPage.followTheForgotPasswordLink();
        //check that we on Reset Password page
        //ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        resetPasswordPage.checkResetPasswordTitle();
        //check URL is correct
        resetPasswordPage.urlIsCorrect();
    }

    @Test
    public void elementsAreVisible(){
        //logo is displayed
        loginPage.logoIsDisplayed();
        //credentials section is displayed
        loginPage.credSectionIsDisplayed();
        loginPage.logoImageIsCorrect();
    }

    @Test
    public void CheckTitlesWidget() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        String[] namesTitles = {"Time at Work", "My Actions", "Quick Launch", "Buzz Latest Posts", "Employees on Leave Today", "Employee Distribution by Sub Unit", "Employee Distribution by Location"};
        dashboardPage.checkAllWidgetTitle(namesTitles);
    }

    @Test
    public void linkedIdLinkIsCorrect(){
        loginPage.followTheLinkedInLink();
        switchToTab(1);
        linkedInPage.logoTextIsCorrect();
        linkedInPage.urlIsCorrect();
    }





}
