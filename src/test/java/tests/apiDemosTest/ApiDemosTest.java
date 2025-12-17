package tests.apiDemosTest;

import org.testng.annotations.Test;
import pages.apidemos.firstactivity.ApiDemosPage;
import pages.apidemos.firstactivity.preference.PreferencePage;
import pages.apidemos.firstactivity.preference.preferencedepencies.PreferenceDependenciesPage;
import tests.BaseTest;

public class ApiDemosTest extends BaseTest {

    @Test
    public void wifiTest(){
        ApiDemosPage apiDemosPage = new ApiDemosPage(driver);
        PreferencePage preferencePage = new PreferencePage(driver);
        PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage(driver);

        apiDemosPage.clickOnPreferenceBtn();
        preferencePage.clickOnPreferenceDependenciesBtn();
        preferenceDependenciesPage.clickOnWifiCheckBoxBtn();
        preferenceDependenciesPage.clickOnWifiSettingsBtn();
        preferenceDependenciesPage.setWifiName("Mahmoud");
        preferenceDependenciesPage.clickOnOkBtn();
    }
    @Test
    public void dragAndDropTest(){

    }

}
