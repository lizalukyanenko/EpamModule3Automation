import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ICanWin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchTextarea = wait4ElementLocatedBy(driver, By.id("paste_code"));
        searchTextarea.sendKeys("Hello from WebDriver");

        WebElement searchPasteExpiration = wait4ElementLocatedBy(driver, By.xpath("//*[@value='10M']"));
        searchPasteExpiration.click();

        WebElement searchPasteName = wait4ElementLocatedBy(driver, By.xpath("//*[@name='paste_name']"));
        searchPasteName.sendKeys("helloweb");

        WebElement searchCreatePaste = driver.findElement(By.id("submit"));
        searchCreatePaste.click();

        driver.quit();

    }

    private static WebElement wait4ElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));
    }
}
