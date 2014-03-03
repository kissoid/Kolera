/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.component.filter;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Adem
 */
public class GitDirectoryFilter implements FileFilter {

    public boolean accept(File file) {
        return !file.getAbsolutePath().endsWith(".git");
    }
}
