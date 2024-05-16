package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestMathQuestionServiceSelenium {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void login() {
        driver.get("http://localhost:8080/login");
        
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("passwd"));
        WebElement dobField = driver.findElement(By.name("dob"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        usernameField.sendKeys("ahsan");
        passwordField.sendKeys("ahsan_pass");
        dobField.sendKeys("2000-01-01");
        loginButton.click();
        
        assertEquals("http://localhost:8080/q1", driver.getCurrentUrl());
    }

    @Test
    public void testLoginSuccess() {
        login();
    }

    @Test
    public void testQ1CorrectAnswer() {
        login();
        
        WebElement number1Field = driver.findElement(By.name("number1"));
        WebElement number2Field = driver.findElement(By.name("number2"));
        WebElement resultField = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("1");
        number2Field.sendKeys("2");
        resultField.sendKeys("3");
        submitButton.click();
        
        assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
    }

    @Test
    public void testQ1WrongAnswer() {
        login();
        
        WebElement number1Field = driver.findElement(By.name("number1"));
        WebElement number2Field = driver.findElement(By.name("number2"));
        WebElement resultField = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("1");
        number2Field.sendKeys("2");
        resultField.sendKeys("4");
        submitButton.click();
        
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]"));
        assertEquals("Wrong answer, try again.", errorMessage.getText());
    }

    @Test
    public void testQ2CorrectAnswer() {
        testQ1CorrectAnswer();
        
        WebElement number1Field = driver.findElement(By.name("number1"));
        WebElement number2Field = driver.findElement(By.name("number2"));
        WebElement resultField = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("3");
        number2Field.sendKeys("2");
        resultField.sendKeys("1");
        submitButton.click();
        
        assertEquals("http://localhost:8080/q3", driver.getCurrentUrl());
    }

    @Test
    public void testQ2WrongAnswer() {
        testQ1CorrectAnswer();
        
        WebElement number1Field = driver.findElement(By.name("number1"));
        WebElement number2Field = driver.findElement(By.name("number2"));
        WebElement resultField = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("3");
        number2Field.sendKeys("2");
        resultField.sendKeys("5");
        submitButton.click();
        
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]"));
        assertEquals("Wrong answer, try again.", errorMessage.getText());
    }

    @Test
    public void testQ3CorrectAnswer() {
        testQ2CorrectAnswer();
        
        WebElement number1Field = driver.findElement(By.name("number1"));
        WebElement number2Field = driver.findElement(By.name("number2"));
        WebElement resultField = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("2");
        number2Field.sendKeys("3");
        resultField.sendKeys("6");
        submitButton.click();
        
        assertEquals("http://localhost:8080/date1", driver.getCurrentUrl());
    }

    @Test
    public void testQ3WrongAnswer() {
        testQ2CorrectAnswer();
        
        WebElement number1Field = driver.findElement(By.name("number1"));
        WebElement number2Field = driver.findElement(By.name("number2"));
        WebElement resultField = driver.findElement(By.name("result"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        number1Field.sendKeys("2");
        number2Field.sendKeys("3");
        resultField.sendKeys("5");
        submitButton.click();
        
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Wrong answer, try again.')]"));
        assertEquals("Wrong answer, try again.", errorMessage.getText());
    }

    @Test
    public void testDateAfterCorrect() {
        login();
        
        driver.get("http://localhost:8080/date1");
        
        WebElement dateField = driver.findElement(By.name("date"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        dateField.sendKeys("2024-05-14");
        submitButton.click();
        
        assertEquals("http://localhost:8080/date2", driver.getCurrentUrl());
    }

    @Test
    public void testDateBeforeCorrect() {
        testDateAfterCorrect();
        
        WebElement dateField = driver.findElement(By.name("date"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        dateField.sendKeys("2024-05-14");
        submitButton.click();
        
        assertEquals("http://localhost:8080/science", driver.getCurrentUrl());
    }

    @Test
    public void testScienceCorrect() {
        testDateBeforeCorrect();
        
        WebElement massField = driver.findElement(By.name("mass"));
        WebElement accelerationField = driver.findElement(By.name("acceleration"));
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        
        massField.sendKeys("4");
        accelerationField.sendKeys("5");
        submitButton.click();
        
        WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Science problem solved!')]"));
        assertEquals("Science problem solved!", successMessage.getText());
    }
}
