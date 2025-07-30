package flipkartbot;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import flipkartbot.Challenges.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChallengeRunner {

    public static void main(String[] args) throws Exception {
        BaseSetup.initializeDriver();

        Map<String, Runnable> challengeMap = new HashMap<>();
        challengeMap.put("HA BoAt Challenge", () -> HABoAtChallenge.run(BaseSetup.driver));
        challengeMap.put("Plus Silver Challenge", () -> PlusSilverChallenge.run(BaseSetup.driver));
        challengeMap.put("Washing Machines & Refrigerator challenge", () -> WashingMachineChallenge.run(BaseSetup.driver));

        List<WebElement> elements = BaseSetup.driver.findElements(AppiumBy.className("android.widget.TextView"));

        for (WebElement el : elements) {
            String text = el.getText();
            if (challengeMap.containsKey(text)) {
                System.out.println("Running: " + text);
                try {
                    el.click();
                    Thread.sleep(2000);
                    challengeMap.get(text).run();
                } catch (Exception e) {
                    System.out.println("Failed to execute " + text + ": " + e.getMessage());
                }
            }
        }

        BaseSetup.quitDriver();
    }
}
