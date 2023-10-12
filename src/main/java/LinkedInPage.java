import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.assertTrue;

public class LinkedInPage {
        public SelenideElement logoText = $x("(//*[@class='sr-only'])[1]");

        public void logoTextIsCorrect(){
            logoText.shouldBe(Condition.visible).shouldHave(Condition.exactText("LinkedIn"));
        }

        public void urlIsCorrect(){
            assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("linkedin.com"));
        }
    }
