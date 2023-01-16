/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;


import org.apache.commons.lang3.StringUtils;
/**
 *
 * @author luisf
 */
public abstract class StringUtil {
    public static final String EMPTY_FIELD =  "";
    
    
    public static boolean isEmpty(String text){
        return StringUtils.isEmpty(text);
    }
    
    public static boolean isNotEmpty(String text){
        return StringUtils.isNotEmpty(text);
    }
}
