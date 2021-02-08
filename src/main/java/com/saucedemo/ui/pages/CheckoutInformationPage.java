package com.saucedemo.ui.pages;

import com.saucedemo.entities.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {
    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@value = 'CONTINUE']")
    private WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fulfill customer information")
    public void typeCustomerInformation(Customer customer) {
        firstNameField.sendKeys(customer.getFirstName());
        lastNameField.sendKeys(customer.getLastName());
        postalCodeField.sendKeys(customer.getPostalCode());
    }

    @Step("Click Continue button")
    public void clickContinueButton() {
        continueButton.click();
    }
}
