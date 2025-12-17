package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {
    private final AppiumDriverLocalService appiumServer ;
    protected AndroidDriver driver;
    WebDriverWait wait;

    public BaseTest(){
        this.appiumServer = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\3bsatar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
    }

    @BeforeClass
    public void  initAppiumServer(){
        appiumServer.start();
    }

    @BeforeMethod
    public void startDriver() throws URISyntaxException, MalformedURLException {
        createDriver();
    }

    @AfterMethod
    public void closeDriver(){
        driver.quit();
    }
    @AfterClass
    public void closeAppiumServer(){
        appiumServer.stop();
    }

    public void createDriver () throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("3bs");
        options.setApp("E:\\Testing\\Testing-Projects\\AppiumAuto\\src\\test\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);

    }
}
