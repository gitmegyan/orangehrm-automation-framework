package com.hrm.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
public class WebDriverConfig {

    @Value("${default.timeout:200}")
    private int timeout;

    @Primary
    @Bean
    public WebDriver chromeDriver() {
        return new ChromeDriver();
    }

    @Bean
    public WebDriver firefoxDriver() {
        return new FirefoxDriver();
    }

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeout));
    }
}
