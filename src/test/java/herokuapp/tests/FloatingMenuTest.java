package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.FloatingMenuPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloatingMenuTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/floating_menu";

    // Positive Test: Verify that menu remains visible after scrolling
    @Test
    public void testMenuRemainsVisibleOnScroll() {
        driver.get(URL);

        FloatingMenuPage page = new FloatingMenuPage(driver);

        assertTrue(page.isMenuDisplayed(), "Menu should be visible initially");
        System.out.println("Positive Test: Menu visible on page load");

        page.scrollToBottom();

        assertTrue(page.isMenuDisplayed(), "Menu should remain visible after scrolling");
        System.out.println("Positive Test: Menu remains visible after scrolling");
    }

    // Positive Test: Verify that clicking on each link updates URL
    @Test
    public void testMenuLinksNavigateCorrectly() {
        driver.get(URL);

        FloatingMenuPage page = new FloatingMenuPage(driver);

        // Home
        page.clickHome();
        assertTrue(page.getCurrentUrl().contains("#home"), "Home link should add #home to URL");
        System.out.println("Positive Test: Home link navigated correctly");

        // News
        page.clickNews();
        assertTrue(page.getCurrentUrl().contains("#news"), "News link should add #news to URL");
        System.out.println("Positive Test: News link navigated correctly");

        // Contact
        page.clickContact();
        assertTrue(page.getCurrentUrl().contains("#contact"), "Contact link should add #contact to URL");
        System.out.println("Positive Test: Contact link navigated correctly");

        // About
        page.clickAbout();
        assertTrue(page.getCurrentUrl().contains("#about"), "About link should add #about to URL");
        System.out.println("Positive Test: About link navigated correctly");
    }

    // Negative Test: Verify menu is NOT hidden after scrolling
    @Test
    public void testMenuNotHiddenAfterScroll() {
        driver.get(URL);

        FloatingMenuPage page = new FloatingMenuPage(driver);

        page.scrollToBottom();

        assertTrue(page.isMenuDisplayed(), "Menu should still be visible after scrolling");
        System.out.println("Negative Test: Menu not hidden after scrolling");
    }
}
