package io.github.d4vos.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.d4vos.ShadowDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class TestBase {
    protected static WebDriver driver = null;

    @BeforeAll
    public static void setUp() {
        String browser = System.getProperty("browser", "chrome");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } // TODO: finish for other browser
        driver = new ShadowDriver(driver);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
