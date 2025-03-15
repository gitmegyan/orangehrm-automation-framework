package com.hrm.pages.hrm;

import com.hrm.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    @Value("${application.url}")
    private String url;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement passowrd;

    @FindBy(tagName = "button")
    private WebElement loginbutton;


    public void goTo() {
        this.driver.get(url);
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.passowrd.sendKeys(password);
        this.loginbutton.click();
    }

    @Override
    public boolean isLoaded() {
        return this.wait.until((d) -> this.username.isDisplayed());
    }
}
