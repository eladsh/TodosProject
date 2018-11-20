import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SeleniumHelpers {

    //region Class Members And Instance
    private WebDriver driver;
    private String url;
    Properties properties;
    ConfigHelpers configHelpers = new ConfigHelpers();
    //endregion

    public WebDriver choosebrowser(String browser)
    {
        switch (browser)
        {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "FireFox":
                System.setProperty("webdriver.firefox.marionette", "D://SeleniumDrivers Java/geckodriver.exe");
                driver = new FirefoxDriver();

                break;
            case "IE":
                driver = new InternetExplorerDriver();
                break;
        }
        return driver;
    }

    public void setValueAndEnter(WebElement element,String value){
       element.sendKeys(value);
       element.sendKeys(Keys.ENTER);
    }

    public void clickElement(WebElement element){
        element.click();
    }


    public void openBrwoser(WebDriver driver) throws IOException {
        properties = configHelpers.buildProp();
        url = configHelpers.getUrlPropertice(properties);
        driver.get(url);

    }

    public void closeBrwoser(){
        driver.close();
    }


    public List<WebElement> createToggleList(WebDriver driver){

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='todo-list']/li/div[@class='view']/input[@class='toggle']"));
        return list;
    }

    public int countList(WebDriver driver){
        List<WebElement> list = driver.findElements(By.xpath("//div[@class='view']"));
        int ListElements;
        return ListElements = list.size();
    }


}
