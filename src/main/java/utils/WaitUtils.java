package utils;

import com.microsoft.playwright.Locator;

public class WaitUtils {
private WaitUtils()
{
}
public static void waitForVisible(Locator locator){
    locator.waitFor();
}
}
