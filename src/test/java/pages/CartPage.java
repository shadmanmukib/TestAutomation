package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.get("https://practicesoftwaretesting.com/cart");
    }

    public void updateQuantity(int qty) {
        WebElement quantity = driver.findElement(By.cssSelector("input[type='number']"));
        quantity.clear();
        quantity.sendKeys(String.valueOf(qty));
    }

    public String getTotalPrice() {
        return driver.findElement(By.className("total-price")).getText();
    }
}

