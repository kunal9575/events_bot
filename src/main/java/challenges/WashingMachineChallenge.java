package challenges;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WashingMachineChallenge {
    private static final Logger logger = LoggerFactory.getLogger(WashingMachineChallenge.class);
    
    public static void run(AndroidDriver driver) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Wishlist any 2 refrigerators & 2 washing machines\")")).click();
            logger.info("Started washing machine challenge");

            // Add your product selection logic here
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("Selection failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}