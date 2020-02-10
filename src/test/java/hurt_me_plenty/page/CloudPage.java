package hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        searchInput.sendKeys(term);
        searchInput.submit();
        return new SearchResult(driver, term);
    }
}
