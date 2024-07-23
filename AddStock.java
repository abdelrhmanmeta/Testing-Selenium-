import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.io.FileNotFoundException;
public class AddStock {
    public static void main(String[] args) throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        StringBuilder results = new StringBuilder();
        boolean isTestPassed = true;
        String className = AddStock.class.getSimpleName();
        try {
            driver.get("https://test.dinarcrm.com/authentication/login");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement User_Name = driver.findElement(By.xpath("/html/body/app-root/app-login/app-login-form-one/div/div[2]/div[2]/div[1]/form/div[1]/div/input"));
            User_Name.sendKeys("emp10@atechnologies.info");
            WebElement Password = driver.findElement(By.id("password"));
            Password.sendKeys("!!!!Test2222");
            WebElement Login_Button = driver.findElement(By.xpath("/html/body/app-root/app-login/app-login-form-one/div/div[2]/div[2]/div[1]/form/div[4]/p-button/button"));
            Login_Button.click();
            WebElement Inventory = driver.findElement(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]"));
            Inventory.click();
            WebElement AddStockList = driver.findElement(By.xpath("/html/body/app-root/app-template/div/app-sidebar/div/div/div[3]/div[10]/div[2]/div[4]/p"));
            AddStockList.click();
            WebElement Add_stock = driver.findElement(By.xpath("//*[@id=\"order-btn\"]/p-button[1]/button"));
            Add_stock.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pn_id_7\"]/span")));
            dropdown.click();
            Thread.sleep(5000);
            WebElement ProductDropDownChoice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pn_id_7_1\"]/div/div")));
            ProductDropDownChoice.click();
            WebElement Plus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addOrder\"]/div[2]/div/div[1]/div/div/div[2]/app-order-custom-input/div/div[1]/i")));
            Plus.click();
            WebElement Price = driver.findElement(By.xpath("//*[@id=\"addOrder\"]/div[2]/div/div[1]/div/div/div[3]/app-custom-price-input/div/input"));
            Price.sendKeys("500");
            WebElement Time_dropdown = driver.findElement(By.xpath("//*[@id=\"pn_id_9\"]/span"));
            Time_dropdown.click();
            WebElement Time_choice = driver.findElement(By.xpath("//*[@id=\"pn_id_9_0\"]/div/div"));
            Time_choice.click();
            WebElement Vendor_dropdown = driver.findElement(By.xpath("//*[@id=\"pn_id_11\"]/span"));
            Vendor_dropdown.click();
            WebElement Vendor_choice = driver.findElement(By.xpath("//*[@id=\"pn_id_11_0\"]/div/div"));
            Vendor_choice.click();
            WebElement Create_button = driver.findElement(By.xpath("//*[@id=\"addOrder\"]/div[3]/div[2]/p-button/button"));
            Create_button.click();
            System.out.println(driver.getTitle());
        } catch (Exception e) {
            isTestPassed = false;
            results.append("Test failed: ").append(e.getMessage()).append("\n");
        } finally {
            if (isTestPassed) {
                results.append("Test passed\n");
            }
            driver.quit();
        }
    }
}