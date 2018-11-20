import java.io.*;
import java.util.Properties;

public class ConfigHelpers {

    //region Class Member And Instance
    private final String path = "C://Users//e8823//Desktop/config.properties";
    private InputStream input;
    private Properties properties;
    private String value;
    //endregion



    public Properties buildProp() throws IOException {
        properties = new Properties();
        input = new FileInputStream(path);
        properties.load(input);
        return properties;
    }

    public String getTaskProperties(Properties properties) {

         value = properties.getProperty("task");
        return value;

    }

    public String getUrlPropertice(Properties properties) {
         value = properties.getProperty("url");
        return value;

    }



}



