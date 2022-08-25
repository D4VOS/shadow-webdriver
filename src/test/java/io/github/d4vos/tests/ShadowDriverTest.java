package io.github.d4vos.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShadowDriverTest extends TestBase {
    private static final Logger logger = LoggerFactory.getLogger(ShadowDriverTest.class);
    private final static String baseUrl = "https://www.virustotal.com";

    @BeforeAll
    public static void openPage() {
        driver.get(baseUrl);
    }

    @ParameterizedTest
    @MethodSource("io.github.d4vos.data.DataProvider#findElementSelectors")
    public void driver_shouldFindElement_whenProvideBySelector(By by) {
        WebElement sut = driver.findElement(by);
        logger.info(">>" + by + "<< element tag: " + sut.getAttribute("tagName"));
    }

    @ParameterizedTest
    @MethodSource("io.github.d4vos.data.DataProvider#findElementsSelectors")
    public void driver_shouldFindElements_whenProvideBySelector(By by) {
        List<WebElement> sut = driver.findElements(by);
        logger.info(">>" + by + "<< element count: " + sut.size());
        assert !sut.isEmpty();
    }
}