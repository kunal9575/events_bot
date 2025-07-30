package flipkartbot.Challenges;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class HABoAtChallenge {
    public static void run(AndroidDriver driver) {
        WebElement el1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Tap to participate\")"));
        el1.click();

        WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(5)"));
        el2.click();

        // Add more steps based on your recorder data

        driver.executeScript("mobile:pressKey", Map.of("keycode", 4)); // Back
    }
}
