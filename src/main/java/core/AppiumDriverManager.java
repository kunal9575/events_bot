package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;

public class AppiumDriverManager {
    public static AndroidDriver initialize() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
            .setUdid("emulator-5554") // Your BlueStacks ADB ID
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2")
            .setAppPackage("com.flipkart.android")
            .setAppActivity(".activity.HomeFragmentHolderActivity")
            .setNoReset(true)
            .setAutoGrantPermissions(true);

        return new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }
}