package com.amazon.utils;


import org.apache.log4j.Logger;

import java.util.Arrays;

public class LogUtil {

    public static void logStackTrace(Throwable e, Logger logger){
        Arrays.stream(Arrays.stream(e.getStackTrace()).toArray()).forEach(logger::error);
    }

}
