package com.hrm.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Component
public class ScreenshotUtil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenshot(final String imageName) throws IOException {
        File sourceFile = this.driver.getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(imageName).toFile());
    }
}
