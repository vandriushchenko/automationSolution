package com.saucedemo.ui.pages;

import com.saucedemo.entities.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartIcon;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add product {product.name} to cart")
    public void addToCart(Product product) {
        WebElement item = driver.findElement(By.xpath("//div[contains(text(), '" + product.getName() + "')]/ancestor::div[contains(@class, 'inventory_item')]"));
        item.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]")).click();
    }

    @Step("Open shopping cart")
    public void openShoppingCart(){
        shoppingCartIcon.click();
    }
}
