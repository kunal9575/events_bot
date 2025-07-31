package core;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ChallengeExecutor {
    private static final Logger logger = LoggerFactory.getLogger(ChallengeExecutor.class);
    
    public static void runAll(AndroidDriver driver) {
        try {
            List<Class<?>> challenges = findChallengeClasses();
            challenges.sort(Comparator.comparing(Class::getSimpleName));
            
            for (Class<?> challenge : challenges) {
                String challengeName = challenge.getSimpleName();
                logger.info("🚀 Starting challenge: {}", challengeName);
                
                try {
                    Method runMethod = challenge.getMethod("run", AndroidDriver.class);
                    runMethod.invoke(null, driver);
                    logger.info("✅ Completed: {}", challengeName);
                } catch (Exception e) {
                    logger.error("❌ Failed {}: {}", challengeName, e.getCause().getMessage());
                    takeScreenshot(driver, challengeName);
                }
            }
        } catch (Exception e) {
            logger.error("⚡ Engine failure: {}", e.getMessage());
        }
    }

    private static void takeScreenshot(AndroidDriver driver, String challengeName) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path dir = Paths.get("src/main/resources/screenshots");
            Files.createDirectories(dir);
            
            File screenshot = driver.getScreenshotAs(OutputType.FILE);
            Files.move(
                screenshot.toPath(), 
                dir.resolve(challengeName + "_" + timestamp + ".png")
            );
        } catch (Exception e) {
            logger.warn("📸 Failed to save screenshot: {}", e.getMessage());
        }
    }

    private static List<Class<?>> findChallengeClasses() throws Exception {
        List<Class<?>> classes = new ArrayList<>();
        Path challengesPath = Paths.get("src/main/java/challenges");
        
        Files.walk(challengesPath)
            .filter(p -> p.toString().endsWith("Challenge.java"))
            .forEach(p -> {
                String className = "challenges." + 
                    p.getFileName().toString().replace(".java", "");
                try {
                    classes.add(Class.forName(className));
                } catch (Exception e) {
                    System.err.println("⚠️ Failed to load: " + className);
                }
            });
            
        return classes;
    }
}