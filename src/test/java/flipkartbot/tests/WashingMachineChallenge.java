package flipkartbot.Challenges;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class WashingMachineChallenge {
    public static void run(AndroidDriver driver) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Tap to participate\")")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Checkout the top deals on refrigerators and washing machines  \")")).click();
        driver.executeScript("mobile:pressKey", Map.of("keycode", 4));
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Wishlist any 2 refrigerators & 2 washing machines from the displayed model and win 3 supercoins \")")).click();

        // Perform clicks based on coordinate taps here if needed...
        driver.executeScript("mobile:pressKey", Map.of("keycode", 4));
    }
}
