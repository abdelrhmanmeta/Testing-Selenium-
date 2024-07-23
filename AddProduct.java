import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddProduct {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://test.dinarcrm.com/authentication/login");
        try {
            driver.manage().window().maximize();
            WebElement UserName = driver.findElement(By.xpath("/html/body/app-root/app-login/app-login-form-one/div/div[2]/div[2]/div[1]/form/div[1]/div/input"));
            UserName.sendKeys("emp10@atechnologies.info");

            WebElement Password = driver.findElement(By.id("password"));
            Password.sendKeys("!!!!Test2222");

            WebElement LoginButton = driver.findElement(By.xpath("/html/body/app-root/app-login/app-login-form-one/div/div[2]/div[2]/div[1]/form/div[4]/p-button/button"));
            LoginButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]")));
            Inventory.click();
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Products = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]/div[2]/div[2]")));
            Products.click();
            WebElement AddProduct = wait2.until(ExpectedConditions.elementToBeClickable(By.id("product-btn")));
            AddProduct.click();
            WebElement ProductName = driver.findElement(By.cssSelector("body > p-dynamicdialog > div > div > div > app-add-product-main-page > div > div > div.body > div:nth-child(1) > app-product-component > div > form > div:nth-child(1) > input"));
            ProductName.sendKeys("موز 1");
            WebElement ProductBarcode = driver.findElement(By.cssSelector("body > p-dynamicdialog > div > div > div > app-add-product-main-page > div > div > div.body > div:nth-child(1) > app-product-component > div > form > div:nth-child(2) > div > input"));
            ProductBarcode.sendKeys("banana");
            WebElement ProductDes = driver.findElement(By.cssSelector("body > p-dynamicdialog > div > div > div > app-add-product-main-page > div > div > div.body > div:nth-child(1) > app-product-component > div > form > div:nth-child(3) > textarea"));
            ProductDes.sendKeys("auto des");
            WebElement ProductPrice = driver.findElement(By.cssSelector("#cardSample > form > div:nth-child(3) > div:nth-child(1) > div > input"));
            ProductPrice.sendKeys("100");
            WebElement ProductDiscount = driver.findElement(By.id("discount_fullsize"));
            ProductDiscount.sendKeys("5");
            WebElement SaveProduct = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/p-dynamicdialog/div/div/div/app-add-product-main-page/div/div/div[3]/div[2]/p-button/button")));
            SaveProduct.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //driver.quit();
    }
}
