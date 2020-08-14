package objects.components;

import com.google.inject.Inject;
import org.openqa.selenium.*;

public class GoogleForm {
    private WebDriver webDriver;

    private By searchContext;

    private By searchKeywordFld = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input");

    private By searchGoogleBtn = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]");

    private By searchFeelLuckyBtn = By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[2]");

    @Inject
    public GoogleForm(WebDriver webDriver) {
        this(webDriver, By.id("viewport"));
    }

    public GoogleForm(WebDriver webDriver, By searchContext)
    {
        this.webDriver = webDriver;
        this.searchContext = searchContext;
    }

    private SearchContext getSearchContext()
    {
        return webDriver.findElement(searchContext);
    }

    public void enterSearchKeyword() {
        getSearchContext().findElement(searchKeywordFld).sendKeys("Software Testing");
    }
    public void clickGoogleBtn() { getSearchContext().findElement(searchGoogleBtn).click(); }
    public void clickFeelLuckyBtn() {
        getSearchContext().findElement(searchFeelLuckyBtn).click();
    }
}
