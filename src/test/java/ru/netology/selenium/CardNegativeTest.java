package ru.netology.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CardNegativeTest {
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

    @Test
    void emptyFieldName() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79122518775");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id='name'] span.input__sub")).getText();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void emptyFieldPhone() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expected = "Поле обязательно для заполнения";
        String actual = driver.findElement(By.cssSelector("[data-test-id='phone'] span.input__sub")).getText().trim();

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void emptyFieldAgree() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79122518775");
        //driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expected = "rgba(255, 92, 92, 1)";
        String actual = driver.findElement(By.cssSelector("[data-test-id='agreement'].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expected, actual);
    }
}
