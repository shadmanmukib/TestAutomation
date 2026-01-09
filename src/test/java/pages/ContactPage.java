package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    /* Navigation */
    @FindBy(linkText = "Contact")
    private WebElement contactNavLink;

    /* Form fields */
    @FindBy(id = "first_name")
    private WebElement firstName;

    @FindBy(id = "last_name")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "subject")
    private WebElement subjectDropdown;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy(xpath = "//input[@value='Send']")
    private WebElement sendButton;

    /* Messages */
    @FindBy(className = "invalid-feedback")
    private WebElement validationError;

    @FindBy(className = "alert-success")
    private WebElement successMessage;

    /* Actions */

    public void navigateToContactPage() {
        click(contactNavLink);
        waitForUrlContains("/contact");
    }

    public void submitEmptyForm() {
        click(sendButton);
    }

    public void fillContactForm(
            String fName,
            String lName,
            String emailAddr,
            String subject,
            String msg) {

        type(firstName, fName);
        type(lastName, lName);
        type(email, emailAddr);
        new Select(subjectDropdown).selectByVisibleText(subject);
        type(message, msg);
    }

    public void submitForm() {
        click(sendButton);
    }

    /* Validations */

    public boolean isValidationErrorDisplayed() {
        return isDisplayed(validationError);
    }

    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }
}
