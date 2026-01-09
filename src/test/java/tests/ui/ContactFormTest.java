package tests.ui;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactFormTest extends BaseTest {
//    @Test
//    public void navigateToContactForm() {
//
//        HomePage homePage = new HomePage(driver);
//        homePage.navigateToContactPage();
//
//        // Optional verification
//        Assert.assertTrue(
//                driver.getCurrentUrl().contains("/contact"),
//                "User should be navigated to Contact page"
//        );
//    }

    @Test
    public void shouldShowValidationErrorsWhenSubmittingEmptyForm() {

        driver.get("https://practicesoftwaretesting.com/contact");
        ContactPage contactPage = new ContactPage(driver);

        // Leave all fields blank
        contactPage.submitEmptyForm();

        // Verify validation errors
        Assert.assertTrue(
                contactPage.isValidationErrorDisplayed(),
                "Validation error should be displayed for empty submission"
        );
    }

    @Test
    public void shouldSubmitContactFormSuccessfullyWithValidData() {

        driver.get("https://practicesoftwaretesting.com/contact");
        ContactPage contactPage = new ContactPage(driver);

        contactPage.fillContactForm(
                "John",
                "Doe",
                "john.doe@test.com",
                "Customer service",
                "This is a test message for contact form validation."
        );

        contactPage.submitForm();

        // Verify success message
        Assert.assertTrue(
                contactPage.isSuccessMessageDisplayed(),
                "Success message should be displayed after valid submission"
        );
    }
}

