package io.github.d4vos;

import io.github.sukgu.Shadow;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Sequence;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static io.github.d4vos.support.SelectorProvider.buildSelector;

public class ShadowDriver extends Shadow implements WebDriver, JavascriptExecutor, Interactive, TakesScreenshot {
    private final WebDriver driver; // had to add field due to private WebDriver without getter in parent class

    public ShadowDriver(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public List<WebElement> findElements(By by) {
        String selector = buildSelector(by);
        if (by instanceof By.ByXPath || by instanceof By.ByLinkText || by instanceof By.ByPartialLinkText) {
            return findElementsByXPath(selector);
        }
        return findElements(selector);
    }

    @Override
    public WebElement findElement(By by) {
        String selector = buildSelector(by);
        if (by instanceof By.ByXPath || by instanceof By.ByLinkText || by instanceof By.ByPartialLinkText) {
            return findElementByXPath(selector);
        }
        return findElement(selector);
    }

    //region WebDriver delegates
    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
    //endregion

    //region JavascriptExecutor delegates
    @Override
    public Object executeScript(String s, Object... objects) {
        return ((JavascriptExecutor) driver).executeScript(s, objects);
    }

    @Override
    public Object executeAsyncScript(String s, Object... objects) {
        return ((JavascriptExecutor) driver).executeAsyncScript(s, objects);
    }
    //endregion

    //region Interactive delegates
    @Override
    public void perform(Collection<Sequence> collection) {
        ((Interactive) driver).perform(collection);
    }

    @Override
    public void resetInputState() {
        ((Interactive) driver).resetInputState();
    }
    //endregion

    //region TakesScreenshot delegates
    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return ((TakesScreenshot) driver).getScreenshotAs(outputType);
    }
    //endregion
}
