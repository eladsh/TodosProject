import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class Tests {


    //region Class Member
    private WebDriver driver;
    static PageObject po;
    SeleniumHelpers seleniumHelpers = new SeleniumHelpers();
    //endregion



   @BeforeClass
   public static void initAllTests() throws IOException {
       Report.createReport();
   }
    @Before
    public void initPerTest() throws IOException {
        driver = seleniumHelpers.choosebrowser("FireFox");
        po = PageFactory.initElements(driver, PageObject.class);
        seleniumHelpers.openBrwoser(driver);
    }

    //First scenario -  Happy flow - create, complete and delete one task
    @Test
    public void completeAndDeleteOneTask() throws IOException {
        assertTrue("The Task List Not Equals", po.addOneTask(driver));
    }
    // Second scenario -  create, complete and delete list of task
    @Test
    public void completeAndDeleteListOfTask() throws IOException {
        assertTrue("The Task List Not Equals", po.addListOfTask(driver));
    }

    //Third scenario - create, complete partially and delete completed
    @Test
    public void completeOneTaskAndDeleteIt() throws IOException {

        assertTrue("The Task List Equals", po.addListOfTaskAndCompletePatially(driver));

    }
     // Forth scenario - Negative test - validate that "Clear Complete" tab
    //not visible when any task mrked as "Complete"
    @Test
    public void clearCompleteTabUnvisible() throws IOException {

        assertTrue("The Element Visible", po.clearCompleteUnvisible());

    }




    @After
    public void endTest(){
        seleniumHelpers.closeBrwoser();
    }

    @AfterClass
    public static void endAllTests() throws IOException {
        Report.finishReport();
    }




}



