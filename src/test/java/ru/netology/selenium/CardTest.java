package ru.netology.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CardTest {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }
    @BeforeEach
    void startDriver() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
        driver = new ChromeDriver();
    }
    @AfterEach
    void engDriver() {
        driver.quit();
        driver = null;
    }
}
