package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AddressPage;
import pages.HomePage;
import pages.VehicleSelectionPage;

public class tvsMotorTest extends BaseTest {
    @Test
 public void bookVehicleTest(){
        HomePage homePage=new HomePage(page);
        homePage.navigate();
        homePage.clickBuyVehicle();
        VehicleSelectionPage vehicleSelectionPage=new VehicleSelectionPage(page);
        vehicleSelectionPage.selectVehicle();
        System.out.println(page.url());
        //page.pause();
        vehicleSelectionPage.selectVehicleModel();
        vehicleSelectionPage.clickNext();
        AddressPage addressPage=new AddressPage(page);
        addressPage.enterLocation();
        addressPage.selectLocation();
        addressPage.acceptPrivacyPolicy();
        addressPage.enterMobileNumber();
        addressPage.enterFullName();
        addressPage.enterEmail();
        addressPage.clickVerifyMobileNumber();
    }
}
