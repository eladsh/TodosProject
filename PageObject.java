import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class PageObject {

    //region Class Member And Instance
     SeleniumHelpers seleniumHelpers = new SeleniumHelpers();
     ConfigHelpers configHelpers = new ConfigHelpers();
     Properties properties;
     private String value;
     private String[] strArr;
     private List<WebElement> toggle;
     private int numOfTaskToDo,numOfCompleteTask;
     private String task;
    //endregion

    //region WebElements
    @FindBy(how = How.XPATH, using = "html/body/section/div/header/input")
    public WebElement newTaskBar;


    @FindBy(how = How.XPATH, using = " html/body/section/div/footer/ul/li[3]/a")
    public WebElement completeTab;


    @FindBy(how = How.XPATH, using = "html/body/section/div/footer/button")
    public WebElement clearComplete;
    //endregion



    //region Methods
    public boolean addListOfTask(WebDriver driver) throws IOException {
        Report.addStep("completeAndDeleteListOfTask","Start Test",true);
        boolean flag = false;
        properties = configHelpers.buildProp();
        value = configHelpers.getTaskProperties(properties);
        strArr = value.split(";");
        for (int i=0; i<strArr.length;i++){
            task = strArr[i];
            seleniumHelpers.setValueAndEnter(newTaskBar,task);
        }
        Report.addStep("Add tasks",true);

        numOfTaskToDo = seleniumHelpers.countList(driver);
        toggle = seleniumHelpers.createToggleList(driver);
        for (int i = 0;i<toggle.size();i++){
            seleniumHelpers.clickElement(toggle.get(i));
        }
        seleniumHelpers.clickElement(completeTab);
        numOfCompleteTask =  seleniumHelpers.countList(driver);

        Report.addStep("Create list of element and compare",true);
        if(numOfTaskToDo==numOfCompleteTask) {
            flag = true;
            System.out.println(flag);
        }
        Report.addStep("Validate tasks in Complete page equal to the completed tasks",flag);
        seleniumHelpers.clickElement(clearComplete);
        Report.addStep("Completed Tasks deleted",true);
         return flag;

    }

    public boolean addOneTask(WebDriver driver) throws IOException {
        Report.addStep("completeAndDeleteOneTask","Start Test",true);
        boolean flag = false;
        properties = configHelpers.buildProp();
        value = configHelpers.getTaskProperties(properties);
        strArr = value.split(";");
        int i =0;
            task = strArr[i];
        seleniumHelpers.setValueAndEnter(newTaskBar,task);
        Report.addStep("Add task",true);
        numOfTaskToDo = seleniumHelpers.countList(driver);
        toggle = seleniumHelpers.createToggleList(driver);
        seleniumHelpers.clickElement(toggle.get(i));
        seleniumHelpers.clickElement(completeTab);
        numOfCompleteTask =  seleniumHelpers.countList(driver);

        if(numOfCompleteTask==1) {
            flag = true;
            System.out.println(flag);
        }
        Report.addStep("Validate task is completed",flag);

        seleniumHelpers.clickElement(clearComplete);
        Report.addStep("Completed task deleted",true);
        return flag;

    }

    public boolean addListOfTaskAndCompletePatially(WebDriver driver) throws IOException {
        Report.addStep("completeOneTaskAndDeleteIt","Start Test",true);
        boolean flag = false;
        properties = configHelpers.buildProp();
        value = configHelpers.getTaskProperties(properties);
        strArr = value.split(";");
        for (int i=0; i<strArr.length;i++){
            task = strArr[i];
            seleniumHelpers.setValueAndEnter(newTaskBar,task);
        }
        Report.addStep("Add Tasks",true);
        numOfTaskToDo = seleniumHelpers.countList(driver);
        toggle = seleniumHelpers.createToggleList(driver);

        for (int i = 0;i<toggle.size()/2;i++){
            seleniumHelpers.clickElement(toggle.get(i));
        }

        Report.addStep("Completed task partially",true);
        seleniumHelpers.clickElement(completeTab);
        numOfCompleteTask =  seleniumHelpers.countList(driver);

        if(numOfTaskToDo!=numOfCompleteTask) {
            flag = true;
            System.out.println(flag);
        }
        Report.addStep("Validate task partially completed",flag);
        seleniumHelpers.clickElement(clearComplete);
         Report.addStep("Completed asks deleted",true);
        return flag;

    }



    public void addNewRecord() throws IOException {

        seleniumHelpers.setValueAndEnter(newTaskBar,"gooo");
    }

    public boolean clearCompleteUnvisible() throws IOException {
        Report.addStep("clearCompleteTabUnvisible","Start Test",true);
        boolean flag = true;
        properties = configHelpers.buildProp();
        value = configHelpers.getTaskProperties(properties);
        strArr = value.split(";");

        for (int i=0; i<strArr.length;i++){
            task = strArr[i];
            seleniumHelpers.setValueAndEnter(newTaskBar,task);
        }

        Report.addStep("Add tasks",true);

        if(clearComplete==null)
            flag = false;
          Report.addStep("Validate that clear complete tab not visible",flag);
         return flag;
    }
    //endregion



}
