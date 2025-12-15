import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
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

        click(preferenceBtn);
        click(preferecneDependencies);
        click(wifiCheckBox);
        click(wifiSettingBtn);
        sendText(wifiNameField,"Mahmoud Wifi");
        click(okBtn);
        
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
//        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
//        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("Mahmoud Wifi");
//        driver.findElement(AppiumBy.id("android:id/button1")).click();
        Thread.sleep(3000);
    }
    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void  sendText(By locator,String text){
        driver.findElement(locator).sendKeys(text);
    }
}
