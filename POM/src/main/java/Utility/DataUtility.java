package Utility;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtility {


    private static final String Test_Data_File="src/test/resources/TestData/";
    //TODO:reading data from json file

    public static String getJsonFile(String fileName,String field) throws FileNotFoundException {
        FileReader reader=new
                FileReader(Test_Data_File +fileName+".json");
        JsonElement jsonElement= JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }



    //TODO:reading data from properties file
    public static String getPropertiesFile(String fileName, String key ) throws IOException {
        Properties properties= new Properties();
        properties.load(new FileInputStream(Test_Data_File+fileName+".properties"));
        return properties.getProperty(key);
    }


}
