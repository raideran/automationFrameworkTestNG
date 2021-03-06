package com.japscr.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SeleniumDriverBase
{
    protected WebDriver driver;

    public WebDriver setup(String browserName, boolean capabilities)
    {
        switch(browserName)
        {
            case "Chrome":
                initChrome(capabilities);
                break;
            case "Firefox":
                initFirefox();
                break;
            case "InternetExplorer":
                initInternetExplorer();
                break;
            default:
                System.out.println("Browser does not supported");
                break;
        }
        return driver;
    }

    private void initChrome(boolean enableCapabilities)
    {
        //System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        if(enableCapabilities)
        {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            //options.addArguments("-incognito");
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
        }
        else
        {
            driver = new ChromeDriver();
        }

    }

    public void initFirefox()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver();
    }

    public void initInternetExplorer()
    {
        DesiredCapabilities capa = new DesiredCapabilities();
        driver = new InternetExplorerDriver();
    }
}
