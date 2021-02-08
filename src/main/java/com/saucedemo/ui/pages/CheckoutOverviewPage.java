package com.saucedemo.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {
    @FindBy(css = ".summary_subtotal_label")
    private WebElement summarySubtotalLabel;


    @FindBy(xpath = "//a[contains(text(), 'FINISH')]")
    private WebElement finishButton;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public String getSubtotalText() {
        return summarySubtotalLabel.getText();
    }

    public void clickFinishButton() {
        finishButton.click();
    }
}
