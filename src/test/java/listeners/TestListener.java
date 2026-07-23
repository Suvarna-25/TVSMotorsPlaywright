package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.microsoft.playwright.Page;
import reports.ExtentManager;
import utils.PageManager;
import utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import reports.ExtentTestManager;

public class TestListener implements ITestListener{
    // Create a single Extent Report instance for the framework
    private static final ExtentReports extentReports = ExtentManager.getExtentReports();


    @Override
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test Started: " + result.getName());
        // Create a test entry inside the Extent Report
        ExtentTest test = extentReports.createTest(result.getName());

        // Store the current ExtentTest object
        ExtentTestManager.setTest(test);
    }
   @Override
    public void onTestSuccess(ITestResult result)
   {
       System.out.println("Test Passed: " + result.getName());
       // Log PASS status in the Extent Report
       ExtentTestManager.getTest().pass("Test passed");
   }
   @Override
    public void onTestFailure(ITestResult result)
   {
       System.out.println("Test Failure: " + result.getName());
       // Log the failure in Extent Report
       ExtentTest test = ExtentTestManager.getTest();

       test.fail(result.getThrowable());

       // Get the current Playwright Page from PageManager
       Page page=PageManager.getPage();
       // Check whether the Page object exists
       if(page != null)
       {
           // Capture a screenshot using the test method name
           String screenshotPath =
                   ScreenshotUtil.captureScreenshot(page, result.getName());
           System.out.println("Screenshot Path: " + screenshotPath);
           ExtentTestManager.getTest()
                   .addScreenCaptureFromPath(screenshotPath);
         //  System.out.println("Screenshot captured for failed test: " + result.getName());
       }
       else {
           System.out.println("Page is null. Screenshot could not be captured.");
       }
   }
   @Override
    public void onTestSkipped(ITestResult result)
   {
       System.out.println("Test Skipped: " + result.getName());
   }
    @Override
    public void onFinish(ITestContext context)
    {
        // Write all test results to the HTML report
        extentReports.flush();

        System.out.println("Extent Report generated successfully.");
    }
}

