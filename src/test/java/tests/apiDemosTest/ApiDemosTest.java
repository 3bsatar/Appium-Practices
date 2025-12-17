package tests.apiDemosTest;

import org.testng.annotations.Test;
import pages.apidemos.firstactivity.ApiDemosPage;
import pages.apidemos.firstactivity.preference.PreferencePage;
import pages.apidemos.firstactivity.preference.preferencedepencies.PreferenceDependenciesPage;
import pages.apidemos.firstactivity.views.ViewsPage;
import pages.apidemos.firstactivity.views.draganddrop.DragAndDrop;
import tests.BaseTest;

public class ApiDemosTest extends BaseTest {


    public ApiDemosTest(){
        this.apiDemosPage = new ApiDemosPage(driver);
    }
    @Test
    public void wifiTest(){


        apiDemosPage.clickOnPreferenceBtn();
        preferencePage.clickOnPreferenceDependenciesBtn();
        preferenceDependenciesPage.clickOnWifiCheckBoxBtn();
        preferenceDependenciesPage.clickOnWifiSettingsBtn();
        preferenceDependenciesPage.setWifiName("Mahmoud");
        preferenceDependenciesPage.clickOnOkBtn();
    }
    @Test
    public void dragAndDropTest(){

        apiDemosPage.clickOnViewsBtn();
        viewsPage.clickOnDragAndDrop();
        dragAndDrop.dragFirstDotTo(629,552);
    }
}
