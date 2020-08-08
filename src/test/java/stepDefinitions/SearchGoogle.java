package stepDefinitions;

import com.google.inject.Inject;
import cucumber.api.java.en.*;
import objects.components.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchGoogle {
    @Inject
    private WebDriver webDriver;

    @Given("Launch chrome browser")
    public void launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @When("Open Google search app")
    public void open_google_search_app() throws InterruptedException {
        webDriver.get("https://www.google.co.nz");
        Thread.sleep(1000);
    }

    @Then("Search keywords successfully")
    public void search_keywords_successfully() throws InterruptedException {
        GoogleForm googleForm = new GoogleForm(webDriver);
        googleForm.enterSearchKeyword();
        googleForm.clickGoogleBtn();
        Thread.sleep(1000);
    }
}
