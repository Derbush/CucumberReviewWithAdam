package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

        private static Properties properties = new Properties();
        //private so it's not accessable outside of the class
       //static to make sure it's created and loaded before anythisng else

        static {
            try {
                FileInputStream file = new FileInputStream("configuration.properties");
                properties.load(file);
                file.close(); //  close file in the memory

            } catch (IOException e) {
                System.out.println("File is not found with given path");
                e.printStackTrace();
            }
        }

        public static String getProperty (String key){
            return properties.getProperty(key);
        }

}
