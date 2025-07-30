package flipkartbot;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class BaseSetup {
    public static AndroidDriver driver;

    public static void initializeDriver() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "127.0.0.1:5555"); // for Bluestacks
        caps.setCapability("platformVersion", "11"); // Android version
        caps.setCapability("appPackage", "com.flipkart.android");
        caps.setCapability("appActivity", "com.flipkart.android.activity.HomeFragmentHolderActivity");
        caps.setCapability("noReset", true);
        caps.setCapability("newCommandTimeout", 300);
        caps.setCapability("adbExecTimeout", 60000);
        caps.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), caps);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
