import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class  Report {
    //Data members
    static String reportPath;
    static Writer writer;

    public static void createReport() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmm").format(Calendar.getInstance().getTime());
        reportPath = "../TodosProject/Reports/reportName_"+ timeStamp +".htm";
        //This line is overwrite file with the same file name
        writer = new BufferedWriter(new FileWriter(reportPath, false));

        //This line give the option to append lines and not overwrite on the same file
        writer = new BufferedWriter(new FileWriter(reportPath, true));
        writer.append("<html> \n");
        writer.append("<body> \n");
        writer.append("<samp style='font-size: 120%;'><strong>Elad Shaked</strong></samp> <br> \n");
        writer.append("<samp style='font-size: 300%; color:blue'><strong><center>Automation Report</center></strong></samp> <br> \n");
        writer.append("<center> \n");
        writer.append("<table border='3' cellpadding='8'> \n");
        writer.append("<tr style='font-size: 200%; color:blue'><th>Test Name</th><th>Steps</th><th>Result</th></tr> \n");
    }

    //Check if you add step to exist Test:
    //If you add "testName" to the method, this method will create a new testName
    //If you not add "testName" to the method, you will use the overload method without "testName"
    public static void addStep(String testName, String stepName, boolean isPass) throws IOException {

        if (isPass)
            writer.append("\n<tr style='font-size: 150%;'><td><strong><center>" + testName +
                    "</center></strong></td><td>" + stepName + "</td><td><span style='color:green'><center>Success</center></span></td></tr> \n");

        else
            writer.append("\n<tr style='font-size: 150%;'><td><strong><center>" + testName +
                    "</center></strong></td><td>" + stepName + "</td><td><span style='color:red'><center>Fail</center></span></td></tr> \n");
    }


    public static void addStep(String stepName, boolean isPass) throws IOException {

        if (isPass)
            writer.append("<tr style='font-size: 150%;'><td></td><td>" + stepName + "</td><td><span style='color:green'><center>Success</center></span></td></tr> \n");

        else
            writer.append("<tr style='font-size: 150%;'><td></td><td>" + stepName + "</td><td><span style='color:red'><center>Fail</center></span></td></tr> \n");
    }

    public static void finishReport() throws IOException {
        writer.append("</center> \n");
        writer.append("</table> \n");
        writer.append("</body> \n");
        writer.append("</html> \n");
        writer.close();

    }



}

 