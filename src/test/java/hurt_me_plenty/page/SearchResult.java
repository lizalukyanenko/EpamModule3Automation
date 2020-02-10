package hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResult {

    private WebDriver driver;
    private String searchTerm;

    @FindBy(xpath = "//a[contains(@class, 'gs-title') and contains(., 'Google Cloud Platform Pricing Calculator')]")
    List<WebElement> resultsLinks;

    public SearchResult(WebDriver driver, String searchTerm) {
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }
}
