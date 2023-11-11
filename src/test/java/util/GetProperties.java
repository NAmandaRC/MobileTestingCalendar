package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private static GetProperties getProperties = null;
    private String device;
    private String deviceName;
    private String platformVersion;
    private String appPackage;
    private String appActivity;
    private GetProperties(){
        Properties properties = new Properties();
        String fileName = "prop.properties";

        InputStream inputStream =getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream!= null){
            try {
                properties.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            device=properties.getProperty("device");
            deviceName=properties.getProperty("deviceName");
            platformVersion=properties.getProperty("platformVersion");
            appPackage=properties.getProperty("appPackage");
            appActivity=properties.getProperty("appActivity");

        }
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static GetProperties getProperties(){
        if (getProperties==null)
            getProperties = new GetProperties();
        return getProperties;
    }

    public String getDevice() {
        return device;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }
}
