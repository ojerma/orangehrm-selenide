import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class SideBar {
    private SelenideElement adminLink =
            $x("//a[contains(@href,'/admin/viewAdminModule')]");
    private SelenideElement pimLink =
            $x("//a[contains(@href,'/pim/viewPimModule')]");

    private SelenideElement rollOutButton = $("[class=\"oxd-icon-button oxd-main-menu-button\"]");
    private SelenideElement sideBarPanel = $(By.className("oxd-sidepanel"));
    private SelenideElement searchInputField = $("[class=\"oxd-main-menu-search\"]").find(byTagName("input"));
    private ElementsCollection displayedLinks = $$("[class=\"oxd-main-menu-item-wrapper\"]");

    public void adminLinkIsDisplayed(){
        adminLink.shouldBe(Condition.visible);
    }

    public void pimLinkIsDisplayed(){
        pimLink.shouldBe(Condition.visible);
    }

    public void clickOnRolledOutButton(){
        rollOutButton.shouldBe(Condition.enabled, Duration.ofSeconds(10)).click();
    }

    public void checkSideBarRolledOut(){
        sideBarPanel.shouldHave(attributeMatching("class", ".*toggled.*"));
    }
    
    public void enterValueToSearchField(String query){
        searchInputField.setValue(query);
    }
    public void displayedLinksQuantityIsCorrect(int expectedQuantity){
        displayedLinks.shouldHave(CollectionCondition.size(expectedQuantity));
    }
}
