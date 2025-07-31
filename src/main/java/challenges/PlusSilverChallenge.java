package challenges;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlusSilverChallenge {
    private static final Logger logger = LoggerFactory.getLogger(PlusSilverChallenge.class);
    
    public static void run(AndroidDriver driver) {
        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Tap to participate\")")).click();
            logger.info("Started Plus challenge");

            driver.findElement(AppiumBy.accessibilityId("Continue")).click();
            logger.info("Completed quiz");

            Thread.sleep(1500);
        } catch (Exception e) {
            logger.error("Quiz failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}