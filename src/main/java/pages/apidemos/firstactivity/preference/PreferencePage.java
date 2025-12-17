package pages.apidemos.firstactivity.preference;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.apidemos.BasePage;

public class PreferencePage extends BasePage {
    By preferenceDependencies = AppiumBy.accessibilityId("3. Preference dependencies");

    public PreferencePage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOnPreferenceDependenciesBtn(){
        actions.click(preferenceDependencies);
    }
}
