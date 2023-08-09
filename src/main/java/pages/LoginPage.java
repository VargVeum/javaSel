package pages;
import com.codeborne.selenide.Condition;
import java.time.Duration;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import pages.LoginPage;
import helpers.Credentials;



public class LoginPage {
    private static final String emailInput = "input[type='email']";
    private final String passwordInput = "input[type='password']";
    private final String submitButton = "button[type='submit']";
    private final String loadManagementLink = "a[href='/tms/load-management']";
    private final String matError = "mat-error.mat-error";


    public LoginPage checkError(String text) {
        $(matError).should(appear, Duration.ofSeconds(30));
        $(matError).shouldHave(text(text));
        return this;
    }

    public LoginPage openPage(String text) {
        open(text);
        return this;
    }

    public LoginPage checkSubmitButtonIsDisabled() {
        $(submitButton).shouldBe(Condition.disabled);
        return this;
    }

    public LoginPage clickSubmitButton() {
        $(submitButton).click();
        return this;
    }

    public LoginPage fillEmailInput(String text) {
        $(emailInput).shouldBe(Condition.visible).setValue(text);
        return this;
    }

    public LoginPage fillPasswordInput(String text) {
        $(passwordInput).shouldBe(Condition.visible).setValue(text);
        return this;
    }
}
