package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AddressPage;
import pages.HomePage;
import pages.VehicleSelectionPage;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import utils.ExcelUtil;

@Listeners(TestListener.class)
public class TvsMotorTest extends BaseTest {
    @Test
 public void bookVehicleTest(){
        HomePage homePage=new HomePage(page);
        homePage.navigate();
        homePage.verifyHomePageLoaded();
        homePage.clickBuyVehicle();
        VehicleSelectionPage vehicleSelectionPage=new VehicleSelectionPage(page);
        vehicleSelectionPage.selectVehicle();
        System.out.println(page.url());
        vehicleSelectionPage.selectVehicleModel();
        vehicleSelectionPage.verifyVehicleSelectionPageLoaded();
        vehicleSelectionPage.verifyVehicleModelSelectionPageLoaded();
        vehicleSelectionPage.clickNext();
           ExcelUtil excelUtil = new ExcelUtil();
           String mobileNumber = excelUtil.getCellData("Sheet1", 1, 0);
           String fullName=excelUtil.getCellData("Sheet1",1,1);
           String email=excelUtil.getCellData("Sheet1",1,2);

        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);

        AddressPage addressPage=new AddressPage(page);
        addressPage.verifyAddressPageLoaded();
        addressPage.enterLocation();
        addressPage.selectLocation();
        addressPage.acceptPrivacyPolicy();
        addressPage.enterMobileNumber(mobileNumber);
        addressPage.enterFullName(fullName);
       addressPage.enterEmail(email);
        addressPage.clickVerifyMobileNumber();
    }
}
