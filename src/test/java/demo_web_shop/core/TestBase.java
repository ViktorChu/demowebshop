package demo_web_shop.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().setPosition(new Point(2500, 0));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    protected boolean isLogOutButtonPresent() {
        System.out.println("Проверка наличия кнопки `Log out`");
        return driver.findElements(By.className("ico-logout")).size() > 0;
    }

    protected void clickOnLoginButton() {
        driver.findElement(By.xpath("//input[@value='Log in']")).click();
        System.out.println("Клик по кнопка 'Log in' произошел");
    }

    protected void enterPersonalData(String email, String password) {
        driver.findElement(By.id("Email")).click();
        System.out.println("Клик по инпуту 'Email' произошел");
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        System.out.println("Ввод email `" + email + "` произошёл успешно");
        driver.findElement(By.id("Password")).click();
        System.out.println("Клик по инпуту 'Password' произошел");
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);
        System.out.println("Ввод password `" + password + "` произошёл успешно");
    }

    protected void clickOnLoginLink() {
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        System.out.println("Клик по текст 'Log in' произошел");
    }
}
