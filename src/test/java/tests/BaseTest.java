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
import pages.apidemos.firstactivity.ApiDemosPage;
import pages.apidemos.firstactivity.preference.PreferencePage;
import pages.apidemos.firstactivity.preference.preferencedepencies.PreferenceDependenciesPage;
import pages.apidemos.firstactivity.views.ViewsPage;
import pages.apidemos.firstactivity.views.draganddrop.DragAndDrop;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class BaseTest {
    private final AppiumDriverLocalService appiumServer ;
    protected AndroidDriver driver;
    protected ApiDemosPage apiDemosPage;
    protected PreferencePage preferencePage;
    protected PreferenceDependenciesPage preferenceDependenciesPage;
    protected ViewsPage viewsPage;
    protected DragAndDrop dragAndDrop;

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
        createObjects();
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
        options.setDeviceName("PixelTest");
        options.setApp("E:\\Testing\\Testing-Projects\\AppiumAuto\\src\\test\\resources\\ApiDemos-debug.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(),options);

    }
    public void createObjects(){
        this.apiDemosPage=new ApiDemosPage(driver);
        this.preferencePage = new PreferencePage(driver);
        this.preferenceDependenciesPage = new PreferenceDependenciesPage(driver);
        this.viewsPage= new ViewsPage(driver);
        this.dragAndDrop= new DragAndDrop(driver);
    }
}
