package pages.apidemos.firstactivity.views;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.apidemos.BasePage;

public class ViewsPage extends BasePage {
    private final By dragAndDropBtn = AppiumBy.accessibilityId("Drag and Drop");
    public ViewsPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickOnDragAndDrop(){
        actions.click(dragAndDropBtn);
    }
}
