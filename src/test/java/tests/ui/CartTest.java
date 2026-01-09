package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;

public class CartTest extends BaseTest {

    @Test
    public void addProductAndUpdateQuantity() {

        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        product.openProduct("Combination Pliers");
        product.addToCart();

        cart.openCart();
        cart.updateQuantity(3);

        String totalPrice = cart.getTotalPrice();
        Assert.assertNotNull(totalPrice, "Price should be updated");
    }
}

