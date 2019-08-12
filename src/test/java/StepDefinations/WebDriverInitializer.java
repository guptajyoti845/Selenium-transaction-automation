package StepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Constants.StringConstants.*;

class WebDriverInitializer {
    private final static Logger LOGGER = LogManager.getLogger(WebDriverInitializer.class);

    static WebDriver initialize() throws IOException {
        Properties properties = new Properties();
        WebDriver driver;

        FileInputStream fileInputStream = new FileInputStream(PROPERTIES_FILE_PATH);
        properties.load(fileInputStream);
        String browser = properties.getProperty(BROWSER);

        switch (browser.toLowerCase()) {
            case CHROME:
                System.setProperty(CHROME_WEB_DRIVER, CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                System.setProperty(CHROME_WEB_DRIVER, CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LOGGER.info("WebDriverInitializer is initialized successfully");

        return driver;
    }
}