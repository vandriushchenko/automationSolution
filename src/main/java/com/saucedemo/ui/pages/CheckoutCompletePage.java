package com.saucedemo.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed(){
       int count = driver.findElements(By.xpath("//h2[contains(text(), 'THANK YOU FOR YOUR ORDER')]")).size();
       return count > 0;
    }
}
