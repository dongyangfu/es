package com.es.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: fudy
 * @date: 2021/4/18 下午 07:06
 * @Decription: 获取当前操作的届数
 **/
public class PeriodUtil {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

    /**
     * 获取当前时间的届数
     * @return 2017、2018
     */
    public static String getNowPeriod(){
        // 根据当前时间筛选出今年的学生，如果是21届，2022年春天才会选拔，
        return String.valueOf(Integer.parseInt(sdf.format(new Date()))-1);
    }
}
