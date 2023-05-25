package ru.netology.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CardNegativeTest {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }

    @BeforeEach
    void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
    }

    @AfterEach
    void engDriver() {
        driver.quit();
        driver = null;
    }

    @Test
    void emptyFieldAll() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Поле обязательно для заполнения";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void emptyFieldName() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79122518775");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Поле обязательно для заполнения";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void invalidNameByLanguage() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Dima");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79122518775");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void invalidNameBySpecialCharacters() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий_Tarasov");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79122518775");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы.";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void emptyFieldPhone() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Поле обязательно для заполнения";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void invalidPhoneByNoPlus() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("79122518775");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void invalidPhoneByCount() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+7912251877");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();

        String expectedText = "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678.";
        String expectedColor = "rgba(255, 92, 92, 1)";
        String actualText = driver.findElement(By.cssSelector("[class].input_invalid span.input__sub")).getText().trim();
        String actualColor = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expectedText, actualText);
        Assertions.assertEquals(expectedColor, actualColor);
    }

    @Test
    void emptyFieldAgree() {
        driver.get("http://localhost:9999/");
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Дмитрий");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79122518775");
        driver.findElement(By.tagName("button")).click();

        String expected = "rgba(255, 92, 92, 1)";
        String actual = driver.findElement(By.cssSelector("[class].input_invalid")).getCssValue("color");

        Assertions.assertEquals(expected, actual);
    }
}
