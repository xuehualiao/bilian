package com.itxingrui.utils;

public class StringUtils {


    public static boolean isEmpty(String arg){
        if (arg != null && !arg.equals("")){
            return false;
        }else {
            return true;
        }

    }
}
