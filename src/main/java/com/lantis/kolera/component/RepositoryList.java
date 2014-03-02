/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.component;

import com.lantis.kolera.model.Repository;
import com.lantis.kolera.renderer.JTreeCustomIconRenderer;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author 1001299
 */
public class RepositoryList extends JTree{
    
    public RepositoryList(DefaultMutableTreeNode root){
        super(root);
        setCellRenderer(new JTreeCustomIconRenderer());
    }
 
    public RepositoryList(){
        //setCellRenderer(new JTreeCustomIconRenderer());
    }
    
}
