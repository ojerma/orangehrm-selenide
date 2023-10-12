package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static final String PROP_FILE = "src/main/resources/test.properties"; // skopirovali putj iz test.properties pravoj knopkoj

    private PropertiesLoader(){}
        public static String loadProperties(String name) {
            Properties properties = new Properties();
            try (InputStream input = new FileInputStream(PROP_FILE)) {
                properties.load(input);
            } catch (IOException e){
                e.printStackTrace();
            }

            String value = "";
            if (name != null){
                value = properties.getProperty(name);
            }
            return value;
        }
    }
