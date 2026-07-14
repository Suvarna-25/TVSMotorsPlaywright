package utils;

import com.microsoft.playwright.Locator;

public class PlaywrightUtil {
    private PlaywrightUtil(){

    }
    public static void scrollToElement(Locator locator){
       locator.scrollIntoViewIfNeeded();
    }
    public static void highLightElement(Locator locator){
        locator.highlight();
    }

}
