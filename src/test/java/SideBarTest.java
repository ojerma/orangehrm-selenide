import org.junit.Test;

public class SideBarTest extends BaseTest {

    @Test
    public void linksAreDisplayed(){
        loginPage.successLogin("Admin", "admin123");
        dashboardPage.correctHeaderText();
        sideBar.adminLinkIsDisplayed();
        sideBar.pimLinkIsDisplayed();
    }

    @Test
    public void sideBarRolledOut(){
        loginPage.successLogin("Admin", "admin123");
        dashboardPage.correctHeaderText();
        sideBar.clickOnRolledOutButton();
        sideBar.checkSideBarRolledOut();
    }

    @Test
    public void searchExactLink(){
        loginPage.successLogin("Admin", "admin123");
        dashboardPage.correctHeaderText();
        sideBar.enterValueToSearchField("Admin");
        sideBar.displayedLinksQuantityIsCorrect(1);
        sideBar.adminLinkIsDisplayed();
    }


}
