package com.qa.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UrlFactory {
    private Properties prop;

    public String getEnvironment(){
        prop = new Properties();
        String url = null;
        try{
            FileInputStream envQA = new FileInputStream("./src/test/resources/config/config.properties");
            prop.load(envQA);
            url = prop.getProperty("url");
        }catch (IOException e){
            e.printStackTrace();
        }
        return url;
    }
}
