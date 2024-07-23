import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddInvoice { public static void main(String[] args) {
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
        WebElement Invoices = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]/div[2]/div[5]/p")));
        Invoices.click();
        WebElement AddInvoice = wait2.until(ExpectedConditions.elementToBeClickable(By.id("order-btn")));
        AddInvoice.click();
        WebElement dropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p-dynamicdialog/div/div/div/app-add-invoice/div/form/div[2]/div[2]/div/div[2]/div")));
        dropdown1.click();
        Thread.sleep(5000);
        WebElement Select1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-0\"]/div/ul/li[1]/div")));
        Select1.click();
        WebElement dropdown2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p-dynamicdialog/div/div/div/app-add-invoice/div/form/div[2]/div[2]/div/div[2]/div[2]/div")));
        dropdown2.click();
        Thread.sleep(5000);
        WebElement Select2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cdk-overlay-1\"]/div/ul/li[1]/div")));
        Select2.click();
        WebElement Add = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p-dynamicdialog/div/div/div/app-add-invoice/div/form/div[3]/div/p-button")));
        Add.click();
        Thread.sleep(5000);
        WebElement Cash = driver.findElement(By.cssSelector("body > p-dynamicdialog > div > div > div > app-add-invoice > div > form > div.scroll-sec.h-420.overflow-auto > div.body > div.ng-star-inserted > div:nth-child(2) > app-invoice-type > div > div.type-head > div > div:nth-child(1) > label"));
        Cash.click();
        WebElement AddFinal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/p-dynamicdialog/div/div/div/app-add-invoice/div/form/div[3]/div/p-button")));
        AddFinal.click();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    //driver.quit();
}
}

