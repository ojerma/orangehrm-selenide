import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private SelenideElement usernameField = $(byCssSelector("[name='username']"));
    private SelenideElement passwordField = $(byAttribute("placeholder","Password"));
    private SelenideElement loginButton = $x("//button[@type='submit']");

    private SelenideElement errorMessage = $x("//p[contains(@class, 'oxd-alert-content-text')]");

    private SelenideElement errorRequired = $(byText("Required"));

    private SelenideElement forgotPasswordLink = $(byCssSelector("[class='orangehrm-login-forgot']")); //$(byClassName("orangehrm-login-forgot")

    private SelenideElement logo =$(byAttribute("alt", "company-branding"));

    private SelenideElement credSection = $(byClassName("orangehrm-demo-credentials"));

    //private ElementsCollection footerLinks = $$("orangehrm-login-footer-sm a"); // kollekcija dva $$. Pervij variant realizacii cherez kollekciju

    //private SelenideElement linkedIdLink = footerLinks.get(0);

    private SelenideElement linkedInLink = $(byXpath("//a[contains(@href,'linkedin.com')]"));

    public void enterUsername(String usernameValue){
        usernameField.shouldBe(visible);
        usernameField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordField.setValue(passwordValue);
    }

    public void pushLoginButton(){
        loginButton.click();
    }

    public void invalidCredText(String expectedText){
        errorMessage.shouldHave(text(expectedText));
    }

    public void emptyFieldsText(String expectedText){
        errorRequired.shouldHave(text("Required"));
    }

    public void followTheForgotPasswordLink(){
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void logoIsDisplayed(){
        logo.shouldBe(visible);
    }

    public void logoImageIsCorrect(){
        //logo.shouldHave(attribute("src", "https://opensource-demo.orangehrmlive.com/web/images/ohrm_branding.png?v=1683010990518"));
        logo.shouldHave(attributeMatching("src", ".*branding.png.*"));

    }

    public void credSectionIsDisplayed(){
        credSection.shouldBe(visible);
    }

    public void followTheLinkedInLink() {
        linkedInLink.shouldBe(visible).click();
    }

    public void successLogin(String usernameValue, String passwordValue){
        enterUsername(usernameValue);
        enterPassword(passwordValue);
        pushLoginButton();
    }


}
