package tests;
import com.codeborne.selenide.Condition;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.*;
import pages.LoginPage;
import helpers.Credentials;
import helpers.UrlsData;

public class BaseHelper {

//    private final String baseURL = "https://qa-carrier-tms.zuumapp.com/auth/login";
//    private final String shipmentUrl = "https://qa-carrier-tms.zuumapp.com/tms/load-management/shipments";
//    private String login ="imartynenko+carrier11@zuumapp.com";
//    private String password ="Ghjcnjqgfhjkm2!";
    private final String emailInput = "input[type='email']";
    private final String passwordInput = "input[type='password']";
    private final String submitButton = "button[type='submit']";
    private final String loadManagementLink = "a[href='/tms/load-management']";

    protected void loginViaEmail() {
        open(UrlsData.LOGIN_URL);
        $(emailInput).shouldBe(Condition.visible).setValue(Credentials.USERNAME);
        $(passwordInput).shouldBe(Condition.visible).setValue(Credentials.PASSWORD);
        $(submitButton).click();
        $(loadManagementLink).should(appear, Duration.ofSeconds(30));
        $(loadManagementLink).shouldHave(text("Load Management"));
        webdriver().shouldHave(url(UrlsData.SHIPMENT_URL));
        System.out.println("Test was successfully passed");
    }

}
