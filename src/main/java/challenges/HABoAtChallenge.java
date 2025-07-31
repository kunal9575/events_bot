package challenges;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HABoAtChallenge {
    private static final Logger logger = LoggerFactory.getLogger(HABoAtChallenge.class);
    
    public static void run(AndroidDriver driver) {
        try {
            WebElement el1 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Tap to participate\")"));
            el1.click();
            logger.info("Clicked participation button");

            WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().className(\"android.widget.ImageView\").instance(5)"));
            el2.click();
            logger.info("Selected product");

            Thread.sleep(2000); // Short delay
        } catch (Exception e) {
            logger.error("Action failed: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}