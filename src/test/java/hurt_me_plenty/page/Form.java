package hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Form {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'compute') and contains(.,'Compute Engine')]")
    List<WebElement> inset;

    @FindBy(xpath = "//label[contains(.,'Number of instances')]/../descendant-or-self::input[@name='quantity']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//label[contains(.,'What are these instances for?')]/../descendant-or-self::input[@name='label']")
    private WebElement forWhat;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkAddGPUs;

    @FindBy(xpath = "//label[text()='Number of GPUs']/../descendant-or-self::md-option[@value='1']")
    private WebElement numberOfGPUsVal1;

    public Form(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enter(String numberOfInstancesText, String forWhatText){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'compute') and contains(.,'Compute Engine')]")));
        inset.get(0).click();
        numberOfInstances.sendKeys(numberOfInstancesText);
        forWhat.sendKeys(forWhatText);
        checkAddGPUs.click();
        numberOfGPUsVal1.click();
    }
}
