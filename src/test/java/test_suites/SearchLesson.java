package test_suites;


import com.nagwa.pages.HomePage;
import com.nagwa.pages.Login;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchLesson {
    private WebDriver driver;
    int ActualCountQuestion =10;


    @BeforeClass
    public void beforeClass() throws Exception {
        driver = BrowserFactory.getBrowser();
        new Login(driver).login();  }

    @BeforeMethod
    public void navigateToCampaignList() {
        BrowserActions.getCurrentURL(driver);

    }
    @Test
    public void Verify_Count_Questions_in_Worksheet () {
        new HomePage(driver).SelectLanguage();
        new HomePage(driver).Open2ndResultFromSearching();
        int countQuestionsUI=new HomePage(driver).CountQuestions();
        Assertions.assertEquals(countQuestionsUI,ActualCountQuestion);
    }

    @AfterClass
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);
    }


}


