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
        boolean googleLogoImage = webDriver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
        Assert.assertTrue(googleLogoImage);
        boolean searchKeywordFld = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).isDisplayed();
        Assert.assertTrue(searchKeywordFld);
        boolean googleSearchBtn = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).isDisplayed();
        Assert.assertTrue(googleSearchBtn);
        boolean googleImFeelingLuckyBtn = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[2]")).isDisplayed();
        Assert.assertTrue(googleImFeelingLuckyBtn);

        //Hard-coded the keyword = "Software Testing"
        googleForm.enterSearchKeyword();
        googleForm.clickGoogleBtn();
    }

    @Then("Search keywords successfully after feeling lucky")
    public void search_keywords_successfully_after_feeling_lucky() throws InterruptedException {
        GoogleForm googleForm = new GoogleForm(webDriver);
        boolean googleLogoImage = webDriver.findElement(By.xpath("//*[@id=\"hplogo\"]")).isDisplayed();
        Assert.assertTrue(googleLogoImage);
        boolean searchKeywordFld = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).isDisplayed();
        Assert.assertTrue(searchKeywordFld);
        boolean googleSearchBtn = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]")).isDisplayed();
        Assert.assertTrue(googleSearchBtn);
        boolean googleImFeelingLuckyBtn = webDriver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[2]")).isDisplayed();
        Assert.assertTrue(googleImFeelingLuckyBtn);

        //Hard-coded the keyword = "Software Testing"
        googleForm.enterSearchKeyword();
        googleForm.clickFeelLuckyBtn();
    }
}
