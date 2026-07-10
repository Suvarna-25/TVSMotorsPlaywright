package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class VehicleSelectionPage {
private Page page;
private Locator tvsJupiter;
private Locator drumSXC;
private Locator nextButton;
public VehicleSelectionPage(Page page){
    this.page=page;
    tvsJupiter = page.getByText("TVS Jupiter").nth(1);
    drumSXC = page.getByRole(
            AriaRole.TAB,
            new Page.GetByRoleOptions().setName("DRUM SXC")
    );
    nextButton = page.locator("button").filter(
            new Locator.FilterOptions().setHasText("Next")
    ).first();
}
public void selectVehicle(){
    tvsJupiter.highlight();
    page.waitForTimeout(3000);
    tvsJupiter.click();
    page.waitForTimeout(5000);
}
public void selectVehicleModel(){
    drumSXC.click();
}
public void clickNext()
{
    nextButton.click();
}
}
