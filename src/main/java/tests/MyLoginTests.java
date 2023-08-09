package tests;

import helpers.UrlsData;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import helpers.Credentials;

public class MyLoginTests extends BaseHelper{

    @Test
    public void loginWithValidCredentials() {
        loginViaEmail();
    }

    @Test
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage(UrlsData.LOGIN_URL)
                .fillEmailInput(Credentials.USERNAME)
                .fillPasswordInput("qqqq")
                .clickSubmitButton()
                .checkError("Invalid password.");
    }

    @Test
    public void loginWithInvalidLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage(UrlsData.LOGIN_URL)
                .fillEmailInput("qqqq")
                .fillPasswordInput(Credentials.PASSWORD)
                .checkSubmitButtonIsDisabled();
    }

    @Test
    public void loginWithEmptyLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage(UrlsData.LOGIN_URL)
                .fillEmailInput("")
                .fillPasswordInput("")
                .checkSubmitButtonIsDisabled();
    }
}
