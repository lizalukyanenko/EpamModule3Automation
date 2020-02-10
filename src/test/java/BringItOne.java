import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BringItOne {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    @Test(description = "Enter in the fields and check availability")
    public void resultNotEmpty() {
        String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";
        String title = "how to gain dominance among developers";

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
                        .presenceOfAllElementsLocatedBy(By.xpath("//h1[text()='" + title + "']")));

        List<WebElement> searchResultTitle = driver.findElements(By.xpath("//h1[text()='" + title + "']"));
        List<WebElement> searchResultSyntax = driver.findElements(By.xpath("//a[contains(@class, 'buttonsm') and contains(.,'Bash')]"));
        List<WebElement> searchResultCode = driver.findElements(By.xpath("//textarea[contains(@id,'paste_code') and contains(.,'" + code + "')]"));

        System.out.println("Search result number for title " + searchResultTitle.size());
        System.out.println("Search result number for syntax " + searchResultSyntax.size());
        System.out.println("Search result number for code " + searchResultCode.size());

        Assert.assertTrue(searchResultCode.size() > 0 && searchResultSyntax.size() > 0 && searchResultTitle.size() > 0, "One of the results is empty!");


    }

    private static WebElement wait4ElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(by));
    }
}
