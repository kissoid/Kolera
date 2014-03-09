/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.util;

import java.io.File;
import java.io.IOException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 *
 * @author Adem
 */
public class GitUtil {
   
    public static void createGitRepository(String repositoryPath) throws IOException{
        Repository repository = FileRepositoryBuilder.create(new File(repositoryPath, ".git"));
        repository.create();
    }
 
    public static Repository getRepository(String folderPath) throws IOException{
        File file = new File(folderPath);
        FileRepositoryBuilder builder = new FileRepositoryBuilder();
        Repository repository = builder.findGitDir(file).build();
        return repository;
    }
    
}
