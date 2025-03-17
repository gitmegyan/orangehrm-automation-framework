package com.hrm.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.URL;
import java.time.Duration;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebdriverConfig {

    @Value("${seelnium.grid.url}")
    private URL url;

    @Bean
    @ConditionalOnProperty(name="browser"  , havingValue = "firefox")
    public WebDriver remoteFirefoxWebDirver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox");
        // capabilities.setPlatform(Platform.WINDOWS);
        return new RemoteWebDriver(this.url, capabilities);
    }

    @Bean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeWebDirver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        // capabilities.setPlatform(Platform.WINDOWS);
        return new RemoteWebDriver(this.url, capabilities);
    }

}
