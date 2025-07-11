package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.HorizontalSliderPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HorizontalSliderTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/horizontal_slider";

    @Test
    public void testSliderMovesToCorrectValue() throws InterruptedException {
        driver.get(URL);

        HorizontalSliderPage page = new HorizontalSliderPage(driver);

        double targetValue = 3.5; // Example: move slider to 3.5
        page.moveSliderTo(targetValue);

        // Assert that displayed value matches expected
        String actualValue = page.getCurrentValue();
        System.out.println("Slider moved to: " + actualValue);

        assertEquals(String.valueOf(targetValue), actualValue, "Slider value should match expected.");
    }
}
