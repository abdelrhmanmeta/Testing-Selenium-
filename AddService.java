import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddService {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("link website");
        try {
            driver.manage().window().maximize();
            WebElement UserName = driver.findElement(By.xpath("/html/body/app-root/app-login/app-login-form-one/div/div[2]/div[2]/div[1]/form/div[1]/div/input"));
            UserName.sendKeys("email");

            WebElement Password = driver.findElement(By.id("password"));
            Password.sendKeys("password");

            WebElement LoginButton = driver.findElement(By.xpath("/html/body/app-root/app-login/app-login-form-one/div/div[2]/div[2]/div[1]/form/div[4]/p-button/button"));
            LoginButton.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Inventory = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]")));
            Inventory.click();
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement Services = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]/div[2]/div[3]")));
            Services.click();
            WebElement AddService = wait2.until(ExpectedConditions.elementToBeClickable(By.id("product-btn")));
            AddService.click();
            WebElement ServiceName = driver.findElement(By.cssSelector("body > p-dynamicdialog > div > div > div > app-add-service > div > div > div.body > div:nth-child(1) > app-service-component > div > form > div.form-group.name > input"));
            ServiceName.sendKeys(" زراعه موز 1");
            WebElement ServiceDes = driver.findElement(By.cssSelector("body > p-dynamicdialog > div > div > div > app-add-service > div > div > div.body > div:nth-child(1) > app-service-component > div > form > div.form-group.description > textarea"));
            ServiceDes.sendKeys("auto des");
            WebElement ServiceCost = driver.findElement(By.cssSelector("#cardSample > form > div:nth-child(3) > div:nth-child(1) > div > input"));
            ServiceCost.sendKeys("100");
            WebElement ServicePrice = driver.findElement(By.cssSelector("#cardSample > form > div:nth-child(4) > div:nth-child(1) > div > input"));
            ServicePrice.sendKeys("200");
            WebElement ServiceCap = driver.findElement(By.xpath("//*[@id=\"cardSample\"]/form/div[3]/div[2]/div/div[2]/div/input"));
            ServiceCap.sendKeys("15");
            WebElement ProductDiscount = driver.findElement(By.id("discount_fullsize"));
            ProductDiscount.sendKeys("5");
            WebElement SaveService = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/p-dynamicdialog/div/div/div/app-add-service/div/div/div[3]/div[2]/p-button")));
            SaveService.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //driver.quit();
    }
}
