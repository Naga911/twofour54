package utilities;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyManager {

    public static String readproperty(String keys) {
        String value = null;
        try (FileReader reader = new FileReader("C:\\twofour54\\twofour54\\src\\configuration.properties")) {

            Properties properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            value = properties.getProperty(keys);
            reader.close();

            Enumeration<Object> enuKeys = properties.keys();

            String key = (String) enuKeys.nextElement();
            String values = properties.getProperty(keys);
            System.out.println(key + ": " + values);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return value;
    }



   /* public Object readBoolean(Object bValue) throws IOException {

        String value = null;

        try (FileReader reader = new FileReader("db.properties")) {
            Properties properties = new Properties();
            try {
                properties.load(reader);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //value = properties.getProperty(bValue);


            reader.close();

            Enumeration<Object> enuKeys = properties.keys();

            String keys = (String) enuKeys.nextElement();
            String values = properties.getProperty(keys);
            System.out.println(bValue + ": " + values);
                *//*if (values instanceof String) {

					value = properties.getProperty((String) values);
					System.out.println(bValue + ": " + value);
				} else if(values instanceof Integer) {

						value = properties.getProperty((String) values);
						int integer= Integer.parseInt(value);
						System.out.println(bValue + ": " + integer);
						}
					else if(values instanceof Boolean) {

						}*//*
        }

        return value;
    }*/
}