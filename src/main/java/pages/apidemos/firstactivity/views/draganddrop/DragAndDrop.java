package pages.apidemos.firstactivity.views.draganddrop;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.apidemos.BasePage;

public class DragAndDrop extends BasePage {
    private final By firstRedDot = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");
    public DragAndDrop(AndroidDriver driver) {
        super(driver);
    }
    public void dragFirstDotTo(int x,int y){
        actions.dragAndDrop(firstRedDot,x,y);
    }
}
