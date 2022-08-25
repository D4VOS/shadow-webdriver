# Shadow DOM Webdriver

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### What is it?

It's simple WebDriver wrapper, based
on [sukgu's Shadow Selenium Automation](https://github.com/sukgu/shadow-automation-selenium) project.

Shadow WebDriver can be used as a normal WebDriver.
Supports Shadow and regular DOMs.
It doesn't need `@FindElementBy` annotations in Page Objects. With that wrapper you can use `@FindBy`.

---

### How use it?

Initialize WebDriver as usual:

`WebDriver driver = new ChromeDriver(); // EdgeDriver(), GeckoDriver() etc.`

and then just wrap it..

`driver = new ShadowDriver(driver);`

Enjoy 😄
