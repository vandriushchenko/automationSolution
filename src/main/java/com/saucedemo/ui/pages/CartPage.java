package com.saucedemo.ui.pages;

import com.saucedemo.entities.Product;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'CHECKOUT')]")
    WebElement checkoutButton;
    @FindBy(css = ".cart_item")
    List<WebElement> cartItems;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Checkout button")
    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    @Step("Get products from cart")
    public List<Product> getProductsFromCart() {
        List<Product> products = new ArrayList<>();
        for (WebElement cartItem : cartItems) {
            String name = getItemPart(cartItem, "inventory_item_name");
            String description = getItemPart(cartItem, "inventory_item_desc");
            String price = getItemPart(cartItem, "inventory_item_price");
            products.add(new Product.Builder()
                    .name(name)
                    .description(description)
                    .price(Double.parseDouble(price))
                    .build());
        }
        return products;
    }

    private String getItemPart(WebElement cartItem, String itemPart) {
        return cartItem.findElement(By.xpath(".//div[@class = '" + itemPart + "']")).getText();
    }

}
