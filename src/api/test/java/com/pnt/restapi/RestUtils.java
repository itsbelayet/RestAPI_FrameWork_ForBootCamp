package com.pnt.restapi;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    public static String getFirstName(){
        String generatedString= RandomStringUtils.randomAlphabetic(1);
        return ("Mohammed"+generatedString);
    }
    public static String getLasttName(){
        String generatedString= RandomStringUtils.randomAlphanumeric(1);
        return ("Hossain"+generatedString);
    }
    public static String getUsertName(){
        String generatedString= RandomStringUtils.randomAlphanumeric(3);
        return ("Miru"+generatedString);
    }
    public static String getPassword(){
        String generatedString= RandomStringUtils.randomAlphanumeric(3);
        return ("Miru"+generatedString);
    }
    public static String getJob(){
        String generatedString= RandomStringUtils.randomAlphanumeric(3);
        return ("QA"+generatedString);
    }
    public static String getEmail(){
        String generatedString= RandomStringUtils.randomAlphanumeric(5);
        return (generatedString+"@gmail.com");
    }
    public static String getSalary(){
        String generatedString= RandomStringUtils.randomNumeric(5);
        return (generatedString);
    }
    public static String getAge(){
        String generatedString= RandomStringUtils.randomNumeric(2);
        return (generatedString);
    }
}
