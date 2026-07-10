package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {
    private Page page;
    private Locator buyVehicleLink;
    private static final String URL = "https://www.tvsmotor.com/";
    public HomePage(Page page)
    {
        this.page=page;
        buyVehicleLink=page.getByRole(AriaRole.LINK,new Page.GetByRoleOptions().setName("Buy Vehicle"));
    }
    public void navigate(){
        page.navigate(URL);
    }
    public void clickBuyVehicle(){
        buyVehicleLink.click();
//        page.waitForURL("**/book-online");
//
//        page.waitForLoadState();
//
//        page.waitForSelector("text=TVS Jupiter");

    }
}
