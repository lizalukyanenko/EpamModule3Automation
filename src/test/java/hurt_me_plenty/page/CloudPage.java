package hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPage {

    private static final String CLOUD_URL = "https://cloud.google.com/";
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchInput;

    public CloudPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResult search(String term) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.name("q")));

        searchInput.sendKeys(term);
        searchInput.submit();
        return new SearchResult(driver, term);
    }
}
