package herokuapp.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;

import herokuapp.base.BaseTest;
import herokuapp.pages.JavaScriptAlertsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    public void testSimpleAlert() throws InterruptedException {
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);

        page.open();
        page.clickJSAlert();

        Alert alert = page.switchToAlert();
        assertEquals("I am a JS Alert", alert.getText());
        alert.accept();

        assertEquals("You successfully clicked an alert", page.getResultText());
        System.out.println("Simple Alert Test Passed");
        Thread.sleep(4000);
    }

    @Test
    public void testConfirmAlert_OK() throws InterruptedException {
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);

        page.open();
        page.clickJSConfirm();

        Alert alert = page.switchToAlert();
        assertEquals("I am a JS Confirm", alert.getText());
        alert.accept();

        assertEquals("You clicked: Ok", page.getResultText());
        System.out.println("Confirm Alert OK Test Passed");
        Thread.sleep(4000);
    }

    @Test
    public void testConfirmAlert_Cancel() throws InterruptedException {
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);

        page.open();
        page.clickJSConfirm();

        Alert alert = page.switchToAlert();
        alert.dismiss();

        assertEquals("You clicked: Cancel", page.getResultText());
        System.out.println("Confirm Alert Cancel Test Passed");
        Thread.sleep(4000);
    }

    @Test
    public void testPromptAlert() throws InterruptedException {
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);

        page.open();
        page.clickJSPrompt();

        Alert alert = page.switchToAlert();
        alert.sendKeys("Hello Arooba!");
        alert.accept();

        assertEquals("You entered: Hello Arooba!", page.getResultText());
        System.out.println("Prompt Alert Test Passed");
        Thread.sleep(4000);
    }

    @Test
    public void testPromptAlert_Cancel() throws InterruptedException {
        JavaScriptAlertsPage page = new JavaScriptAlertsPage(driver);

        page.open();
        page.clickJSPrompt();

        Alert alert = page.switchToAlert();
        alert.dismiss();

        assertEquals("You entered: null", page.getResultText());
        System.out.println("Prompt Cancel Test Passed");
        Thread.sleep(4000);
    }
}


