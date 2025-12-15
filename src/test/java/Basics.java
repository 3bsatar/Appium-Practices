import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class Basics {
    AndroidDriver driver;
    @Test
    public void appiumBasics() throws URISyntaxException, MalformedURLException, InterruptedException {
        // Path URL appium SERVER, Capabilities/UIautomator
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("3bs");
        options.setApp("E:\\Testing\\Testing-Projects\\AppiumAuto\\src\\test\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        By preferenceBtn = AppiumBy.accessibilityId("Preference");
        By preferecneDependencies = AppiumBy.accessibilityId("3. Preference dependencies");
        By wifiCheckBox = AppiumBy.id("android:id/checkbox");
        By wifiSettingBtn = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]");
        By wifiNameField = AppiumBy.id("android:id/edit");
        By okBtn = AppiumBy.id("android:id/button1");
        By viewsBtn = AppiumBy.accessibilityId("Views");
        By expandableListBtn = AppiumBy.accessibilityId("Expandable Lists");
        By customAdapterBtn = AppiumBy.accessibilityId("1. Custom Adapter");
        By peopleNameBtn = AppiumBy.xpath("//android.widget.TextView[@text=\"People Names\"]");
        By switchesBtn = AppiumBy.accessibilityId("Switches");
        By galleryBtn = AppiumBy.accessibilityId("Gallery");
        By photosBtn = AppiumBy.accessibilityId("1. Photos");
        By picTwo = AppiumBy.xpath("//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[2]");
        By dragAndDropBtn = AppiumBy.accessibilityId("Drag and Drop");
        By firstRedDot = AppiumBy.id("io.appium.android.apis:id/drag_dot_1");

//        click(preferenceBtn);
//        click(preferecneDependencies);
//        click(wifiCheckBox);
//        click(wifiSettingBtn);
//        sendText(wifiNameField,"Mahmoud Wifi");
//        click(okBtn);

//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
//        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
//        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Mahmoud Wifi");
//        driver.findElement(AppiumBy.id("android:id/button1")).click();
//        Thread.sleep(3000);

        click(viewsBtn);
        click(expandableListBtn);
        pressBackBtn();
        click(dragAndDropBtn);
        dragAndDrop(firstRedDot,629,552);

        //        click(galleryBtn);
//        click(photosBtn);
//        swipeToElement(picTwo);
//        Thread.sleep(3000);
//
//        Assert.assertEquals(driver.findElement(picTwo).getAttribute("focusable"),"true");
//        Thread.sleep(3000);



//        click(expandableListBtn);
//        click(customAdapterBtn);
//        longPressAction(peopleNameBtn);
//        scrollToElement(switchesBtn,"down");


    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void  sendText(By locator,String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void  longPressAction(By locator){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(locator)).getId()
        ));
    }
    public void scrollToElement(By locator,String upOrDown){
        // Java
        // Java
        boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                "left", 100, "top", 100, "width", 200, "height", 2500,
                "direction", upOrDown.toLowerCase(),
                "percent", 3.0
        ));
    }
    public void swipeToElement(By locator){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "direction", "right",
                "elementId", ((RemoteWebElement) driver.findElement(locator)).getId(),
                "percent", 0.01
        ));
    }
    public void pressBackBtn(){
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
    public void dragAndDrop(By locator,int endX,int endY){
        // Java
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) driver.findElement(locator)).getId(),
                "endX", endX,
                "endY", endY
        ));
    }
}
