import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BringItOne {
    public static void main(String[] args) throws InterruptedException {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String title = "how to gain dominance among developers";

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchTextarea = wait4ElementLocatedBy(driver, By.id("paste_code"));
        searchTextarea.sendKeys(code);

        List<WebElement> searchSyntaxHighlighting = driver.findElements(By.xpath("//*[@value='8']"));
        searchSyntaxHighlighting.get(0).click();

        WebElement searchPasteExpiration = driver.findElement(By.xpath("//*[@value='10M']"));
        searchPasteExpiration.click();

        WebElement searchPasteName = driver.findElement(By.xpath("//*[@name='paste_name']"));
        searchPasteName.sendKeys(title);

        WebElement searchCreatePaste = driver.findElement(By.id("submit"));
        searchCreatePaste.click();

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'paste_box_line1') and contains(.,'" + title + "')]")));

        List<WebElement> searchResultTitle = driver.findElements(By.xpath("//div[contains(@class, 'paste_box_line1') and contains(.,'" + title + "')]"));
        List<WebElement> searchResultSyntax = driver.findElements(By.xpath("//a[contains(@class, 'buttonsm') and contains(.,'Bash')]"));
        List<WebElement> searchResultCode = driver.findElements(By.xpath("//textarea[contains(@id,'paste_code') and contains(.,'" + code + "')]"));
        System.out.println("Search result number for title " + searchResultTitle.size());
        System.out.println("Search result number for syntax " + searchResultSyntax.size());
        System.out.println("Search result number for code " + searchResultCode.size());

        driver.quit();

    }

    private static WebElement wait4ElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));
    }
}
