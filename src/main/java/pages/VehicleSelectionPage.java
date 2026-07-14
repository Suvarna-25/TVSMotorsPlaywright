package pages;

import com.microsoft.playwright.Locator;
import utils.PlaywrightUtil;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class VehicleSelectionPage {
private Page page;
private Locator tvsJupiter;
private Locator drumSXC;
private Locator nextButton;
public VehicleSelectionPage(Page page){
    this.page=page;
//     tvsJupiter = page.locator(".slick-slide")
//             .filter(new Locator.FilterOptions().setHasText("TVS Jupiter"))
//             .first();
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
  //  tvsJupiter.highlight();
    PlaywrightUtil.highLightElement(tvsJupiter);
//    page.waitForURL("**/next-page-url**", () -> {
//        tvsJupiter.click();
//    });
   page.waitForTimeout(3000);
    tvsJupiter.click();
    page.waitForTimeout(5000);
}

public void selectVehicleModel(){
    drumSXC.click();
}
public void verifyVehicleSelectionPageLoaded(){
    assertThat(page).hasURL("https://www.tvsmotor.com/book-online/booking-journey?106");
    assertThat(tvsJupiter).isVisible();
}
public void verifyVehicleModelSelectionPageLoaded(){
    assertThat(drumSXC).isVisible();
    assertThat(nextButton).isVisible();
}
public void clickNext()
{
    nextButton.click();
}
}
