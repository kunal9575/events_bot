package flipkartbot.Challenges;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class PlusSilverChallenge {
    public static void run(AndroidDriver driver) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Tap to participate\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Visit the Plus GOAT page to check out exciting offers, and win 5 coins \")")).click();
        driver.executeScript("mobile:pressKey", Map.of("keycode", 4));
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Take the Plus quiz and answer one quick question to win 5 coins \")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(1)")).click();
        driver.findElement(AppiumBy.accessibilityId("Continue")).click();
        driver.executeScript("mobile:pressKey", Map.of("keycode", 4));
    }
}
