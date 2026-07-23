package reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentManager {
    // Creates a single ExtentReports object for the entire framework.
// 'static' ensures only one report is created and shared.
    private static ExtentReports extentReports;

    // Private constructor to prevent instantiation.
    private ExtentManager() {
    }

// Returns the single instance of ExtentReports.
  public static ExtentReports getExtentReports() {
      if (extentReports == null) {
          //Creates HTML reports file
          ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/AutomationReport.html");
          // Set the title displayed in the browser tab
          sparkReporter.config().setDocumentTitle("Playwright Automation Report");
          sparkReporter.config().setReportName("TVS Motors Automation Test Report");

          // Create the main ExtentReports object
          extentReports = new ExtentReports();

          // Attach the HTML reporter to ExtentReports
          extentReports.attachReporter(sparkReporter);

          // Add system information
          extentReports.setSystemInfo("Tester", "Suvarna");
          extentReports.setSystemInfo("Framework", "Playwright Java");
          extentReports.setSystemInfo("Testing Framework", "TestNG");
      }
      // Return the same report object every time
      return extentReports;
      }
  }
