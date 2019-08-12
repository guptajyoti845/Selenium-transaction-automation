package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPageSimulator {
    private WebDriver driver;

    public WebPageSimulator(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By element) {
        driver.findElement(element).click();
    }

    public String fetchElementText(By element) {
        return driver.findElement(element).getText();
    }

    public void provideInputToElement(By element, String input) {
        driver.findElement(element).sendKeys(input);
    }

    public Boolean isElementDisplayed(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public WebElement getFrameElement(By frame) {
        return driver.findElement(frame);
    }

    public WebDriverWait redirectionToHomeScreen(WebDriver webDriver, Integer waitingTime) {
        webDriver.switchTo().defaultContent();
        return new WebDriverWait(webDriver, waitingTime);

    }

    public WebDriverWait explicitWaiting(Integer waitingTime, WebDriver webDriver) {
        return new WebDriverWait(webDriver, waitingTime);
    }
}