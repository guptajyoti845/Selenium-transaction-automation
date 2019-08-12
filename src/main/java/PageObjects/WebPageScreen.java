package PageObjects;

import org.openqa.selenium.By;

public class WebPageScreen {
    public static final By TITLE = By.xpath("//div[@class='title']");
    public static final By BUY_NOW_BUTTON = By.xpath("//*[@class='btn buy']");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@class='cart-checkout']");
    public static final By FIRST_FRAME = By.xpath("//iframe[@id='snap-midtrans']");
    public static final By CONTINUE_BUTTON = By.xpath("//*[@id=\"application\"]/div[1]/a");
    public static final By CREDIT_CARD_PAY_BUTTON = By.xpath("//a[@class='list with-promo']");
    public static final By CARD_NUMBER_INPUT = By.xpath("//*[@class='card-container']/div[1]/input");
    public static final By EXPIRY_DATE_INPUT = By.xpath("//*[@class='card-container']/div[2]/input");
    public static final By CVV_INPUT = By.xpath("//*[@class='card-container']/div[3]/input");
    public static final By PAY_NOW_BUTTON = By.xpath("//*[@class='button-main-content']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@id='PaRes']");
    public static final By SECOND_FRAME = By.xpath("//iframe[starts-with(@src,'https://api.sandbox.veritrans.co.id')]");
    public static final By THIRD_FRAME = By.xpath("//iframe[contains(@src,'https://app.sandbox.midtrans.com/snap/v1/pay?origin')]");
    public static final By OK_BUTTON = By.xpath("//*[@type='submit']");
    public static final By ORDER_SUMMARY_TEXT = By.xpath("//*[@class='text-page-title-content']");
    public static final By SELECT_PAY_TEXT = By.xpath("//*[@class='text-page-title-content']");
    public static final By THANK_YOU_FOR_PURCHASE = By.xpath("//*[@id='container']/div/div/div[1]/div[2]/div/div[2]/div/span[1]");
    public static final By RETRY_BUTTON = By.xpath("//*[@class='app-container']/div[1]/a");
    public static final By TRANSACTION_FAILED_SPAN = By.xpath("//*[@id='application']/div[3]/div/div/div/div/div/div[1]/span");
}