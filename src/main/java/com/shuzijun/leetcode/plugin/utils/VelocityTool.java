package com.shuzijun.leetcode.plugin.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @author shuzijun
 */
public class VelocityTool extends StringUtils {

    private static String[] numsAry = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static String leftPadZeros(String s, int resultLength) {
        if (s.length() >= resultLength) {
            return s;
        }
        int nPads = resultLength - s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nPads; ++i) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }

    public static String camelCaseName(String underscoreName) {

        if (isNotBlank(underscoreName)) {
            underscoreName = underscoreName.replace(" ", "_");
            StringBuilder result = new StringBuilder();
            if (isNumeric(underscoreName.substring(0, 1))) {
                underscoreName = numsAry[Integer.valueOf(underscoreName.substring(0, 1))] + "-" + underscoreName.substring(1);
            }
            boolean first = true;
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ('_' == ch || '-' == ch) {
                    flag = true;
                } else {
                    if (flag || first) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                        first = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
            return result.toString();
        } else {
            return underscoreName;
        }
    }


    public static String snakeCaseName(String underscoreName) {

        if (isNotBlank(underscoreName)) {
            underscoreName = underscoreName.replace(" ", "_");
            StringBuilder result = new StringBuilder();
            for (int i = 0, j = underscoreName.length(); i < j; i++) {
                char ch = underscoreName.charAt(i);
                if ('_' == ch || '-' == ch) {
                    if (i + 1 < j) {
                        result.append("_").append(Character.toLowerCase(underscoreName.charAt(i + 1)));
                        i = i + 1;
                    }
                } else if (Character.isUpperCase(ch)) {
                    result.append("_").append(Character.toLowerCase(underscoreName.charAt(i)));
                } else {
                    result.append(ch);
                }
            }
            return result.toString();
        } else {
            return underscoreName;
        }
    }

    public static String date() {
            return date("yyyy-MM-dd HH:mm:ss");
    }

    public static String date(String format) {
        return DateFormatUtils.format(new Date(), format);
    }

}
