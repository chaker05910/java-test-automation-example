package org.dmukhin.webui.testng.pageobjects;

/**
 * Abstract base class representing a generic page in the application. Provides an abstract method
 * to retrieve elements on the page.
 */
public abstract class BasePage {

    /**
     * Abstract method to retrieve the elements on the page.
     *
     * @return An instance of IElements containing elements on the page.
     */
    protected abstract IElements elements();
}
