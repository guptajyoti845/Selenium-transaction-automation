package StepDefinations;

import PageObjects.WebPageScreen;
import PageObjects.WebPageSimulator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

import static Constants.StringConstants.*;
import static PageObjects.WebPageScreen.*;

public class WebPageLogics {
    private static final Logger LOGGER = LogManager.getLogger(WebPageLogics.class);
    private WebPageSimulator webPageSimulator;
    private WebDriver webDriver;

    @Given("^Initialize the browser with chrome$")
    public void testSetup() throws IOException {
        webDriver = WebDriverInitializer.initialize();

        LOGGER.info(BROWSER_URL);
        webDriver.get(BROWSER_URL);
        webDriver.manage().window().maximize();

        webPageSimulator = new WebPageSimulator(webDriver);
    }

    @Given("^\"([^\"]*)\" title is visible$")
    public void titleIsVisible(String titleText) {
        switch (titleText) {
            case MIDTRANS_PILLOW:
                String title = webPageSimulator.fetchElementText(TITLE);
                Assert.assertEquals(title, titleText);

                LOGGER.info(title + IS_SUCCESSFULLY_VISIBLE);
                break;

            case SELECT_PAYMENT:
                String selectPayText = webPageSimulator.fetchElementText(SELECT_PAY_TEXT);
                Assert.assertEquals(selectPayText, titleText);

                LOGGER.info(selectPayText + IS_SUCCESSFULLY_VISIBLE);
                break;

            case THANK_YOU_FOR_YOUR_PURCHASE:
                WebDriverWait webDriverWait = webPageSimulator.redirectionToHomeScreen(webDriver, 6);

                webDriverWait.until(ExpectedConditions
                        .visibilityOf(webPageSimulator
                                .getFrameElement(THANK_YOU_FOR_PURCHASE)));

                String thankYouForPurchaseText = webPageSimulator.fetchElementText(THANK_YOU_FOR_PURCHASE);
                Assert.assertEquals(thankYouForPurchaseText, titleText);

                LOGGER.info(thankYouForPurchaseText + IS_SUCCESSFULLY_VISIBLE);
                break;

            case TRANSACTION_FAILED:
                String transactionFailedText = webPageSimulator.fetchElementText(WebPageScreen.TRANSACTION_FAILED_SPAN);
                Assert.assertEquals(transactionFailedText, titleText);

                LOGGER.info(transactionFailedText + IS_SUCCESSFULLY_VISIBLE);
                break;
        }
    }

    @Given("^\"([^\"]*)\" button is visible$")
    public void buttonIsVisible(String button) throws Throwable {
        switch (button.toUpperCase()) {
            case BUY_NOW:
                Assert.assertTrue(webPageSimulator.isElementDisplayed(BUY_NOW_BUTTON));

                LOGGER.info(button + IS_SUCCESSFULLY_VISIBLE);
                break;

            case CHECKOUT:
                Assert.assertTrue(webPageSimulator.isElementDisplayed(CHECKOUT_BUTTON));

                LOGGER.info(button + IS_SUCCESSFULLY_VISIBLE);
                break;

            case CONTINUE:
                webDriver.switchTo().frame(webPageSimulator.getFrameElement(FIRST_FRAME));
                Assert.assertTrue(webPageSimulator.isElementDisplayed(CONTINUE_BUTTON));

                LOGGER.info(button + IS_SUCCESSFULLY_VISIBLE);
                break;

            case PAY_NOW:
                Assert.assertTrue(webPageSimulator.isElementDisplayed(PAY_NOW_BUTTON));

                LOGGER.info(button + IS_SUCCESSFULLY_VISIBLE);
                break;

            case RETRY:
                Thread.sleep(1000);
                WebDriverWait webDriverWait = webPageSimulator.explicitWaiting(1, webDriver);

                webDriverWait.until(ExpectedConditions
                        .frameToBeAvailableAndSwitchToIt(webPageSimulator
                                .getFrameElement(THIRD_FRAME)));

                Assert.assertTrue(webPageSimulator.isElementDisplayed(RETRY_BUTTON));

                LOGGER.info(button + IS_SUCCESSFULLY_VISIBLE);
                break;
        }
    }

    @Then("^\"([^\"]*)\" button is clicked$")
    public void buttonIsClicked(String button) throws Throwable {
        switch (button) {
            case BUY_NOW:
                webPageSimulator.clickOnElement(BUY_NOW_BUTTON);
                WebDriverWait webDriverWait = webPageSimulator.explicitWaiting(2, webDriver);

                webDriverWait.until(ExpectedConditions
                        .visibilityOf(webPageSimulator
                                .getFrameElement(CHECKOUT_BUTTON)));
                break;

            case CHECKOUT:
                webPageSimulator.clickOnElement(CHECKOUT_BUTTON);
                break;

            case CONTINUE:
                webPageSimulator.clickOnElement(CONTINUE_BUTTON);
                break;

            case CREDIT_CARD:
                Thread.sleep(2000);
                webPageSimulator.clickOnElement(CREDIT_CARD_PAY_BUTTON);
                break;

            case PAY_NOW:
                webPageSimulator.clickOnElement(PAY_NOW_BUTTON);
                break;

            case OK:
                webPageSimulator.clickOnElement(OK_BUTTON);
                break;

            case RETRY:
                webPageSimulator.clickOnElement(RETRY_BUTTON);
                break;
        }
    }

    @Then("^Enter CardNumber \"([^\"]*)\"$")
    public void enterCardNumber(String cardNumber) {
        webPageSimulator.provideInputToElement(CARD_NUMBER_INPUT, cardNumber);

        LOGGER.info(cardNumber + ENTERED_SUCCESSFULLY);
    }

    @Then("^Enter ExpiryDate \"([^\"]*)\"$")
    public void enterExpiryDate(String expiryDate) {
        webPageSimulator.provideInputToElement(EXPIRY_DATE_INPUT, expiryDate);

        LOGGER.info(expiryDate + ENTERED_SUCCESSFULLY);
    }

    @Then("^Enter CVV \"([^\"]*)\"$")
    public void enterCVV(String CVV) {
        webPageSimulator.provideInputToElement(CVV_INPUT, CVV);

        LOGGER.info(CVV + ENTERED_SUCCESSFULLY);
    }

    @Then("^Enter Password \"([^\"]*)\"$")
    public void enterPassword(String password) {
        webDriver.switchTo().frame(webPageSimulator.getFrameElement(SECOND_FRAME));
        webPageSimulator.provideInputToElement(PASSWORD_INPUT, password);

        LOGGER.info(password + ENTERED_SUCCESSFULLY);
    }

    @And("^close the browser$")
    public void tearDown() {
        webDriver.quit();

        LOGGER.info(BROWSER_CLOSED_SUCCESSFULLY);
    }
}