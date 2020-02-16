package hurt_me_plenty.test;

import hurt_me_plenty.page.CloudPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CloudTest {

    private WebDriver driver;
    private String text2Search;
    private String numberOfInstancesText;
    private String forWhatText;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        text2Search = "Google Cloud Platform Pricing Calculator";
        numberOfInstancesText = "4";
        forWhatText = "";
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
//        driver.quit();
        driver = null;
    }

    @Test
    public void cloudTesting() {
        driver.get("https://cloud.google.com/");
        CloudPage cloudPage = new CloudPage(driver);
        cloudPage
                .search(text2Search)
                .followLink()
                .enter(numberOfInstancesText, forWhatText);
    }
}
