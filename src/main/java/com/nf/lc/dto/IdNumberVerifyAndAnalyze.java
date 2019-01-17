package com.nf.lc.dto;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 身份证号验证以及解析
 */
public class IdNumberVerifyAndAnalyze {

    public static HashMap<String,Object> verifyAndAnalyze(String idNumber){
        HashMap<String, Object> result = new HashMap<>();  //返回数据
        List<String> errors = new ArrayList(); //错误集合

        //分析：是否通过验证、生日、年龄、性别
        // 360731 19991203 3434

        //验证身份证号是否符合规则
        //分割身份证号
        if(!verifyIdNumber(idNumber)){  //验证失败
            errors.add("不是一个正确的身份证号！");
            result.put("errors",errors);
            return result;
        }


        //分析生日
        LocalDate birthday = LocalDate.of(Integer.parseInt(idNumber.substring(6,10)), Integer.parseInt(idNumber.substring(10,12)),
                Integer.parseInt(idNumber.substring(12,14)));

        //将出生日期保存到result
        result.put("birthday",localDateToDate(birthday));

        //将年龄保存到result
        result.put("age",localDateToBetween(birthday));

        //将性别保存到result
        int sexFlag = Integer.parseInt(idNumber.substring(16,17));
        result.put("sexual",sexFlag % 2 == 0 ? "女":"男");

        result.put("errors",errors);
        return result;
    }

    /**
     * 身份证号验证
     * @param idNumber
     * @return
     */
    public static boolean verifyIdNumber(String idNumber){
        //17位数字加最后一位X或数字
        if(!Pattern.matches("\\d{17}(\\d|X)", idNumber)){
            return false;
        }


        int[] factor = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};  //加权因子
        String[] check = new String[]{"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};  //校验码
        int num = 0; //加权因子计算总和

        char[] idNumberChars = idNumber.substring(0,17).toCharArray();

        for (int i = 0; i < idNumberChars.length; i++) {
            num += factor[i] * Integer.parseInt(String.valueOf(idNumberChars[i]));
        }

        if(check[num % 11].equals(idNumber.substring(17,18))){  //最后一位效验字符
            return true;
        }

        return false;
    }

    /**
     * 获得LocalDate类型日期年龄
     * @param birthday
     * @return
     */
    public static int localDateToBetween(LocalDate birthday){
        LocalDate localDate = LocalDate.now();  //当前时间
        Period betweenDate = Period.between(birthday, localDate);
        return betweenDate.getYears();
    }

    /**
     * LocalDate 转 Date
     * @param localDate
     * @return
     */
    public static Date localDateToDate(LocalDate localDate){
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Date result = Date.from(zonedDateTime.toInstant());
        return result;
    }

}
