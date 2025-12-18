package tests.apiDemosTest;

import org.testng.annotations.Test;
import pages.apidemos.firstactivity.ApiDemosPage;
import pages.apidemos.firstactivity.preference.PreferencePage;
import pages.apidemos.firstactivity.preference.preferencedepencies.PreferenceDependenciesPage;
import pages.apidemos.firstactivity.views.ViewsPage;
import pages.apidemos.firstactivity.views.draganddrop.DragAndDrop;
import tests.BaseTest;
import tests.TestDataModule.WifiTestData;
import utils.ConfigManager;
import utils.JsonUtils;

public class ApiDemosTest extends BaseTest {
    private final WifiTestData testData;

    public ApiDemosTest(){
        this.apiDemosPage = new ApiDemosPage(driver);
        this.testData= JsonUtils.getTestData(ConfigManager.getProperty("wifi.testdata"), WifiTestData.class);
    }
    @Test
    public void wifiTest(){
        apiDemosPage.clickOnPreferenceBtn();
        preferencePage.clickOnPreferenceDependenciesBtn();
        preferenceDependenciesPage.clickOnWifiCheckBoxBtn();
        preferenceDependenciesPage.clickOnWifiSettingsBtn();
        preferenceDependenciesPage.setWifiName(testData.personalWifiName());
        preferenceDependenciesPage.clickOnOkBtn();
    }

    @Test
    public void companyWifiTest(){
        apiDemosPage.clickOnPreferenceBtn();
        preferencePage.clickOnPreferenceDependenciesBtn();
        preferenceDependenciesPage.clickOnWifiCheckBoxBtn();
        preferenceDependenciesPage.clickOnWifiSettingsBtn();
        preferenceDependenciesPage.setWifiName(testData.personalWifiName());
        preferenceDependenciesPage.clickOnOkBtn();
    }

    @Test
    public void dragAndDropTest(){

        apiDemosPage.clickOnViewsBtn();
        viewsPage.clickOnDragAndDrop();
        dragAndDrop.dragFirstDotTo(629,552);
    }
}
