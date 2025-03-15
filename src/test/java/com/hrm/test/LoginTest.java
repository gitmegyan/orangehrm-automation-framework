package com.hrm.test;

import com.hrm.dp.TestDataProvider;
import com.hrm.models.TestCaseModel;
import com.hrm.pages.hrm.LoginPage;
import com.hrm.util.ScreenshotUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.io.IOException;


@SpringBootTest
public class LoginTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private ScreenshotUtil screenshotUtil;


    @Test(dataProvider = "testData", dataProviderClass = TestDataProvider.class)
    public void loginTest(TestCaseModel testCaseModel) throws IOException {
        loginPage.goTo();
        loginPage.isLoaded();
        loginPage.login("Admin", "admin123");
        screenshotUtil.takeScreenshot("login.png");
    }
}
