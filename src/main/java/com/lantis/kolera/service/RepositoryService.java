/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.service;

import com.lantis.kolera.db.controller.RepositoryJpaController;
import com.lantis.kolera.db.entity.Repository;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Adem
 */
public class RepositoryService {
    
    private EntityManagerFactory entityManagerFactory;
    
    private EntityManagerFactory getEmf(){
        if(entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory("koleraPU");
        }
        return entityManagerFactory;
    }
    

    private RepositoryJpaController getRepositoryJpaController(){
        return new RepositoryJpaController(getEmf());
    }
    
    public List<Repository> retrieveRepositories(){
        return getRepositoryJpaController().findAll();
    }
    
    public void createRepository(Repository repository){
        getRepositoryJpaController().create(repository);
    }
    
}
