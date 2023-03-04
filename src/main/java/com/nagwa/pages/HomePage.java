package com.nagwa.pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.python.antlr.ast.Return;

import java.util.List;


public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    int QuestionNumbers;
    private By languageSelection = By.xpath("(//span[contains(text(),'English')])[1]");
    private By LanguageENG = By.xpath("(//a[normalize-space()='English'])[2]");
    private By Search_Icon = By.xpath("//div[@class='search']");
    private By SecondResult = By.xpath("//a[normalize-space()='Addition Polymerization']");
    private By  SearchIndex= By.id("txt_search_query");
    private By  ClickWorksheet= By.xpath("(//div[@class='section-content'])[3]");

    public void SelectLanguage() {
        new ElementActions(driver).click(languageSelection);
        new ElementActions(driver).click(LanguageENG);
    }

    public void Open2ndResultFromSearching() {
        new ElementActions(driver).click(Search_Icon);
        new ElementActions(driver).type(SearchIndex,"addition").keyPress(SearchIndex, Keys.ENTER);
        new ElementActions(driver).click(SecondResult);
    }

    public  int CountQuestions() {
        new ElementActions(driver).click(ClickWorksheet);
        // get first campaign name from partner campaign list
        List<WebElement> worksheet = driver.findElements(By.cssSelector("div.instance"));
        QuestionNumbers = worksheet.size();
        System.out.println("Count Of The Questions = " + QuestionNumbers);
        return QuestionNumbers;
    }
}
