/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.util;

/**
 *
 * @author Adem
 */
public class CommonUtil {
    
    public static boolean isWindowsOS(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.indexOf("win")>=0){
            return true;
        }
        return false;
    }
    
}
