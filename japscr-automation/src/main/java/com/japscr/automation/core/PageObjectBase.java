package com.japscr.automation.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;


public abstract class PageObjectBase extends LoadableComponent<PageObjectBase>
{
    protected WebDriver driver;
    protected final String BASE_URL = "http://www.google.com";

    public PageObjectBase(WebDriver driver)
    {
        this.driver = driver;
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public Boolean isPageLoaded(String pageTitle)
    {
        if(getPageTitle().equals(pageTitle))
            return true;
        else
            return false;
    }
}
