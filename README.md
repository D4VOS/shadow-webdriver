# Shadow DOM Webdriver


![Master CI](https://github.com/d4vos/shadow-webdriver/actions/workflows/build.yml/badge.svg?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.d4vos/shadow-webdriver.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:io.github.d4vos:shadow-webdriver)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

### What is it?

It's simple WebDriver wrapper, based
on [sukgu's Shadow Selenium Automation](https://github.com/sukgu/shadow-automation-selenium) project.

Shadow WebDriver can be used as a normal WebDriver.
Supports Shadow and regular DOMs.
It doesn't need `@FindElementBy` annotations in Page Objects. With that wrapper you can use `@FindBy`.

---

### Installation

Add dependency to your `POM.xml`:

```xml
<dependency>
  <groupId>io.github.d4vos</groupId>
  <artifactId>shadow-webdriver</artifactId>
  <version>0.1.1</version>
</dependency>
```

### How use it?

Initialize WebDriver as usual:

`WebDriver driver = new ChromeDriver(); // EdgeDriver(), GeckoDriver() etc.`

and then just wrap it..

`driver = new ShadowDriver(driver);`

Enjoy 😄
