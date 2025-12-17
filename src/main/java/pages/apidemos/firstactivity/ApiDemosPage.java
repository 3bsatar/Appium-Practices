package pages.apidemos.firstactivity;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.apidemos.BasePage;

public class ApiDemosPage extends BasePage {
    private final By preferenceBtn = AppiumBy.accessibilityId("Preference");
    private final By viewsBtn = AppiumBy.accessibilityId("Views");

    public ApiDemosPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOnPreferenceBtn(){
        actions.click(preferenceBtn);
    }
    public void clickOnViewsBtn(){
        actions.click(viewsBtn);
    }

}
