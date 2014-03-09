/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lantis.kolera.ui.component;

import com.lantis.kolera.ui.component.renderer.JTreeCustomIconRenderer;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author 1001299
 */
public class RepositoryTree extends JTree{
    
    public RepositoryTree(DefaultMutableTreeNode root){
        super(root);
        setCellRenderer(new JTreeCustomIconRenderer());
    }
 
    public RepositoryTree(){
        setCellRenderer(new JTreeCustomIconRenderer());
    }
    
}
