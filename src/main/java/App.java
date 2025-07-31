import core.AppiumDriverManager;
import core.ChallengeExecutor;
import io.appium.java_client.android.AndroidDriver;

public class App {
    public static void main(String[] args) {
        try {
            AndroidDriver driver = AppiumDriverManager.initialize();
            System.out.println("⚠️ Please login to Flipkart manually within 60 seconds...");
            Thread.sleep(60000); // Wait for manual login
            
            ChallengeExecutor.runAll(driver); // Auto-runs all challenges
            
            driver.quit();
            System.out.println("✅ All challenges completed!");
        } catch (Exception e) {
            System.err.println("❌ Critical error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}