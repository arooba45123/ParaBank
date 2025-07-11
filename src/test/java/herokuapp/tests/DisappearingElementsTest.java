package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.DisappearingElementsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisappearingElementsTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/disappearing_elements";

    // Positive Test: Click Home and verify it redirects properly
    @Test
    public void testClickHome_Positive() {
        driver.get(URL);

        DisappearingElementsPage page = new DisappearingElementsPage(driver);

        page.clickMenuItem("Home");

        String heading = page.getPageHeading();
        assertEquals("Welcome to the-internet", heading,
                "Home should redirect to main welcome page");

        System.out.println("Positive: Home redirected to welcome page.");
    }

    // Negative Test: Click About and verify Not Found page
    @Test
    public void testClickAbout_Negative() {
        driver.get(URL);

        DisappearingElementsPage page = new DisappearingElementsPage(driver);

        page.clickMenuItem("About");

        String heading = page.getPageHeading();
        assertEquals("Not Found", heading,
                "About should display Not Found page");

        System.out.println("Negative: About displayed Not Found as expected.");
    }

    //  Negative Test: Click Contact Us and verify Not Found page
    @Test
    public void testClickContactUs_Negative() {
        driver.get(URL);

        DisappearingElementsPage page = new DisappearingElementsPage(driver);

        page.clickMenuItem("Contact Us");

        String heading = page.getPageHeading();
        assertEquals("Not Found", heading,
                "Contact Us should display Not Found page");

        System.out.println("Negative: Contact Us displayed Not Found as expected.");
    }

    //  Negative Test: Click Portfolio and verify Not Found page
    @Test
    public void testClickPortfolio_Negative() {
        driver.get(URL);

        DisappearingElementsPage page = new DisappearingElementsPage(driver);

        page.clickMenuItem("Portfolio");

        String heading = page.getPageHeading();
        assertEquals("Not Found", heading,
                "Portfolio should display Not Found page");

        System.out.println("Negative: Portfolio displayed Not Found as expected.");
    }

    //  Negative Test: Click Gallery and verify Not Found page
    @Test
    public void testClickGallery_Negative() {
        driver.get(URL);

        DisappearingElementsPage page = new DisappearingElementsPage(driver);

        page.clickMenuItem("Gallery");

        String heading = page.getPageHeading();
        assertEquals("Not Found", heading,
                "Gallery should display Not Found page");

        System.out.println("Negative: Gallery displayed Not Found as expected.");
    }
}

