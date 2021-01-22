package com.zhuanjingkj.stpbe.tebs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

    private static final Logger log = LoggerFactory.getLogger(PropUtil.class);

    /** 从配置文件中，获取单个属性值*/
    public static String getValue(String name) {
        Properties p = new Properties();
        InputStream inStream = PropUtil.class.getClassLoader().getResourceAsStream("application-ks505.properties");
        String value = "";
        try {
            p.load(inStream);
            value = p.getProperty(name) ;
        } catch (Exception e) {
            log.error("读取属性文件错误:",e);
        }
        return value;
    }
}
