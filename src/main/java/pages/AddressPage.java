package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class AddressPage {
    private Page page;
    private Locator locationTextBox;
    private Locator delhiLocation;
    private Locator privacyCheckbox;
    private Locator mobileNumberTextbox;
    private Locator fullNameTextbox;
    private Locator emailIdTextbox;
    private Locator verifyMobileButton;


     public AddressPage(Page page){
         this.page=page;
         locationTextBox = page.locator("input[placeholder='Select Pincode / City']");
         delhiLocation=page.getByText("Delhi,India");
         privacyCheckbox=page.locator("#checkbox-input-privacy");
         mobileNumberTextbox=page.getByPlaceholder("e.g. 9435678990");
         fullNameTextbox=page.getByPlaceholder("e.g. Neha Sharma");
         emailIdTextbox=page.getByPlaceholder("e.g. neha@gmail.com");
         verifyMobileButton=page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Verify Mobile Number"));

     }
     public void enterLocation()
     {
         locationTextBox.fill("Delhi,India");
     }
     public void selectLocation()
     {
         delhiLocation.click();
     }
     public void acceptPrivacyPolicy()
     {
         privacyCheckbox.check();
     }
     public void enterMobileNumber()
     {
         mobileNumberTextbox.fill("9435678990");
     }
     public void enterFullName()
     {
         fullNameTextbox.fill("Dolly");
     }
     public void enterEmail()
     {
         emailIdTextbox.fill("Dolly@gmail.com");
     }
    public void clickVerifyMobileNumber()
    {
        verifyMobileButton.click();
    }

}
