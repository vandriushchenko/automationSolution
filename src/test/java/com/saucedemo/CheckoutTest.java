package com.saucedemo;

import com.saucedemo.entities.Customer;
import com.saucedemo.entities.Product;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
public class CheckoutTest extends BaseTest {
    @Test
    @Feature("OPTION 2")
    public void validateCheckout() {
        Product product1 = new Product.Builder()
                .name("Sauce Labs Backpack")
                .description("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.")
                .price(29.99)
                .build();
        Product product2 = new Product.Builder()
                .name("Sauce Labs Bike Light")
                .description("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.")
                .price(9.99)
                .build();
        Customer customer = new Customer.Builder()
                .firstName("Ann")
                .lastName("Smith")
                .postalCode("1234")
                .build();
        double subtotal = product1.getPrice() + product2.getPrice();
        List<Product> expectedProducts = Arrays.asList(product1, product2);
        loginPage.login(USERNAME, PASSWORD);

        productsPage.addToCart(product1);
        productsPage.addToCart(product2);
        productsPage.openShoppingCart();
        List<Product> actualProducts = cartPage.getProductsFromCart();
        Assert.assertEquals(actualProducts, expectedProducts);
        cartPage.clickCheckoutButton();
        checkoutInformationPage.typeCustomerInformation(customer);
        checkoutInformationPage.clickContinueButton();

        String actualAmount = checkoutOverviewPage.getSubtotalText();
        Assert.assertTrue(actualAmount.contains(String.valueOf(subtotal)));
        checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isDisplayed());
    }
}
