package base;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import config.ConfigReader;
import org.testng.ITestResult;
import utils.PageManager;
import utils.ScreenshotUtil;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        //Playwright engine starts
        playwright = Playwright.create();
        //playwright launches a browser
//        browser = playwright.chromium().launch(
//                new BrowserType.LaunchOptions() //Launch options allow us to configure the browser
//                        .setHeadless(false));// website is appears in UI
        String browserName = ConfigReader.getProperty("browser");
        boolean headless=Boolean.parseBoolean(ConfigReader.getProperty("browser.headless"));
        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
        }
        BrowserContext context = browser.newContext();
        page = context.newPage();//opens the new page
        PageManager.setPage(page); // Store the current page in PageManager
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture screenshot only if the test fails
//if(result.getStatus() == ITestResult.FAILURE) {
//    ScreenshotUtil.captureScreenshot(page, result.getName());
//    System.out.println("Screenshot captured for failed test: " + result.getName());
//}
        if(browser != null)
            browser.close();
        if(playwright != null)
            playwright.close();
        // Remove Page from ThreadLocal
        PageManager.removePage();
        }
    }

