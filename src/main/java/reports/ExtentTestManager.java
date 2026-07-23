package reports;

import com.aventstack.extentreports.ExtentTest;
public class ExtentTestManager {
    // Stores one ExtentTest object per test thread
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    //prevent object creation
    private ExtentTestManager(){
    }
    //Store the current test
    public static void setTest(ExtentTest Test){
        extentTest.set(Test);
    }
    // Return the current test
    public static ExtentTest getTest() {
        return extentTest.get();
    }
    // Remove the current test after execution
    public static void removeTest() {
        extentTest.remove();
    }
}
