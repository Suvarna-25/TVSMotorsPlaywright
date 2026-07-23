package utils;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    private ScreenshotUtil() {
    }

    public static String captureScreenshot(Page page, String fileName) {

        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        String screenshotPath =
                "screenshots/" + fileName + "_" + timestamp + ".png";
        page.screenshot(new Page.ScreenshotOptions()
                .setPath(Paths.get(screenshotPath)));
        return Paths.get(screenshotPath).toAbsolutePath().toString();
    }
}

