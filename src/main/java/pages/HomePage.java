package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import config.ConfigReader;
import utils.ScreenshotUtil;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePage {
    private Page page;
    private Locator buyVehicleLink;
    //private static final String URL = "https://www.tvsmotor.com/";
    private static final String URL= ConfigReader.getProperty("base.url");
    public HomePage(Page page)
    {
        this.page=page;
        buyVehicleLink=page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Buy Vehicle"));
    }
    public void navigate(){
        page.navigate(URL);
        //ScreenshotUtil.captureScreenshot(page,"HomePage");
    }
    public void verifyHomePageLoaded(){
        assertThat(page).hasURL(URL);
        assertThat(buyVehicleLink).isVisible();
    }
    public void clickBuyVehicle(){
        buyVehicleLink.click();
        //Waits until the URL changes.
        page.waitForURL("**/book-online");
        //Waits until the current page finishes loading.
        page.waitForLoadState();
    }
}
