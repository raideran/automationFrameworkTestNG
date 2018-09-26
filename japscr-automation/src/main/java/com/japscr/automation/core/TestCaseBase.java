package com.japscr.automation.core;

import com.japscr.automation.core.SeleniumDriverBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestCaseBase extends SeleniumDriverBase
{
    /*
     * This method will run before every testcase
     * and will setup the browser driver
     */

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void initSetup(String browser)
    {
        driver = super.setup(browser, true);
    }

    /*
     * This method will run after every testcase
     * and will shutdown the webdriver instance
     */
    @AfterMethod(alwaysRun = true)
    public void quitSetup()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return super.driver;
    }

}
