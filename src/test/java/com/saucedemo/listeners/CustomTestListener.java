package com.saucedemo.listeners;

import com.saucedemo.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomTestListener extends TestListenerAdapter {
    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshot(iTestResult);
        if(iTestResult.getThrowable()!=null)
            iTestResult.getThrowable().printStackTrace();
    }

    @Attachment(value = "Screenshot", type = "image.png")
    private byte[] makeScreenshot(ITestResult result){
        Object currentClass = result.getInstance();
        WebDriver driver = ((BaseTest) currentClass).driver;
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}